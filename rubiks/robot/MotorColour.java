package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour implements RubeDaddy {

	private BaseRegulatedMotor m;
	private int posExtendFull = -690,
			posEdge = -570,
			posCorner = -520,
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
