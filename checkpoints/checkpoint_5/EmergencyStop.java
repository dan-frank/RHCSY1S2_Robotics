package checkpoints.checkpoint_5;

import lejos.hardware.Button;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;

public class EmergencyStop implements Behavior {

	@Override
	public boolean takeControl() {
		return Button.ENTER.isDown(); // Returns a boolean
	}

	@Override
	public void action() {
		BaseRegulatedMotor mLeft = new EV3LargeRegulatedMotor(MotorPort.A);
		BaseRegulatedMotor mRight = new EV3LargeRegulatedMotor(MotorPort.B);
		
		mLeft.startSynchronization();
		mLeft.stop();
		mRight.stop();
		mLeft.endSynchronization();
		
		mLeft.close();
		mRight.close();
	}

	@Override
	public void suppress() {
	}

}
