package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourMotorFlip implements Behavior {
	private BaseRegulatedMotor m;
	private FriendMove friendMove;

	BehaviourMotorFlip(FriendMove friendMove) {
		this.friendMove = friendMove;
	}

	@Override
	public boolean takeControl() {
		this.m = friendMove.getMotorFlip();
		return friendMove.getStateFlip() != StateFlip.PAUSE && !friendMove.getInAction();
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