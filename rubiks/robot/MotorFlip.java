package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class MotorFlip implements Behavior {
	private final BaseRegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.B);
	private FriendMove friendMove;

	MotorFlip(FriendMove friendMove) {
		this.friendMove = friendMove;
	}

	@Override
	public boolean takeControl() {
		StateFlip state = friendMove.getStateFlip();
		System.out.println("Flip: State = " + state);
		return state != StateFlip.PAUSE && !friendMove.getInAction();
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		System.out.println("Motor flip action");
		friendMove.setInAction(true);
		switch (this.friendMove.getStateFlip()) {
		case RETRACT:
			m.rotate(-90);
			friendMove.setInAction(false);
			break;
			
		case PIN:
			m.rotate(90);
			friendMove.setInAction(false);
			break;
			
		case FLIP:
			m.rotate(360);
			friendMove.setInAction(false);
			break;
			
		default:
			break;
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
	}

}