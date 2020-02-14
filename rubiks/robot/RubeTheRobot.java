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
		LCD.clear();
		LCD.drawString("Hello!", 0, 1);
		LCD.drawString("My name is Rube!", 0, 2);
		
		MotorRotate motorRotate = new MotorRotate(motorPortRotate);
		motorRotate.rotate();
		
		MotorFlip motorFlip = new MotorFlip(motorPortFlip);
		motorFlip.flip();
		motorFlip.pin();
		Delay.msDelay(500);
		motorFlip.retract();

		Delay.msDelay(5000);
	}

}
