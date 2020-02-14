package checkpoints.lewes_thread;

import lejos.hardware.Button;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.utility.Delay;

public class MoveThread extends Thread {
	private BaseRegulatedMotor mL, mR;

	public MoveThread(BaseRegulatedMotor _mL, BaseRegulatedMotor _mR, boolean[] _pass) {
		mL = _mL;
		mR = _mR;
		boolean[] pass = _pass;
	}

	public void run() {
		while (!Button.ENTER.isDown()) {
			mL.setSpeed(720);
			mR.setSpeed(200);
			mL.synchronizeWith(new BaseRegulatedMotor[] { mR });
			mL.startSynchronization();
			mL.forward();
			mR.forward();
			mL.endSynchronization();
			Delay.msDelay(2750);

			mL.setSpeed(200);
			mR.setSpeed(720);
			mL.synchronizeWith(new BaseRegulatedMotor[] { mR });
			mL.startSynchronization();
			mL.forward();
			mR.forward();
			mL.endSynchronization();
			Delay.msDelay(2750);
		}

	}

}
