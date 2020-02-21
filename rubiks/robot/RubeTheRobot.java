package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

import rubiks.robot.ScanCube;
import rubiks.robot.MoveRube;
import rubiks.robot.Solve;

public class RubeTheRobot implements RubeDaddy {
	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello there, my", 0, 1);
		LCD.drawString("name is Rube!", 0, 2);
		LCD.drawString("I am going to", 0, 3);
		LCD.drawString("solve a rubiks", 0, 4);
		LCD.drawString("cube!", 0, 5);
		
//		ScanCube.start();
		
//		String solvedcube = Solve.simpleSolve("BURUUDRDLUFFBRBBFLRUUBDRLFDRLURLBBLBDRUDBDFLDFLFUFRDFL");
//		MoveRube.run(solvedcube);
		
//		SensorUltrasonic uc = new SensorUltrasonic();
//		while (uc.scan() > 0.5f) {}
    
		LCD.drawString("Finished", 0, 7);
		Delay.msDelay(2000);
	}
}
