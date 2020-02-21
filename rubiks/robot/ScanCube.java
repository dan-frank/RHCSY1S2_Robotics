package rubiks.robot;

public class ScanCube extends RubeDaddy {
	private static ThreadRotateCube trc;
	private static ThreadMoveColourSensor tmcs;
	private static ThreadScanCube tsc;
	private static int sidesOfCube = 6;
	
	public static void start() {
		getThreadRoateCube();
		getThreadMoveColourSensor();
		getThreadScanCube();
  
		sidesOfCube = 1;
		int i = 0;
		while ((i < sidesOfCube) && trc.isAlive() && tmcs.isAlive() && tsc.isAlive()) {
			if (!trc.isAlive() && !tmcs.isAlive() && !tsc.isAlive()) {
				getThreadRoateCube();
				getThreadMoveColourSensor();
				getThreadScanCube();
				
				i++;
			}
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

	public static void getThreadScanCube() {
		tsc = new ThreadScanCube();
		tsc.start();
	}
}
