;;; GBBopen Blackboard Repository (saved Tue, 29 Jun 2010 15:22:22 -0700 (MST))
(4 3486838942 :COMMON-LISP-USER SINGLE-FLOAT)
NIL
;;; Saved repository format version:
5
;;; Important values:
(0 ((GBBOPEN:STANDARD-SPACE-INSTANCE . 3) (SIMULATION_SEMANTICS::PHYSICAL-OBJECT . 15) (SIMULATION_SEMANTICS::ROBOT . 1) (SIMULATION_SEMANTICS::SIMULATOR . 13)))
;;; Space instances:
(#GR(GBBOPEN:STANDARD-SPACE-INSTANCE (SIMULATION_SEMANTICS::RUNNING-SIMULATORS)) #GR(GBBOPEN:STANDARD-SPACE-INSTANCE (SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) #GR(GBBOPEN:STANDARD-SPACE-INSTANCE (SIMULATION_SEMANTICS::OBJECT-LIBRARY)))
#GD(GBBOPEN:STANDARD-SPACE-INSTANCE GBBOPEN:INSTANCE-NAME GBBOPEN::%%SPACE-INSTANCES%% GBBOPEN:DIMENSIONS GBBOPEN::ALLOWED-UNIT-CLASSES GBBOPEN::%%STORAGE-SPEC%% GBBOPEN::%%BY-UNIT-CLASS-STORAGE%% GBBOPEN::%%MAPPING-STORAGE%% GBBOPEN::%%RETRIEVAL-STORAGE%% GBBOPEN::%%EVFN-UNIT-HT%% GBBOPEN:CHILDREN GBBOPEN:PARENT)
#GI(GBBOPEN:STANDARD-SPACE-INSTANCE (SIMULATION_SEMANTICS::RUNNING-SIMULATORS) NIL NIL T NIL NIL NIL NIL (0) NIL NIL)
#GI(GBBOPEN:STANDARD-SPACE-INSTANCE (SIMULATION_SEMANTICS::SIMULATOR-LIBRARY) NIL NIL T NIL NIL NIL NIL (0) NIL NIL)
#GI(GBBOPEN:STANDARD-SPACE-INSTANCE (SIMULATION_SEMANTICS::OBJECT-LIBRARY) NIL ((SIMULATION_SEMANTICS::GAZEBO-NAME (:ENUMERATED EQL)) (SIMULATION_SEMANTICS::STATIC? (:BOOLEAN T))) T NIL NIL NIL NIL (0) NIL NIL)
;;; Other unit instances:
#GD(SIMULATION_SEMANTICS::SIMULATOR GBBOPEN:INSTANCE-NAME GBBOPEN::%%SPACE-INSTANCES%% SIMULATION_SEMANTICS::OBJECTS SIMULATION_SEMANTICS::GOAL-MAP SIMULATION_SEMANTICS::POLICY-MAP SIMULATION_SEMANTICS::TERMINATION-TIME SIMULATION_SEMANTICS::CURRENT-TIME SIMULATION_SEMANTICS::SIMULATIONS SIMULATION_SEMANTICS::SUPPRESSED-OBJECTS)
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::FREE ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR PUSH ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FRONT-BOX)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::CARRY ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ABOVE-BOX)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR BLOCK ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::STUCK-BOX)) #GH(EQ 0 T) #GH(EQL 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::SEEK-GOAL-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::DOUBLE-BLOCK ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::STUCK-BOX) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FRONT-BOX)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::PUSH-SPHERE ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::SPHERE)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::CARRY-SPHERE ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ABOVE-SPHERE)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::HILL ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::SPHERE) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::RAMP)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::DEMO-POLICY) 30 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::GAP ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FLOOR1) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FLOOR2) #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::BRIDGE ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FLOOR1) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FLOOR2) #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::BRIDGE-BOX)) #GH(EQ 0 T) #GH(EQ 1 T #GR(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT) SIMULATION_SEMANTICS::MOVE-FORWARD-POLICY) 15 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::STACK ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::TOP-BOX) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::BOTTOM-BOX)) #GH(EQ 0 T) #GH(EQ 0 T) 3 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::DOWNHILL ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ROLLING-BALL) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::MINI-RAMP)) #GH(EQ 0 T) #GH(EQ 0 T) 10 0 NIL #GH(EQ 0 T))
#GI(SIMULATION_SEMANTICS::SIMULATOR SIMULATION_SEMANTICS::DOWNHILL-BLOCK ((SIMULATION_SEMANTICS::SIMULATOR-LIBRARY)) (#GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ROLLING-BALL) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::MINI-RAMP) #GR(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::HILL-OBSTACLE)) #GH(EQ 0 T) #GH(EQ 0 T) 10 0 NIL #GH(EQ 0 T))
#GD(SIMULATION_SEMANTICS::ROBOT GBBOPEN:INSTANCE-NAME GBBOPEN::%%SPACE-INSTANCES%% SIMULATION_SEMANTICS::GAZEBO-NAME SIMULATION_SEMANTICS::XYZ SIMULATION_SEMANTICS::RPY SIMULATION_SEMANTICS::DEFAULT-XYZ SIMULATION_SEMANTICS::SELF-PREDICATES SIMULATION_SEMANTICS::BINARY-PREDICATES SIMULATION_SEMANTICS::XML-STRING SIMULATION_SEMANTICS::VEL-PUB SIMULATION_SEMANTICS::INTENDED-VELOCITY)
#GI(SIMULATION_SEMANTICS::ROBOT SIMULATION_SEMANTICS::ROBOT ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"base_footprint" (0 0 0.6) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIST-TO-GOAL SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::INT-VEL SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) NIL NIL (0.5 0.0))
#GD(SIMULATION_SEMANTICS::PHYSICAL-OBJECT GBBOPEN:INSTANCE-NAME GBBOPEN::%%SPACE-INSTANCES%% SIMULATION_SEMANTICS::GAZEBO-NAME SIMULATION_SEMANTICS::XYZ SIMULATION_SEMANTICS::RPY SIMULATION_SEMANTICS::DEFAULT-XYZ SIMULATION_SEMANTICS::SELF-PREDICATES SIMULATION_SEMANTICS::BINARY-PREDICATES SIMULATION_SEMANTICS::XML-STRING SIMULATION_SEMANTICS::SHAPE SIMULATION_SEMANTICS::COLOR SIMULATION_SEMANTICS::SIZE SIMULATION_SEMANTICS::MASS SIMULATION_SEMANTICS::STATIC?)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FRONT-BOX ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"front_box" (0.5 0 0.3) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::FORCE-MAG SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::X-POS) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"front_box_model\"><xyz>0.5 0 0.3 </xyz><rpy>0 0 0 </rpy><static>false</static><body:box name=\"front_box\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"front_box_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>0.3 0.3 0.3 </size><mass>1000.0</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>0.3 0.3 0.3 </scale><mesh>unit_box</mesh><material>WubbleWorld/Blue</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"WubbleWorld/Blue" 0.3 1000.0 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ABOVE-BOX ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"above_box" (0 0 0.4) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::FORCE-MAG SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::X-POS) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"above_box_model\"><xyz>0 0 0.4 </xyz><rpy>0 0 0 </rpy><static>false</static><body:box name=\"above_box\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"above_box_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>0.2 0.2 0.2 </size><mass>5.0</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>0.2 0.2 0.2 </scale><mesh>unit_box</mesh><material>Gazebo/Blue</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Blue" 0.2 5.0 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::STUCK-BOX ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"stuck_box" (1.0 0 0.25) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::FORCE-MAG SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::X-POS) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"stuck_box_model\"><xyz>1.0 0 0.5 </xyz><rpy>0 0 0 </rpy><static>true</static><body:box name=\"stuck_box\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"stuck_box_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>0.5 5.0 0.5 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>0.5 5.0 0.5 </scale><mesh>unit_box</mesh><material>Gazebo/Red</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Red" (0.5 5.0 0.5) 0.2 T)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::SPHERE ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"the_sphere" (0.5 0 0.3) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::FORCE-MAG SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Z-VEL) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"the_sphere_model\"><xyz>0.5 0 0.3 </xyz><rpy>0 0 0 </rpy><static>false</static><body:sphere name=\"the_sphere\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:sphere name=\"the_sphere_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>0.3</size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>0.3 0.3 0.3 </scale><mesh>unit_sphere</mesh><material>Gazebo/Blue</material></visual></geom:sphere></body:sphere></model:physical>" SIMULATION_SEMANTICS::SPHERE #G"Gazebo/Blue" 0.3 0.2 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ABOVE-SPHERE ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"above_sphere" (0.0 0 0.4) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::FORCE-MAG SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::X-POS) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"above_sphere_model\"><xyz>0.0 0 0.4 </xyz><rpy>0 0 0 </rpy><static>false</static><body:sphere name=\"above_sphere\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:sphere name=\"above_sphere_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>0.1</size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>0.1 0.1 0.1 </scale><mesh>unit_sphere</mesh><material>Gazebo/Blue</material></visual></geom:sphere></body:sphere></model:physical>" SIMULATION_SEMANTICS::SPHERE #G"Gazebo/Blue" 0.1 0.2 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::RAMP ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"ramp" (4 0 0.1) (0 -10 0) (0 0 0) NIL (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"ramp_model\"><xyz>4 0 0.1 </xyz><rpy>0 -10 0 </rpy><static>true</static><body:box name=\"ramp\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"ramp_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>100 100 0.1 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>100 100 0.1 </scale><mesh>unit_box</mesh><material>Gazebo/Green</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Green" (100 100 0.1) 0.2 T)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FLOOR1 ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"floor_1" (0.0 0.0 0.25) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"floor_1_model\"><xyz>0.0 0.0 0.5 </xyz><rpy>0 0 0 </rpy><static>true</static><body:box name=\"floor_1\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"floor_1_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>5.0 5.0 0.5 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>5.0 5.0 0.5 </scale><mesh>unit_box</mesh><material>Gazebo/Green</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Green" (5.0 5.0 0.5) 0.2 T)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::FLOOR2 ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"floor_2" (6.0 0.0 0.25) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"floor_2_model\"><xyz>6.0 0.0 0.5 </xyz><rpy>0 0 0 </rpy><static>true</static><body:box name=\"floor_2\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"floor_2_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>5.0 5.0 0.5 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>5.0 5.0 0.5 </scale><mesh>unit_box</mesh><material>Gazebo/Green</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Green" (5.0 5.0 0.5) 0.2 T)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::BRIDGE-BOX ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"bridge" (3 0 0.4) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"bridge_model\"><xyz>3 0 0.2 </xyz><rpy>0 0 0 </rpy><static>true</static><body:box name=\"bridge\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"bridge_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>1.0 1.0 0.2 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>1.0 1.0 0.2 </scale><mesh>unit_box</mesh><material>Gazebo/Red</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Red" (1.0 1.0 0.2) 0.2 T)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::TOP-BOX ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"top_box" (3 0 1.5) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"top_box_model\"><xyz>3 0 1.0 </xyz><rpy>0 0 0 </rpy><static>false</static><body:box name=\"top_box\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"top_box_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>1.0 1.0 1.0 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>1.0 1.0 1.0 </scale><mesh>unit_box</mesh><material>Gazebo/Blue</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Blue" 1.0 0.2 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::BOTTOM-BOX ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"bottom_box" (3 0 0.5) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"bottom_box_model\"><xyz>3 0 1.0 </xyz><rpy>0 0 0 </rpy><static>false</static><body:box name=\"bottom_box\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"bottom_box_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>1.0 1.0 1.0 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>1.0 1.0 1.0 </scale><mesh>unit_box</mesh><material>Gazebo/Green</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Green" 1.0 0.2 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::SELF ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"self" (0 0 0.1) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::FORCE-MAG SIMULATION_SEMANTICS::VEL-MAG SIMULATION_SEMANTICS::DIST-TO-GOAL SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::DIFF-SPEED) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?><model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"self_model\"><xyz>0 0 0.1 </xyz><rpy>0 0 0 </rpy><static>false</static><body:box name=\"self\"><turnGravityOff>false</turnGravityOff><dampingFactor>0.01</dampingFactor><selfCollide>false</selfCollide><massMatrix>true</massMatrix><mass>0.2</mass><ixx>0.1</ixx><ixy>0.0</ixy><ixz>0.0</ixz><iyy>0.1</iyy><iyz>0.0</iyz><izz>0.1</izz><cx>0.0</cx><cy>0.0</cy><cz>0.0</cz><xyz>0 0 0</xyz><rpy>0 0 0</rpy><geom:box name=\"self_geom\"><mu1>1.0</mu1><mu2>1.0</mu2><kp>100000000.0</kp><kd>1.0</kd><size>0.2 0.2 0.2 </size><mass>0.2</mass><visual><xyz>0 0 0</xyz><rpy>0 0 0</rpy><scale>0.2 0.2 0.2 </scale><mesh>unit_box</mesh><material>Gazebo/Green</material></visual></geom:box></body:box></model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Green" 0.2 0.2 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::MINI-RAMP ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"mini_ramp" (1.0 0 0.25) (0 30 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?>
<model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"mini_ramp_model\">
  <xyz>1.0 0 0.25 </xyz>
  <rpy>0 30 0 </rpy>
  <static>true</static>
  <body:box name=\"mini_ramp\">
    <turnGravityOff>false</turnGravityOff>
    <dampingFactor>0.01</dampingFactor>
    <selfCollide>false</selfCollide>
    <massMatrix>true</massMatrix>
    <mass>0.2</mass>
    <ixx>0.1</ixx>
    <ixy>0.0</ixy>
    <ixz>0.0</ixz>
    <iyy>0.1</iyy>
    <iyz>0.0</iyz>
    <izz>0.1</izz>
    <cx>0.0</cx>
    <cy>0.0</cy>
    <cz>0.0</cz>
    <xyz>0 0 0</xyz>
    <rpy>0 30 0 </rpy>
    <geom:box name=\"mini_ramp_geom\">
      <mu1>1.0</mu1>
      <mu2>1.0</mu2>
      <kp>100000000.0</kp>
      <kd>1.0</kd>
      <size>10 5 0.25 </size>
      <mass>0.2</mass>
      <visual>
        <xyz>0 0 0</xyz>
        <rpy>0 0 0</rpy>
        <scale>10 5 0.25 </scale>
        <mesh>unit_box</mesh>
        <material>Gazebo/Green</material>
      </visual>
    </geom:box>
  </body:box>
