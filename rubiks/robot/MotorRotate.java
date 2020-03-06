package rubiks.robot;

import lejos.hardware.Sound;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

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
		StateRotate state = friendMove.getStateRotate();
		System.out.println("Rotate: State = " + state);
		while (friendMove.getInAction()) {}
		return state != StateRotate.PAUSE && !friendMove.getInAction();
	}

	@Override
	public void action() {
		Sound.beep();
		Delay.msDelay(1000);
		System.out.println("Motor rotate action");
		friendMove.setInAction(true);
		
		StateRotate state = friendMove.getStateRotate();
		System.out.println("move action state: " + state);
		switch (state) {
		case CLOCKWISE:
			System.out.println("Motor rotate clockwise");
			rotate();
			Delay.msDelay(3000);
			break;

		case ANTICLOCKWISE:
			System.out.println("Motor rotate anticlockwise");
			setRotate(-1);
			rotate();
			Delay.msDelay(3000);
			break;

		case UTURN:
			System.out.println("Motor rotate uturn");
			setRotate(2);
			rotate();
			Delay.msDelay(3000);
			break;

		case PAUSE:
		default:
			System.out.println("Motor rotate pause");
			break;
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
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
