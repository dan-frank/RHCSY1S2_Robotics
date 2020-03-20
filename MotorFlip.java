import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorFlip {
	private BaseRegulatedMotor m;

	MotorFlip(FriendMove friendMove) {
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
			m.rotate(180);
			m.rotate(-90);
			m.rotate(30);
			m.rotate(-120);
			break;
			
		default:
			break;
		}
	}
}