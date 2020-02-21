package rubiks.robot;

import lejos.utility.Delay;

public class ScanCube extends RubeDaddy {
	private static ThreadRotateCube trc;
	private static int sidesOfCube = 6;
	
	public static void startDriving() {
		trc = new ThreadRotateCube();
		
		for (int i = 0; i < sidesOfCube; i++) {
			trc.start();
			Delay.msDelay(4000);
		}	
	}
}
