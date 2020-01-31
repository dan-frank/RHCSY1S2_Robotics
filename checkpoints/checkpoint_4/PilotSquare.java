package checkpoints.checkpoint_4;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.Path;

public class PilotSquare {
	final static float WHEELDIAMETER = 56; // The diameter (mm) of the wheels
	final static float WHEELTHICKNESS = 26; // The diameter (mm) of the wheels
	final static float AXLELENGTH = 147 - WHEELTHICKNESS; // The distance (mm) your two driven wheels
	final static float ANGULARSPEED = 100; // How fast around corners (degrees/sec)
	final static float LINEARSPEED = 70; // How fast in a straight line (mm/sec)
	
	public static void main(String[] args) {
// Wheel Diameter 60mm, both wheels set 29mm from car centre
		BaseRegulatedMotor mLeft = new EV3LargeRegulatedMotor(MotorPort.A);
		BaseRegulatedMotor mRight = new EV3LargeRegulatedMotor(MotorPort.B);
	
		Wheel wL = WheeledChassis.modelWheel(motorL, WHEELDIAMETER).offset(-AXLELENGTH / 2);
		
		Wheel wR = WheeledChassis.modelWheel(motorL, WHEELDIAMETER).offset(AXLELENGTH / 2);
		Wheel[] ws = new Wheel[] { wR, wL };
		Chassis chassis = new WheeledChassis(ws, WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot plt = new MovePilot(chassis);
	
		PoseProvider poseProvider = new OdometryPoseProvider(plt);
		Navigator navigator = new Navigator(plt, poseProvider);
		
		Line [] lines = new Line[4];
		lines[0]= new Line (210,0,210, 620);
		lines[1]= new Line (210, 620, 380,620);
		lines[2]= new Line (380,620, 380, 0);
		lines[3]= new Line (210,0,380,0);
		Rectangle bounds = new Rectangle (-50,-50, 800,600);
		|
		LineMap map = new LineMap (lines,bounds);
		PathFinder pf = new ShortestPathFinder(map);
		Path path =pf.findRoute(new Pose(130,150,90),new Waypoint(480,200));
		navigator.followPath(path);
		
		navigator.waitForStop();


		LCD.clear();

		LCD.drawString("Path Finished!", 2, 2);
		mLeft.close();
		mRight.close();
	}

}
