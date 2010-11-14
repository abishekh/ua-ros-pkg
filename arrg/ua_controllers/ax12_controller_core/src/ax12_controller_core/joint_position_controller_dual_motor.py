#!/usr/bin/env python
#
# Software License Agreement (BSD License)
#
# Copyright (c) 2010, Arizona Robotics Research Group,
# University of Arizona. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
#  * Redistributions of source code must retain the above copyright
#    notice, this list of conditions and the following disclaimer.
#  * Redistributions in binary form must reproduce the above
#    copyright notice, this list of conditions and the following
#    disclaimer in the documentation and/or other materials provided
#    with the distribution.
#  * Neither the name of University of Arizona nor the names of its
#    contributors may be used to endorse or promote products derived
#    from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
# BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
# CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
# ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.
#
# Author: Antons Rebguns
# Author: Cara Slutter
#

from __future__ import division

import roslib
roslib.load_manifest('ax12_controller_core')

import rospy
from ax12_driver_core.ax12_const import *
from ax12_driver_core.ax12_user_commands import *
from ax12_controller_core.joint_controller import JointControllerAX12
from ua_controller_msgs.msg import JointState

class JointPositionControllerDualAX12(JointControllerAX12):
    def __init__(self, out_cb, param_path, port_name):
        JointControllerAX12.__init__(self, out_cb, param_path, port_name)
        
        self.master_id = rospy.get_param(self.topic_name + '/motor_master/id')
        self.master_initial_position_raw = rospy.get_param(self.topic_name + '/motor_master/init')
        self.master_min_angle_raw = rospy.get_param(self.topic_name + '/motor_master/min')
        self.master_max_angle_raw = rospy.get_param(self.topic_name + '/motor_master/max')
        
        self.slave_id = rospy.get_param(self.topic_name + '/motor_slave/id')
        
        self.flipped = self.master_min_angle_raw > self.master_max_angle_raw
        
    def initialize(self):
        # verify that the expected motor is connected and responding
        available_ids = rospy.get_param('dynamixel/%s/connected_ids' % self.port_namespace, [])
        if not (self.master_id in available_ids and
                self.slave_id in available_ids):
            rospy.logwarn('The specified motor id is not connected and responding.')
            rospy.logwarn('Available ids: %s' % str(available_ids))
            rospy.logwarn('Specified ids: %d %d' % (self.master_id, self.slave_id))
            return False
            
        self.radians_per_encoder_tick = rospy.get_param('dynamixel/%s/%d/radians_per_encoder_tick' % (self.port_namespace, self.master_id))
        self.encoder_ticks_per_radian = rospy.get_param('dynamixel/%s/%d/encoder_ticks_per_radian' % (self.port_namespace, self.master_id))
        
        if self.flipped:
            self.master_min_angle = (self.master_initial_position_raw - self.master_min_angle_raw) * self.radians_per_encoder_tick
            self.master_max_angle = (self.master_initial_position_raw - self.master_max_angle_raw) * self.radians_per_encoder_tick
        else:
            self.master_min_angle = (self.master_min_angle_raw - self.master_initial_position_raw) * self.radians_per_encoder_tick
            self.master_max_angle = (self.master_max_angle_raw - self.master_initial_position_raw) * self.radians_per_encoder_tick
            
        self.encoder_resolution = rospy.get_param('dynamixel/%s/%d/encoder_resolution' % (self.port_namespace, self.master_id))
        self.max_position = self.encoder_resolution - 1
        self.set_speed(self.joint_speed)
        self.set_compliance_slope(self.compliance_slope)
        return True
        
    def set_speed(self, speed):
        if speed < DMXL_MIN_SPEED_RAD: speed = DMXL_MIN_SPEED_RAD
        elif speed > DMXL_MAX_SPEED_RAD: speed = DMXL_MAX_SPEED_RAD
        speed_raw = int(round(speed / DMXL_SPEED_RAD_SEC_PER_TICK))
        mcv_master = (self.master_id, speed_raw if speed_raw > 0 else 1)
        mcv_slave = (self.slave_id, mcv_master[1])
        self.send_packet_callback((DMXL_SET_GOAL_SPEED, [mcv_master, mcv_slave]))
        
    def set_compliance_slope(self, slope):
        if slope < 2: slope = 2
        elif slope > 128: slope = 128
        slope2 = (slope << 8) + slope
        mcv_master = (self.master_id, slope2)
        mcv_slave = (self.slave_id, slope2)
        self.send_packet_callback((DMXL_SET_COMPLIANCE_SLOPE, [mcv_master, mcv_slave]))
        
    def process_set_speed(self, req):
        self.set_speed(req.speed)
        return []
        
    def process_torque_enable(self, req):
        mcv_master = (self.master_id, req.torque_enable)
        mcv_slave = (self.slave_id, req.torque_enable)
        self.send_packet_callback((DMXL_SET_TORQUE_ENABLE, [mcv_master, mcv_slave]))
        return []
        
    def process_set_compliance_slope(self, req):
        self.set_compliance_slope(req.slope)
        return []
        
    def process_motor_states(self, state_list):
        if self.running:
            state = filter(lambda state: state.id == self.master_id, state_list.motor_states)
            if state:
                state = state[0]
                joint_state = JointState(name=self.joint_name,
                                         motor_ids=[self.master_id],
                                         goal_pos=self.raw_to_rad(state.goal, self.master_initial_position_raw, self.flipped, self.radians_per_encoder_tick),
                                         current_pos=self.raw_to_rad(state.position, self.master_initial_position_raw, self.flipped, self.radians_per_encoder_tick),
                                         error=state.error * self.radians_per_encoder_tick,
                                         velocity=(state.speed / self.encoder_resolution) * DMXL_MAX_SPEED_RAD,
                                         load=state.load,
                                         is_moving=state.moving)
                joint_state.header.stamp = rospy.Time.from_sec(state.timestamp)
                self.joint_state_pub.publish(joint_state)
                
    def process_command(self, msg):
        angle = msg.data
        if angle < self.master_min_angle: angle = self.master_min_angle
        elif angle > self.master_max_angle: angle = self.master_max_angle
        mcv_master = (self.master_id, self.rad_to_raw(angle, self.master_initial_position_raw, self.flipped, self.encoder_ticks_per_radian))
        mcv_slave = (self.slave_id, self.max_position - mcv_master[1])
        self.send_packet_callback((DMXL_SET_GOAL_POSITION, [mcv_master, mcv_slave]))

