package checkpoints.checkpoint_5_4_2;

import lejos.hardware.Sound;

public class BeepThread extends Thread {
	public BeepThread() {}
	
	public void run() {
		while (true) {
			Sound.twoBeeps();
		}
	}
}
