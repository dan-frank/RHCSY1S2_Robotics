import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorFlip {
	private BaseRegulatedMotor m;
	private FriendMove friendMove;

	MotorFlip(FriendMove friendMove) {
		this.friendMove = friendMove;
		m = friendMove.getMotorFlip();
	}

	public void run(StateFlip state) {
		switch (state) {
		case RETRACT:
			m.rotate(-90);
			break;
			
		case PIN:
			m.rotate(90);
			break;
			
		case FLIP:
			m.rotate(360);
			break;
			
		default:
			break;
		}
	}
}