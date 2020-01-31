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
	
	public static void main(String[] args) {
// Wheel Diameter 60mm, both wheels set 29mm from car centre
		BaseRegulatedMotor mLeft = new EV3LargeRegulatedMotor(MotorPort.A);
		BaseRegulatedMotor mRight = new EV3LargeRegulatedMotor(MotorPort.B);
		Wheel wL = WheeledChassis.modelWheel(mLeft, 56).offset(-73.5);

		Wheel wR = WheeledChassis.modelWheel(mRight, 56).offset(73.5);
		Wheel[] ws = new Wheel[] { wR, wL };
		Chassis chassis = new WheeledChassis(ws, WheeledChassis.TYPE_DIFFERENTIAL);
		MovePilot plt = new MovePilot(chassis);
		//plt.setAngularSpeed(200);
		//plt.setLinearSpeed(360);
		PoseProvider poseProvider = new OdometryPoseProvider(plt);
		Navigator navigator = new Navigator(plt, poseProvider);
		Path path = new Path();
		path.add(new Waypoint(100, 0));
		path.add(new Waypoint(100, 100));
		path.add(new Waypoint(0, 100));
		path.add(new Waypoint(0, 0));
		navigator.followPath(path);
		navigator.waitForStop();

//		for (int side = 0; side < 4; side++) {
//			plt.travel(300);
//			plt.rotate(90);
//		}
		LCD.clear();

		LCD.drawString("Path Finished!", 2, 2);
		mLeft.close();
		mRight.close();
	}

}
