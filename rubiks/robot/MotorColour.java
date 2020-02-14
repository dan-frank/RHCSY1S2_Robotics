package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour {

	private BaseRegulatedMotor m;
	private int rMiddle, rEdge, rIn, rOut, rBack;

	public MotorColour(BaseRegulatedMotor _m) {
		this.m = _m;
		this.rMiddle = 150;
		this.rEdge = 10;
		this.rIn = 15;
		this.rOut = rIn * -1;
		this.rBack = 140;
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
