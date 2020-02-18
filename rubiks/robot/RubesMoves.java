package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class RubesMoves {
	//	Motor Ports
	private static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);
	
	//	Motors
	private static MotorFlip motorFlip     = new MotorFlip(motorPortFlip);
	private static MotorRotate motorRotate = new MotorRotate(motorPortRotate);
	
	//	Moves
	private static final int one   =  1;
	private static final int two   =  2;
	private static final int three = -1;
	
	// null constructor
	public RubesMoves() {}
	
	
	public static void run(String solvedcube) {
		String[] moves = solvedcube.split("\\s+");
		
		for (int i = 0; i < moves.length; i ++) {
			move(moves[i]);
		}
	}
	
	public static void move(String action) {
		switch (action) {
			case "U":
				up(one);
				break;
			case "U2":
				up(two);
				break;
			case "U'":
				up(three);
				break;
				
			case "D":
				down(one);
				break;
			case "D2":
				down(two);
				break;
			case "D'":
				down(three);
				break;

			case "L":
				left(three);
				break;
			case "L2":
				left(two);
				break;
			case "L'":
				left(one);
				break;

			case "R":
				right(three);
				break;
			case "R2":
				right(two);
				break;
			case "R'":
				right(one);
				break;

			case "F":
				front(three);
				break;
			case "F2":
				front(two);
				break;
			case "F'":
				front(one);
				break;

			case "B":
				back(three);
				break;
			case "B2":
				back(two);
				break;
			case "B'":
				back(one);
				break;
		}
	}
	
	private static void rotateLoop(int times) {
		motorFlip.pin();
		
		motorRotate.setRotate(times);
		for (int i = 0; i < times; i++) {
			motorRotate.rotate();
		}
		motorFlip.retract();
	}
	
	private static void up(int times) {
		motorFlip.flip();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
	}
	
	private static void down(int times) {
		rotateLoop(times);
	}

	private static void left(int times) {
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();		
	}

	private static void right(int times) {
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
	}

	private static void front(int times) {
		motorRotate.rotate();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();
		motorRotate.rotateAnti();
	}

	private static void back(int times) {
		motorRotate.rotateAnti();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();
		motorRotate.rotate();
	}
}
