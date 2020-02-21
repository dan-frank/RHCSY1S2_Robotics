package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class RubeDaddy {
	// Motor Ports
	protected final static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	protected final static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor (MotorPort.B);
	protected final static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor (MotorPort.C);
	
	// Sensor Ports
	protected final static EV3UltrasonicSensor sensorPortUltraSonic = new EV3UltrasonicSensor(SensorPort.S1);
	protected final static EV3ColorSensor      sensorPortColour     = new EV3ColorSensor     (SensorPort.S2);
	
	// Arrays
	String[][] scannedCube = new String[6][9];
}
