package rubiks.robot;

import lejos.utility.Delay;

public class ScanCube extends RubeDaddy {
	private static ThreadRotateCube trc;
	private static int sidesOfCube = 6;
	
	public static void startDriving() {
		trc = getThreadRoateCube();
  
		for (int i = 0; i < sidesOfCube; i++) {
			while (!trc.isAlive()) {
				trc = getThreadRoateCube(mpr);
			}
			Delay.msDelay(4000);
		}
	}

	public static ThreadRotateCube getThreadRoateCube(BaseRegulatedMotor mpr) {
		trc = new ThreadRotateCube(mpr);
		trc.start();
		return trc;
	}
}
