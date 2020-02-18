package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import rubiks.robot.RubesMoves;

public class RubeTheRobot {
	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello there!", 1, 1);
		LCD.drawString("My name is Rube!", 1, 2);
		
		String solvedcube = Solve.simpleSolve("DFDUUDRULURLDRBDLRFRFDFLLBBBDRLDBRFFLLUBLFBFUBUFRBUDRU");
		
		RubesMoves moveRube = new RubesMoves();
		moveRube.run(solvedcube);
		
		LCD.drawString("Finished", 0, 7);
		Delay.msDelay(2000);
	}
}
