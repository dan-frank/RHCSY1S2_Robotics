package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class RubeDaddy {
	protected static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	protected static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor (MotorPort.B);
	protected static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor (MotorPort.C);
}
