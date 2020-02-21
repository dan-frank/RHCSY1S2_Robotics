package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

import rubiks.robot.MoveRube;
import rubiks.robot.Solve;

public class RubeTheRobot {
	private static BaseRegulatedMotor motorPortColour = new EV3MediumRegulatedMotor(MotorPort.A);
	private static BaseRegulatedMotor motorPortFlip   = new EV3LargeRegulatedMotor(MotorPort.B);
	private static BaseRegulatedMotor motorPortRotate = new EV3LargeRegulatedMotor(MotorPort.C);

	public static void main(String[] args) {
		MotorColour motorColour = new MotorColour(motorPortColour);
		LCD.clear();
		LCD.drawString("Hello there!", 1, 1);
		LCD.drawString("My name is Rube!", 1, 2);
		
//		motorColour.goMiddle();
//		Delay.msDelay(200);
//		motorColour.goEdge();
//		Delay.msDelay(200);
//		motorColour.goIn();
//		Delay.msDelay(200);
//		motorColour.goOut();
//		Delay.msDelay(200);
//		motorColour.goBack();

		
//		String solvedcube = Solve.simpleSolve("BURUUDRDLUFFBRBBFLRUUBDRLFDRLURLBBLBDRUDBDFLDFLFUFRDFL");
//		MoveRube.run(solvedcube, motorPortColour, motorPortFlip, motorPortRotate);
//		
//		LCD.drawString("Finished", 0, 7);
//		Delay.msDelay(2000);
		
		ScanCube.startDriving(motorPortColour, motorPortFlip, motorPortRotate);
	}
}
