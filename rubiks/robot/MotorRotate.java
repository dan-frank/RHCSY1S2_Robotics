package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorRotate {
	
	private BaseRegulatedMotor m;
	private int rotate;

	public MotorRotate(BaseRegulatedMotor m) {
		this.m = m;
		this.rotate = 90;
	}

	public void setRotate(int rotate) {
		this.rotate = rotate;
	}
	
	public void rotate() {
		m.rotate(rotate);
		rotate = 90;
	}
}
