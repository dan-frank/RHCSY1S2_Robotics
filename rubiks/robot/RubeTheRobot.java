package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class RubeTheRobot {

	private static BaseRegulatedMotor motorPortColour = new EV3LargeRegulatedMotor(MotorPort.A);
	private static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);

	public static void main(String[] args) {
		MotorRotate motorRotate = new MotorRotate(motorPortRotate);
		MotorFlip motorFlip     = new MotorFlip(motorPortFlip);
		
		LCD.clear();
		LCD.drawString("Hello!", 0, 1);
		LCD.drawString("My name is Rube!", 0, 2);
		
		
		motorRotate.rotate();
		motorFlip.flip();
		
		for (int i = 0; i < 10; i++) {
			motorRotate.rotate();
			Delay.msDelay(500);
		}
	}

}
