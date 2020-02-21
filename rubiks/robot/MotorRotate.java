package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorRotate extends RubeDaddy{

	private BaseRegulatedMotor m;
	private int ninetyDegrees = 270;
	private int rotate;
	private float speed = 360f;

	public MotorRotate(BaseRegulatedMotor m) {
		this.m = m;
		this.m.setSpeed(this.speed);
		this.rotate = ninetyDegrees;
	}

	public void setRotate(int multiplier) {
		this.rotate = ninetyDegrees * multiplier;
	}
	
	public void rotate() {
		m.rotate(rotate);
		rotate = ninetyDegrees;
	}
}
