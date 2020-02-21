package rubiks.robot;

public class ScanCube implements RubeDaddy {
	private static ThreadRotateCube trc;
	private static ThreadMoveColourSensor tmcs;
	private static ThreadScanCube tsc;
	private static int sidesOfCube = 6;
	
	public static void start() {
		runThreadRoateCube();
		runThreadMoveColourSensor();
		runThreadScanCube();
  
		sidesOfCube = 1;
		int i = 0;
		while ((i < sidesOfCube) && trc.isAlive() && tmcs.isAlive() && tsc.isAlive()) {
			if (!trc.isAlive() && !tmcs.isAlive() && !tsc.isAlive()) {
				runThreadRoateCube();
				runThreadMoveColourSensor();
				runThreadScanCube();
				
				i++;
			}
		}
	}

	public static void runThreadRoateCube() {
		trc = new ThreadRotateCube();
		trc.start();
	}
	
	public static void runThreadMoveColourSensor() {
		tmcs = new ThreadMoveColourSensor();
		tmcs.start();
	}

	public static void runThreadScanCube() {
		tsc = new ThreadScanCube();
		tsc.start();
	}
}
