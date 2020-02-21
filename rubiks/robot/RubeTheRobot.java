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
	private static BaseRegulatedMotor motorPortFlip = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public static void main(String[] args) {
		MotorColour motorColour = new MotorColour(motorPortColour);
		MotorFlip motorFlip = new MotorFlip(motorPortFlip);
		
		LCD.clear();
		LCD.drawString("Hello there!", 1, 1);
		LCD.drawString("My name is Rube!", 1, 2);
		
		motorFlip.flip();
		
		motorColour.goCentre();
		Delay.msDelay(1000);
		motorColour.goEdge();
		Delay.msDelay(1000);
		motorColour.goCorner();
		Delay.msDelay(1000);
		motorColour.returnToStart();

		
//		String solvedcube = Solve.simpleSolve("BURUUDRDLUFFBRBBFLRUUBDRLFDRLURLBBLBDRUDBDFLDFLFUFRDFL");
//		MoveRube.run(solvedcube);

		LCD.drawString("Finished", 0, 7);
		Delay.msDelay(2000);
	}
}
