import lejos.hardware.Sound;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.utility.Delay;

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
			System.out.println("Motor rotate clockwise");
			rotate();
			break;

		case ANTICLOCKWISE:
			System.out.println("Motor rotate anticlockwise");
			setRotate(-1);
			rotate();
			break;

		case UTURN:
			System.out.println("Motor rotate uturn");
			setRotate(2);
			rotate();
			break;

		case PAUSE:
		default:
			System.out.println("Motor rotate pause");
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

		friendMove.setInAction(false);
	}
}
