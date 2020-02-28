package rubiks.robot;

import checkpoints.checkpoint_5.Backup;
import checkpoints.checkpoint_5.BatteryLevel;
import checkpoints.checkpoint_5.EmergencyStop;
import checkpoints.checkpoint_5.Trundle;
import lejos.hardware.Button;
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
	// Motor Ports
	public final static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	public final static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor (MotorPort.B);
	public final static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor (MotorPort.C);

	// Sensor Ports
	public final static EV3UltrasonicSensor sensorUltrasonic = new EV3UltrasonicSensor(SensorPort.S1);
	public final static EV3ColorSensor      sensorColour     = new EV3ColorSensor     (SensorPort.S2);

	// Globals
	String[][] scannedCube             = new String[6][9];
	public static String state         = "";
	public static String move          = "";
	public static String motor         = "";
	public static String scrambledcube = "";
	public static String solvedcube    = "";

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
		
		Behavior motorColour = new MotorColour(motorPortColour);
		Behavior motorFlip   = new MotorFlip  (motorPortFlip);
		Behavior motorRotate = new MotorRotate(motorPortRotate);
		Behavior move        = new Move       ();
		
		Behavior[] behaviours = new Behavior[]{motorColour, motorFlip, motorRotate, move};
		
		Arbitrator arby = new Arbitrator(behaviours);
		arby.go();

		LCD.drawString("Finished", 0, 6);
		Delay.msDelay(1000);
	}
	
	public static void setState(String newState) { state = newState; }
	public static String getState() { return state; }
	
	public static void setMove(String newMove) { move = newMove; }
	public static String getMove() { return move; }
	
	public static void setMotor(String nextMotor) { motor = nextMotor; }
	public static String getMotor() { return motor; }
	
	public static void setScrambledcube(String isscrambledcube) { scrambledcube = isscrambledcube; }
	public static String getScrambledcube() { return scrambledcube; }
	
	public static void setSolvedcube(String issolvedcube) { solvedcube = issolvedcube; }
	public static String getSolvedcube() { return solvedcube; }
}
