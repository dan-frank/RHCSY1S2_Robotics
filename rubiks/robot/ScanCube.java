package rubiks.robot;

public class ScanCube implements RubeDaddy {
	private static ThreadRotateCube trc;
	private static ThreadColourMotor tcm;
	private static ThreadScanCube tsc;
	private static int sidesOfCube = 6;

	public static void start() {
		runThreadScanCube();
		runThreadRoateCube();
		runThreadMoveColourSensor();

		sidesOfCube = 2;
		for (int i = 0; i < sidesOfCube; i++) {
			while (trc.isAlive() && tcm.isAlive() && tsc.isAlive()) {
				if (!trc.isAlive() && !tcm.isAlive() && !tsc.isAlive()) {
					runThreadScanCube();
					runThreadRoateCube();
					runThreadMoveColourSensor();
				}
			}
		}
	}

	public static void runThreadRoateCube() {
		trc = new ThreadRotateCube();
		trc.start();
	}

	public static void runThreadMoveColourSensor() {
		tcm = new ThreadColourMotor();
		tcm.start();
	}

	public static void runThreadScanCube() {
		tsc = new ThreadScanCube();
		tsc.start();
	}
}