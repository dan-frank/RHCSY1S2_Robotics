package rubiks.robot;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

import rubiks.robot.ScanCube;
import rubiks.robot.MoveRube;
import rubiks.robot.Solve;

public class RubeTheRobot {
	// Motor Ports
	public final static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	public final static BaseRegulatedMotor motorPortFlip = new EV3LargeRegulatedMotor(MotorPort.B);
	public final static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);

	// Sensor Ports
	public final static EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
	public final static EV3ColorSensor sensorColour = new EV3ColorSensor(SensorPort.S2);

	// Arrays
	String[][] scannedCube = new String[6][9];

	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello there, my", 0, 1);
		LCD.drawString("name is Rube!", 0, 2);
		LCD.drawString("I am going to", 0, 3);
		LCD.drawString("solve a rubiks", 0, 4);
		LCD.drawString("cube!", 0, 5);

		ScanCube.start();

//		SensorUltrasonic uc = new SensorUltrasonic();
//		while (uc.scan() > 0.5f) {}

//		String scrambledcube = ScanCube.start();
//		String solvedcube = Solve.simpleSolve(scrambledcube);
//		MoveRube.run(solvedcube);

		while (!Button.ENTER.isDown()) {
		}

		LCD.drawString("Finished", 0, 6);
		Delay.msDelay(1000);
	}
}
