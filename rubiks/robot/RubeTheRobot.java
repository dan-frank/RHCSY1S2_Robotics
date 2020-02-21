package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

import rubiks.robot.MoveRube;
import rubiks.robot.Solve;
import rubiks.robot.ScanCube;

public class RubeTheRobot {
	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello there!", 1, 1);
		LCD.drawString("My name is Rube!", 1, 2);
		LCD.drawString("I am going to solve a rubiks cube!", 1, 3);
		
		ScanCube.startDriving();
		
//		String solvedcube = Solve.simpleSolve("BURUUDRDLUFFBRBBFLRUUBDRLFDRLURLBBLBDRUDBDFLDFLFUFRDFL");
//		MoveRube.run(solvedcube);
    
		LCD.drawString("Finished", 0, 7);
		Delay.msDelay(2000);
	}
}
