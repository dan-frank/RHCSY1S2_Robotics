import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class GucciMain {

	public static void main(String[] args) {
		Delay.msDelay(1000);
		System.out.println("Rube starts his long and arduous journey...");

		FriendCube friendCube = new FriendCube();
		FriendMove friendMove = new FriendMove();
		FriendScan friendScan = new FriendScan();

		MotorRotate motorRotate = new MotorRotate(friendMove);
		MotorFlip motorFlip = new MotorFlip(friendMove);
		MotorColour motorColour = new MotorColour(friendScan);
		
		EV3ColorSensor colourSensor = new EV3ColorSensor(SensorPort.S2);
		//EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
		Delay.msDelay(1000);
		System.out.println("Rube made some friends along the way...");
		
		friendCube.setScrambledCube("DFDUUDRULURLDRBDLRFRFDFLLBBBDRLDBRFFLLUBLFBFUBUFRBUDRU");
		Delay.msDelay(1000);
		System.out.println("Rube made fake friends...");
		
//		Behavior runningController = new BehaviourRunningController(friendCube, sensorUltrasonic);
		
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
		System.out.println("Rube developed behaviours...");
		
		//Reset all Motor Positions

		Behavior[] behaviours = new Behavior[] { scanController, scanActionCenter, solveControler, moveController, moveActionUp, moveActionDown, moveActionLeft, moveActionRight, moveActionFront, moveActionBack, }; //runningController };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
		System.out.println("Rube met arby...");
		arby.go();
	}

}