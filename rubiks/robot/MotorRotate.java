package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorRotate implements RubeDaddy {

	private BaseRegulatedMotor m;
	
	private final float speedDefault = 360f;
	private final int ninetyDegrees = 270;
	
	private float speed;
	private int rotate;

	public MotorRotate() {
		this.m = motorPortRotate;
		this.speed = speedDefault;
		this.rotate = ninetyDegrees;
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
	
	public void resetVars() {
		rotate = ninetyDegrees;
		speed = speedDefault;
	}
}
