package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class RubeTheRobot {
	// Sensor Ports
	private final static EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
	private final static EV3ColorSensor sensorColour = new EV3ColorSensor(SensorPort.S2);

	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello there, my", 0, 1);
		LCD.drawString("name is Rube!", 0, 2);
		LCD.drawString("I am going to", 0, 3);
		LCD.drawString("solve a rubiks", 0, 4);
		LCD.drawString("cube!", 0, 5);

//		ScanCube.start();

//		SensorUltrasonic uc = new SensorUltrasonic();
//		while (uc.scan() > 0.5f) {}

//		String scrambledcube = ScanCube.start();
//		String solvedcube = Solve.simpleSolve(scrambledcube);
//		MoveRube.run(solvedcube);

//		while (!Button.ENTER.isDown()) { }

		FriendCube friendCube = new FriendCube();
		
		Behavior motorColour = new MotorColour();
		Behavior motorFlip = new MotorFlip();
		Behavior motorRotate = new MotorRotate();
		Behavior move = new Move(friendCube);

		Behavior[] behaviours = new Behavior[] { motorColour, motorFlip, motorRotate, move };

		Arbitrator arby = new Arbitrator(behaviours);
		arby.go();

		LCD.drawString("Finished", 0, 6);
		Delay.msDelay(1000);
	}
}
