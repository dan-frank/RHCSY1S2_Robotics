package checkpoints.checkpoint_5_4_2;

import java.io.File;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

public class TunePlayerThread extends Thread {
	public void run() {
		int count = 1;
		while (true) {
			LCD.drawInt(count++, 0, 6);
			playTune();
		}
	}
	
	private void playTune() {
		int time = Sound.playSample(new File("Trumpet.wav"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
