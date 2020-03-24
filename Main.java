import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {
		Delay.msDelay(1000);
//		System.out.println("Rube starts his long and arduous journey...");

		LCD.clear();
		LCD.drawString("Rube the Robot!", 0, 1);
		LCD.drawString("- Lewes Block", 0, 2);
		LCD.drawString("- Megan Hardman", 0, 3);
		LCD.drawString("- Daniel Lucas", 0, 4);
		LCD.drawString("- Rumen Yonkov", 0, 5);
		LCD.drawString("Version: 4.0.0", 0, 6);
		
		// Init friends
		FriendCube friendCube = new FriendCube();
		FriendMove friendMove = new FriendMove();
		FriendScan friendScan = new FriendScan();

		// Init motors
		MotorRotate motorRotate = new MotorRotate(friendMove);
		MotorFlip motorFlip = new MotorFlip(friendMove);
		MotorColour motorColour = new MotorColour(friendScan);
		
		// Init sensors
		EV3ColorSensor colourSensor = new EV3ColorSensor(SensorPort.S2);
		EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
		Delay.msDelay(1000);
//		System.out.println("Rube made some friends along the way...");
		
		// Init behaviours
		Behavior endController = new BehaviourEndController(friendCube, friendMove, friendScan);
		
		Behavior runningController = new BehaviourRunningController(friendCube, sensorUltrasonic);
		
		Behavior scanController = new BehaviourScanController(friendCube, friendMove, friendScan, motorColour, motorRotate, motorFlip, colourSensor);
		Behavior scanActionCenter = new BehaviourScanActionCenter(friendScan, motorColour);

		Behavior solveControler = new BehaviourSolveController(friendCube);
		
		Behavior moveController = new BehaviourMoveController(friendCube, friendMove);
		Behavior moveActionUp = new BehaviourMoveActionUp(friendMove, motorRotate, motorFlip);
		Behavior moveActionDown = new BehaviourMoveActionDown(friendMove, motorRotate, motorFlip);
		Behavior moveActionLeft = new BehaviourMoveActionLeft(friendMove, motorRotate, motorFlip);
		Behavior moveActionRight = new BehaviourMoveActionRight(friendMove, motorRotate, motorFlip);
		Behavior moveActionFront = new BehaviourMoveActionFront(friendMove, motorRotate, motorFlip);
		Behavior moveActionBack = new BehaviourMoveActionBack(friendMove, motorRotate, motorFlip);
		Delay.msDelay(1000);
//		System.out.println("Rube developed behaviours...");

		// Init arbitrator
		Behavior[] behaviours = new Behavior[] { scanController, scanActionCenter, solveControler, moveController, moveActionUp, moveActionDown, moveActionLeft, moveActionRight, moveActionFront, moveActionBack, runningController, endController };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
//		System.out.println("Rube met arby...");
		arby.go();
	}

}