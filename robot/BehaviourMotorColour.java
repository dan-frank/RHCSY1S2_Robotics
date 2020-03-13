package robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;

public class BehaviourMotorColour implements Behavior {

	private final BaseRegulatedMotor m = new EV3MediumRegulatedMotor(MotorPort.A);

	private int posExtendFull = -690,
			posEdge = -560,
			posCorner = -510,
			posStart = 0;
	private FriendColour friendColour;

	public BehaviourMotorColour(FriendColour friendColour) {
		this.friendColour = friendColour;
	}

	@Override
	public boolean takeControl() {
		return friendColour.getStateMoveColourMotor() != null;
	}

	@Override
	public void action() {
		switch(this.friendColour.getStateMoveColourMotor()) {
		case BACK:
			returnToStart();
			break;
		case CENTRE:
			goCentre();
			break;
		case CORNER:
			goCorner();
			break;
		case EDGE:
			goEdge();
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void suppress() {
		
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
