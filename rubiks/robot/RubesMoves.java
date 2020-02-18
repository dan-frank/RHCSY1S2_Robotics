package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class RubesMoves {
	private static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);
	
	private MotorFlip motorFlip     = new MotorFlip(motorPortFlip);
	private MotorRotate motorRotate = new MotorRotate(motorPortRotate);
	
	public RubesMoves() { }
	
	public void solve(String move) {
		switch (move) {
			case "U  ":
				up(1);
				break;
			case "U2 ":
				up(2);
				break;
			case "U' ":
				up(3);
				break;
				
			case "D  ":
				down(1);
				break;
			case "D2 ":
				down(2);
				break;
			case "D' ":
				down(3);
				break;

			case "L  ":
				left(3);
				break;
			case "L2 ":
				left(2);
				break;
			case "L' ":
				left(1);
				break;

			case "R  ":
				right(3);
				break;
			case "R2 ":
				right(2);
				break;
			case "R' ":
				right(1);
				break;

			case "F  ":
				front(3);
				break;
			case "F2 ":
				front(2);
				break;
			case "F' ":
				front(1);
				break;

			case "B  ":
				back(3);
				break;
			case "B2 ":
				back(2);
				break;
			case "B' ":
				back(1);
				break;

		}
	}
	
	private void up(int times) {
		motorFlip.flip();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
	}
	
	private void down(int times) {
		rotateLoop(times);
	}

	private void left(int times) {
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();		
	}

	private void right(int times) {
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
	}

	private void front(int times) {
		motorRotate.rotate();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();
		motorRotate.rotateAnti();
	}

	private void back(int times) {
		motorRotate.rotateAnti();
		motorFlip.flip();
		
		rotateLoop(times);
		
		motorFlip.flip();
		motorFlip.flip();
		motorFlip.flip();
		motorRotate.rotate();
	}
	
	private void rotateLoop(int times) {
		motorFlip.pin();
		for (int i = 0; i < times; i++) {
			motorRotate.rotate();
		}
		motorFlip.retract();
	}
}
