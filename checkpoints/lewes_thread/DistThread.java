package checkpoints.lewes_thread;

import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class DistThread extends Thread {
	private EV3UltrasonicSensor us;
	private int count = 0;

	public DistThread(EV3UltrasonicSensor _us, boolean[] _pass) {
		us = _us;
	}

	public void run() {
		SampleProvider sp = us.getDistanceMode();
		float[] samples = new float[1];
		sp.fetchSample(samples, 0);
		while (!stop(samples[0])) {
			sp.fetchSample(samples, 0);
			count++;
			
			LCD.drawString("" + samples[0], 1, 1);
			LCD.drawString("Count: " + count, 1, 2);
		}
		LCD.clear();
		LCD.drawString("Total Count: " + count, 1, 1);
		LCD.drawString("First small distance:" + samples[0], 1, 2);
	}

	public boolean stop(float sample) {
		return (sample < 0.2f);
	}
}