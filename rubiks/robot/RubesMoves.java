package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class RubesMoves {
	private static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);
	
	private MotorFlip motorFlip     = new MotorFlip(motorPortFlip);
	private MotorRotate motorRotate = new MotorRotate(motorPortRotate);
	
	public RubesMoves(String move) {
		switch (move) {
			case "U  ":
				upper(1);
				break;
			case "U2 ":
				upper(2);
				break;
			case "U' ":
				upper(3);
				break;
		}
	}
	
	private void upper(int times) {
		motorFlip.flip();
		motorFlip.flip();
		for (int i = 0; i < times; i++) {
			motorRotate.rotate();
		}
		motorFlip.flip();
		motorFlip.flip();
	}
}
