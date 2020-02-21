package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class RubeDaddy {
	protected final static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	protected final static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor (MotorPort.B);
	protected final static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor (MotorPort.C);
}
