package checkpoints.checkpoint_5;

import lejos.hardware.Battery;
import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BatteryLevel implements Behavior {
	
	@Override
	public boolean takeControl() {
		return (Battery.getVoltage() < 7.5);
	}

	@Override
	public void action() {
		LCD.clear(1);
		Delay.msDelay(500);
		LCD.drawString("BATTERY LEVEL LOW!!!!", 1, 1);
		Delay.msDelay(500);
	}

	@Override
	public void suppress() {
	}

}
