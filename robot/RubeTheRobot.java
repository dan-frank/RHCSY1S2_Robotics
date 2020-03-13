package robot;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
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
//		LCD.drawString("Rube the Robot!", 0, 1);
//		LCD.drawString("- Lewes Block", 0, 2);
//		LCD.drawString("- Megan Hardman", 0, 3);
//		LCD.drawString("- Daniel Lucas", 0, 4);
//		LCD.drawString("- Rumen Yonkov", 0, 5);
//		LCD.drawString("Version: 86", 0, 6);
		
//		Button.ENTER.waitForPressAndRelease();

		FriendColour friendColour = new FriendColour();
		FriendCube friendCube = new FriendCube();
		FriendMove friendMove = new FriendMove();
		Delay.msDelay(1000);
		System.out.println("Rube's friends have arrived");

		friendCube.setSolvedCube(new String[]{ "L" });
		friendCube.setStateCube(StateCube.SOLVED);
		Delay.msDelay(1000);
		System.out.println("Rube made a fake friend");

		Behavior motorFlip = new BehaviourMotorFlip(friendMove);
		Behavior motorRotate = new BehaviourMotorRotate(friendMove);
		Behavior move = new BehaviourMove(friendCube, friendMove);
		Delay.msDelay(1000);
		System.out.println("Rube has developed behaviours... :o");

		Behavior[] behaviours = new Behavior[] { move, motorRotate, motorFlip };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
		System.out.println("Rube met arby");
		arby.go();
		Delay.msDelay(1000);

		System.out.println("Rube has finished his adventure and kills himsel");
	}
}
