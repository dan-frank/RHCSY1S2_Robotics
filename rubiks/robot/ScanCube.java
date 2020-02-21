package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.utility.Delay;

public class ScanCube {
	private static ThreadRotateCube trc;
	private static int sidesOfCube = 6;
	
	public static void startDriving(BaseRegulatedMotor mpc, BaseRegulatedMotor mpf, BaseRegulatedMotor mpr) {
		trc = new ThreadRotateCube(mpr);
		
		for (int i = 0; i < sidesOfCube; i++) {
			trc.start();
			Delay.msDelay(4000);
		}	
	}
}
