package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorRotate {
	
	private BaseRegulatedMotor m;
	private int rotate;
	private float speed;

	public MotorRotate(BaseRegulatedMotor m) {
		this.m = m;
		this.rotate = 360;
		this.speed = 360f;
	}

	public void setRotate(int rotate) {
		this.rotate = rotate;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void rotate() {
		m.setSpeed(speed);
		m.rotateTo(rotate);
		rotate = 360;
	}
}
