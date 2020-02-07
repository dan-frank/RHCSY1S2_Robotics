package checkpoints.checkpoint_5;

import lejos.hardware.Battery;
import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BatteryLevel implements Behavior {

	private void action() {
		LCD.clear(1);
		Delay.msDelay(500);
		LCD.drawString("BATTERY LEVEL LOW!!!!", 1, 1);
		Delay.msDelay(500);
	}
		
	private void suppress() {}
	
	private boolean takeControl() {
		return (Battery.getVoltage() < 7.5);
	}

}
