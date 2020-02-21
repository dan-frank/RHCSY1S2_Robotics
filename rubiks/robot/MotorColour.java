package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour extends RubeDaddy {

	private BaseRegulatedMotor m;
	private int posExtendFull = -690,
			posEdge = -550,
			posCorner = -500,
			posStart = 0;

	public MotorColour() {
		this.m = motorPortColour;
	}

	public void goCentre() {
		m.rotateTo(posExtendFull);
	}

	public void goEdge() {
		m.rotateTo(posEdge);
	}

	public void goCorner() {
		m.rotateTo(posCorner);
	}

	public void returnToStart() {
		m.rotateTo(posStart);
	}

}
