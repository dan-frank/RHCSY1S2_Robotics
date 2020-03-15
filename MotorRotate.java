import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorRotate {

	private BaseRegulatedMotor m;

	private FriendMove friendMove;

	private final float speedDefault = 360f;
	private final int ninetyDegrees = 270;

	private float speed;
	private int rotate;

	public MotorRotate(FriendMove friendMove) {
		this.friendMove = friendMove;
		this.m = friendMove.getMotorRotate();
		this.speed = speedDefault;
		this.rotate = ninetyDegrees;
	}

	public void run(StateRotate state) {
		switch (state) {
		case CLOCKWISE:
			rotate();
			break;

		case ANTICLOCKWISE:
			setRotate(-1);
			rotate();
			break;

		case UTURN:
			setRotate(2);
			rotate();
			break;

		case PAUSE:
		default:
			break;
		}
	}

	public void setRotate(int times) {
		this.rotate = ninetyDegrees * times;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void rotate() {
		m.setSpeed(speed);
		m.rotate(rotate);
		resetVars();
	}

	public void rotateHalf() {
		m.setSpeed(speed);
		m.rotate(rotate / 2);
		resetVars();
	}

	public void resetVars() {
		rotate = ninetyDegrees;
		speed = speedDefault;
	}
}
