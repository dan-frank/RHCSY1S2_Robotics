package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorRotate {
	
	private BaseRegulatedMotor m;
	private int ninetyDegrees = 280;
	private int rotate;
	private float speed;

	public MotorRotate(BaseRegulatedMotor m) {
		this.m = m;
		this.rotate = ninetyDegrees;
		this.speed = 360f;
	}

	public void setRotate(int multiplier) {
		this.rotate = ninetyDegrees * multiplier;
	}
	
	public void rotate() {
		m.setSpeed(speed);
		m.rotateTo(rotate);
		rotate = ninetyDegrees;
	}
}
