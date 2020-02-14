package rubiks.robot;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class RubeTheRobot {
	
	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("Hello!", 0, 1);
		LCD.drawString("My name is Rube!", 0, 2);
		
		Delay.msDelay(5000);
	}

}
