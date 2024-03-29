/*
 * teleop_base_keyboard
 * Copyright (c) 2008, Willow Garage, Inc.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <ORGANIZATION> nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

#include <termios.h>
#include <signal.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/poll.h>

#include <boost/thread/thread.hpp>
#include <ros/ros.h>
#include <geometry_msgs/Twist.h>

#define KEYCODE_W 0x77
#define KEYCODE_A 0x61
#define KEYCODE_S 0x73
#define KEYCODE_D 0x64

#define KEYCODE_COMMA 0x2c
#define KEYCODE_PERIOD 0x2e

double max_speed = 1.000; // m/second
double max_turn = 60.0*M_PI/180.0; // rad/second

class TBK_Node
{
  private:
    geometry_msgs::Twist cmdvel;
    ros::NodeHandle n_;
    ros::Publisher pub_;

  public:
    TBK_Node()
    {
      pub_ = n_.advertise<geometry_msgs::Twist>("cmd_vel",1);
    }
    ~TBK_Node() { }
    void keyboardLoop();
    void stopRobot()
    {
      cmdvel.linear.x = cmdvel.angular.z = 0.0;
      pub_.publish(cmdvel);
    }
};

TBK_Node* tbk;
int kfd = 0;
struct termios cooked, raw;
bool done;

int
main(int argc, char** argv)
{
  ros::init(argc,argv,"tbk", ros::init_options::AnonymousName | ros::init_options::NoSigintHandler);
  TBK_Node tbk;
  
  boost::thread t = boost::thread(boost::bind(&TBK_Node::keyboardLoop, &tbk));
  
  ros::spin();
  
  t.interrupt();
  t.join();
  tbk.stopRobot();
  tcsetattr(kfd, TCSANOW, &cooked);
  
  return(0);
}

void
TBK_Node::keyboardLoop()
{
  char c;
  double max_tv = max_speed;
  double max_rv = max_turn;
  bool dirty=false;
  
  int speed=0;
  int turn=0;
  
  // get the console in raw mode
  tcgetattr(kfd, &cooked);
  memcpy(&raw, &cooked, sizeof(struct termios));
  raw.c_lflag &=~ (ICANON | ECHO);
  raw.c_cc[VEOL] = 1;
  raw.c_cc[VEOF] = 2;
  tcsetattr(kfd, TCSANOW, &raw);
  
  puts("Reading from keyboard");
  puts("Use WASD keys to control the robot");
  
  struct pollfd ufd;
  ufd.fd = kfd;
  ufd.events = POLLIN;
  for(;;)
  {
    boost::this_thread::interruption_point();
    
    // get the next event from the keyboard
    int num;
    if((num = poll(&ufd, 1, 250)) < 0)
    {
      perror("poll():");
      return;
    }
    else if(num > 0)
    {
      if(read(kfd, &c, 1) < 0)
      {
        perror("read():");
        return;
      }
    }
    else
    {
      if (dirty == true)
      {
        stopRobot();
        dirty = false;
      }
      
      continue;
    }
    
    switch(c)
    {
    case KEYCODE_W:
      speed = 1;
      turn = 0;
      dirty = true;
      break;
    case KEYCODE_A:
      speed = 0;
      turn = 1;
      dirty = true;
      break;
    case KEYCODE_S:
      speed = -1;
      turn = 0;
      dirty = true;
      break;
    case KEYCODE_D:
      speed = 0;
      turn = -1;
      dirty = true;
      break;
    default:
      speed = 0;
      turn = 0;
      dirty = false;
    }
    
    cmdvel.linear.x = speed * max_tv;
    cmdvel.angular.z = turn * max_rv;
    pub_.publish(cmdvel);
  }
}
