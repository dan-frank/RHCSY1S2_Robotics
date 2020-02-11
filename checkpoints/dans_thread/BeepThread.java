package checkpoints.dans_thread;

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class BeepThread extends Thread {
	public BeepThread() {}
	
	public void run() {
		while (true) {
			Sound.twoBeeps();
			Delay.msDelay(1000);
		}
	}
}
