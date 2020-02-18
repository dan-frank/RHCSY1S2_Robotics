package rubiks.robot;

import lejos.hardware.lcd.LCD;

import rubiks.robot.RubesMoves;

public class RubeTheRobot {
	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello there!", 1, 1);
		LCD.drawString("My name is Rube!", 1, 2);
		
		RubesMoves move = new RubesMoves();
		move.solve("B  ");
	}
}
