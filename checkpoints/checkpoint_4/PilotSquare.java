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
		Path path = new Path();
		path.add(new Waypoint(50, 0));
		path.add(new Waypoint(50, 50));
		path.add(new Waypoint(0, 50));
		path.add(new Waypoint(0, 0));
		navigator.followPath(path);
		navigator.waitForStop();


		LCD.clear();

		LCD.drawString("Path Finished!", 2, 2);
		mLeft.close();
		mRight.close();
	}

}
