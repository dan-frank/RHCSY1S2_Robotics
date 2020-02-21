package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class MoveRube {
	//	Motor Ports
	private static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);
	
	//	Motors
	private static MotorFlip motorFlip     = new MotorFlip(motorPortFlip);
	private static MotorRotate motorRotate = new MotorRotate(motorPortRotate);
	
	//	Moves
	private static final int clockwise     =  1;
	private static final int spin         =  2;
	private static final int anticlockwise = -1;
	
	public static void run(String solvedcube) {
		String[] moves = solvedcube.split("\\s+");
		
		for (int i = 0; i < moves.length; i++) {
			move(moves[i]);
		}
	}
	
	public static void move(String action) {
		switch (action) {
			case "U":
				up(clockwise);
				break;
			case "U2":
				up(spin);
				break;
			case "U'":
				up(anticlockwise);
				break;
				
			case "D":
				down(clockwise);
				break;
			case "D2":
				down(spin);
				break;
			case "D'":
				down(anticlockwise);
				break;

			case "L":
				left(anticlockwise);
				break;
			case "L2":
				left(spin);
				break;
			case "L'":
				left(clockwise);
				break;

			case "R":
				right(anticlockwise);
				break;
			case "R2":
				right(spin);
				break;
			case "R'":
				right(clockwise);
				break;

			case "F":
				front(anticlockwise);
				break;
			case "F2":
				front(spin);
				break;
			case "F'":
				front(clockwise);
				break;

			case "B":
				back(anticlockwise);
				break;
			case "B2":
				back(spin);
				break;
			case "B'":
				back(clockwise);
				break;
		}
	}
	
	private static void rotateLoop(int times) {
		motorFlip.pin();
		motorRotate.setRotate(times);
		motorRotate.rotate();
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
		
		motorRotate.setRotate(spin);
		motorRotate.rotate();
		motorFlip.flip();
	}

	private static void right(int times) {
		motorRotate.setRotate(spin);
		motorRotate.rotate();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
	}

	private static void front(int times) {
		motorRotate.rotate();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorRotate.setRotate(spin);
		motorRotate.rotate();
		motorFlip.flip();
		motorRotate.setRotate(-1);
		motorRotate.rotate();
	}

	private static void back(int times) {
		motorRotate.setRotate(-1);
		motorRotate.rotate();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorRotate.setRotate(spin);
		motorRotate.rotate();
		motorFlip.flip();
		motorRotate.rotate();
	}
}