</model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Green" (10 5 0.25) 0.2 T)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::ROLLING-BALL ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"rolling_ball" (-2.5 0 2.7) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?>
<model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"rolling_ball_model\">
  <xyz>-2.5 0 2.7 </xyz>
  <rpy>0 0 0 </rpy>
  <static>false</static>
  <body:sphere name=\"rolling_ball\">
    <turnGravityOff>false</turnGravityOff>
    <dampingFactor>0.01</dampingFactor>
    <selfCollide>false</selfCollide>
    <massMatrix>true</massMatrix>
    <mass>5.0</mass>
    <ixx>0.1</ixx>
    <ixy>0.0</ixy>
    <ixz>0.0</ixz>
    <iyy>0.1</iyy>
    <iyz>0.0</iyz>
    <izz>0.1</izz>
    <cx>0.0</cx>
    <cy>0.0</cy>
    <cz>0.0</cz>
    <xyz>0 0 0</xyz>
    <rpy>0 0 0 </rpy>
    <geom:sphere name=\"rolling_ball_geom\">
      <mu1>1.0</mu1>
      <mu2>1.0</mu2>
      <kp>100000000.0</kp>
      <kd>1.0</kd>
      <size>0.2</size>
      <mass>5.0</mass>
      <visual>
        <xyz>0 0 0</xyz>
        <rpy>0 0 0</rpy>
        <scale>0.2 0.2 0.2 </scale>
        <mesh>unit_sphere</mesh>
        <material>Gazebo/Blue</material>
      </visual>
    </geom:sphere>
  </body:sphere>
