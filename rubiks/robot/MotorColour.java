package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour extends RubeDaddy {

	private BaseRegulatedMotor m;
	private int rMiddle = -500,
			rEdge = 150,
			rIn = -150,
			rOut = (rIn * -1),
			rBack = 500;

	public MotorColour() {
		this.m = motorPortColour;
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
