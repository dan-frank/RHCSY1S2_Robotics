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
//	private final static EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
//	private final static EV3ColorSensor sensorColour = new EV3ColorSensor(SensorPort.S2);

	public static void main(String[] args) {
		Delay.msDelay(1000);
		System.out.println("Rube starts his journey");
		
//		LCD.clear();
//		LCD.drawString("Hello there, my", 0, 1);
//		LCD.drawString("name is Rube!", 0, 2);
//		LCD.drawString("I am going to", 0, 3);
//		LCD.drawString("solve a rubiks", 0, 4);
//		LCD.drawString("cube!", 0, 5);

		FriendColour friendColour = new FriendColour();
		FriendCube friendCube = new FriendCube();
		FriendMove friendMove = new FriendMove();
		Delay.msDelay(1000);
		System.out.println("Rube's friends have arrived");
		
		String[] solvedcube = new String[] {"L", "U"};
		friendCube.setSolvedCube(solvedcube);
		friendCube.setStateCube(StateCube.SOLVED);
		Delay.msDelay(1000);
		System.out.println("Rube make a fake friend");
		
		Behavior motorColour = new MotorColour(friendColour);
		Behavior motorFlip = new MotorFlip(friendMove);
		Behavior motorRotate = new MotorRotate(friendMove);
		Behavior move = new Move(friendCube, friendMove);
		Delay.msDelay(1000);
		System.out.println("Rube has developed behaviours...");

		Behavior[] behaviours = new Behavior[] { motorRotate, motorFlip, move };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
		System.out.println("Rube met arby");
		arby.go();
		Delay.msDelay(1000);

		System.out.println("Rube has finished his adventure");
	}
}
