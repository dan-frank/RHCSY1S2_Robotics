package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour {

	private BaseRegulatedMotor m;
	private int rMiddle = 50000,
			rEdge = 150,
			rIn = 150,
			rOut = rIn * -1,
			rBack = 50000;

	public MotorColour(BaseRegulatedMotor m) {
		this.m = m;
	}

	public void goMiddle() {
		m.rotate(rMiddle);
	}

	public void goEdge() {
		m.rotate(rEdge);
	}

	public void goOut() {
		m.rotate(rOut);
	}

	public void goIn() {
		m.rotate(rIn);
	}

	public void goBack() {
		m.rotate(rBack);
	}

}
