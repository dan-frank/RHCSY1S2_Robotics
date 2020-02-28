package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;

public class MotorRotate implements Behavior {

	private final BaseRegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.C);

	private FriendMove friendMove;

	private final float speedDefault = 360f;
	private final int ninetyDegrees = 270;

	private float speed;
	private int rotate;

	public MotorRotate(FriendMove friendMove) {
		this.friendMove = friendMove;
		this.speed = speedDefault;
		this.rotate = ninetyDegrees;
	}

	@Override
	public boolean takeControl() {
		return friendMove.getStateRotate() != null;
	}

	@Override
	public void action() {
		switch (friendMove.getStateRotate()) {
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

		default:
			break;
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
	}

	public void setRotate(int multiplier) {
		this.rotate = ninetyDegrees * multiplier;
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
