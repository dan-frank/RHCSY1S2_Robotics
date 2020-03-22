import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour {
	
	private final BaseRegulatedMotor m;
	
	private int start = 0,
			corner = -550,
			edge = -585,
			center = -710;
			
	
	public MotorColour(FriendScan friendScan) {
		this.m = friendScan.getMotorColour();
	}

	public void run(StateMoveColourMotor state) {
		switch (state) {
		case CENTRE:
			System.out.println("Motor rotate clockwise");
			goCentre();
			break;

		case EDGE:
			System.out.println("Motor rotate anticlockwise");
			goEdge();
			break;

		case CORNER:
			System.out.println("Motor rotate uturn");
			goCorner();
			break;

		case BACK:
			returnToStart();
		default:
			System.out.println("Motor rotate pause");
			break;
		}
	}

	
	public void goCentre() {
		m.rotateTo(center);
	}

	public void goEdge() {
		m.rotateTo(edge);
	}

	public void goCorner() {
		m.rotateTo(corner);
	}

	public void returnToStart() {
		m.rotateTo(start);
	}
}
