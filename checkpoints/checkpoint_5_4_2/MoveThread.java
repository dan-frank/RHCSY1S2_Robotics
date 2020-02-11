package checkpoints.checkpoint_5_4_2;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class MoveThread extends Thread {
	private BaseRegulatedMotor mLeft;
	private BaseRegulatedMotor mRight;

	public MoveThread() {}

	public void run() {
		while (true) {
			mLeft = new EV3LargeRegulatedMotor(MotorPort.A);
			mRight = new EV3LargeRegulatedMotor(MotorPort.B);
			
			mLeft.setSpeed(360);
			mRight.setSpeed(100);
			
			mLeft.synchronizeWith(new BaseRegulatedMotor[] {mRight});
			mLeft.startSynchronization();
			mLeft.forward();
			mRight.forward();
			mLeft.endSynchronization();
		}
		
		
	}

}
