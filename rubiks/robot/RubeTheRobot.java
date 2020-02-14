package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class RubeTheRobot {

	private BaseRegulatedMotor motorPortRead   = new EV3LargeRegulatedMotor(MotorPort.A);
	private BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);

	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello!", 0, 1);
		LCD.drawString("My name is Rube!", 0, 2);

		Delay.msDelay(5000);
	}

}
