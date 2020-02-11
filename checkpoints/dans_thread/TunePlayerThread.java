package checkpoints.dans_thread;

import java.io.File;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

public class TunePlayerThread extends Thread {
	private int count;
	
	public void run() {
		count = 1;
		
		while (!isInterrupted()) {
			LCD.drawInt(count++, 0, 6);
			playTune();
		}
	}
	
	private void playTune() {
		int time = Sound.playSample(new File("./checkpoints/dans_thread/Trumpet.wav"));
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			LCD.drawString("TunePlayer Sleep Error", 0, 5);
		}
	}
}