</model:physical>" SIMULATION_SEMANTICS::SPHERE #G"Gazebo/Blue" 0.2 5.0 NIL)
#GI(SIMULATION_SEMANTICS::PHYSICAL-OBJECT SIMULATION_SEMANTICS::HILL-OBSTACLE ((SIMULATION_SEMANTICS::OBJECT-LIBRARY)) #G"hill_barrier" (0 0 1.0) (0 0 0) (0 0 0) (SIMULATION_SEMANTICS::DIFF-SPEED SIMULATION_SEMANTICS::X-POS SIMULATION_SEMANTICS::Y-POS SIMULATION_SEMANTICS::Z-POS SIMULATION_SEMANTICS::X-VEL SIMULATION_SEMANTICS::Y-VEL SIMULATION_SEMANTICS::Z-VEL SIMULATION_SEMANTICS::FORCE-MAG) (SIMULATION_SEMANTICS::DIST-BETWEEN) #G"<?xml version=\"1.0\"?>
<model:physical xmlns:gazebo=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#gz\" xmlns:model=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#model\" xmlns:sensor=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#sensor\" xmlns:body=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#body\" xmlns:geom=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#geom\" xmlns:joint=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#joint\" xmlns:controller=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#controller\" xmlns:interface=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#interface\" xmlns:rendering=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#rendering\" xmlns:physics=\"http://playerstage.sourceforge.net/gazebo/xmlschema/#physics\" name=\"hill_barrier_model\">
  <xyz>0 0 1.0 </xyz>
  <rpy>0 0 0 </rpy>
  <static>true</static>
  <body:box name=\"hill_barrier\">
    <turnGravityOff>false</turnGravityOff>
    <dampingFactor>0.01</dampingFactor>
    <selfCollide>false</selfCollide>
    <massMatrix>true</massMatrix>
    <mass>0.2</mass>
    <ixx>0.1</ixx>
    <ixy>0.0</ixy>
    <ixz>0.0</ixz>
    <iyy>0.1</iyy>
    <iyz>0.0</iyz>
    <izz>0.1</izz>
    <cx>0.0</cx>
    <cy>0.0</cy>
    <cz>0.0</cz>
    <xyz>0 0 0</xyz>
    <rpy>0 0 0 </rpy>
    <geom:box name=\"hill_barrier_geom\">
      <mu1>1.0</mu1>
      <mu2>1.0</mu2>
      <kp>100000000.0</kp>
      <kd>1.0</kd>
      <size>0.25 1.0 1.0 </size>
      <mass>0.2</mass>
      <visual>
        <xyz>0 0 0</xyz>
        <rpy>0 0 0</rpy>
        <scale>0.25 1.0 1.0 </scale>
        <mesh>unit_box</mesh>
        <material>Gazebo/Red</material>
      </visual>
    </geom:box>
  </body:box>
</model:physical>" SIMULATION_SEMANTICS::BOX #G"Gazebo/Red" (0.25 1.0 1.0) 0.2 T)
;;; Unit-class states:
#GM(GBBOPEN:STANDARD-SPACE-INSTANCE 0)
#GM(SIMULATION_SEMANTICS::SIMULATOR 0)
#GM(SIMULATION_SEMANTICS::ROBOT 0)
#GM(SIMULATION_SEMANTICS::PHYSICAL-OBJECT 0)
;;; End of file