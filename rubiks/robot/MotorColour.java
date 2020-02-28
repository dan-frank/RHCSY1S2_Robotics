package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;

public class MotorColour implements Behavior {

	private final BaseRegulatedMotor m = new EV3MediumRegulatedMotor(MotorPort.A);

	private int posExtendFull = -690,
			posEdge = -560,
			posCorner = -510,
			posStart = 0;

	public MotorColour() {}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
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
