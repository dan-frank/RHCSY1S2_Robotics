package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

interface RubeDaddy {
	// Motor Ports
	public final static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	public final static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor (MotorPort.B);
	public final static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor (MotorPort.C);
	
	// Sensor Ports
	public final static EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
	public final static EV3ColorSensor      sensorColour     = new EV3ColorSensor     (SensorPort.S2);
	
	// Arrays
	String[][] scannedCube = new String[6][9];
}
