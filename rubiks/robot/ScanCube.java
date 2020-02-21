package rubiks.robot;

import lejos.utility.Delay;

public class ScanCube extends RubeDaddy {
	private static ThreadRotateCube trc;
	private static ThreadMoveColourSensor tmcs;
	private static int sidesOfCube = 6;
	
	public static void startDriving() {
		getThreadRoateCube();
		getThreadMoveColourSensor();
  
		sidesOfCube = 1;
		for (int i = 0; i < sidesOfCube; i++) {
			while (!trc.isAlive() && !tmcs.isAlive()) {
				getThreadRoateCube();
				getThreadMoveColourSensor();
			}
			Delay.msDelay(4000);
		}
	}

	public static void getThreadRoateCube() {
		trc = new ThreadRotateCube();
		trc.start();
	}
	
	public static void getThreadMoveColourSensor() {
		tmcs = new ThreadMoveColourSensor();
		tmcs.start();
	}
}
