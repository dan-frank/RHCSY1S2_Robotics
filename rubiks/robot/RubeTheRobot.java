package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

import rubiks.robot.MoveRube;
import rubiks.robot.Solve;

public class RubeTheRobot {

	public static void main(String[] args) {
		MotorColour motorColour = new MotorColour();
		LCD.clear();
		LCD.drawString("Hello there!", 1, 1);
		LCD.drawString("My name is Rube!", 1, 2);
		
		motorColour.goMiddle();
		Delay.msDelay(200);
		motorColour.goEdge();
		Delay.msDelay(200);
		motorColour.goIn();
		Delay.msDelay(200);
		motorColour.goOut();
		Delay.msDelay(200);
		motorColour.goBack();

		
//		String solvedcube = Solve.simpleSolve("BURUUDRDLUFFBRBBFLRUUBDRLFDRLURLBBLBDRUDBDFLDFLFUFRDFL");
//		MoveRube.run(solvedcube);
//		
//		LCD.drawString("Finished", 0, 7);
//		Delay.msDelay(2000);
		
		ScanCube.startDriving();
	}
}
