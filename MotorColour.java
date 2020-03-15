import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class MotorColour {
	
	private final BaseRegulatedMotor m = new EV3MediumRegulatedMotor(MotorPort.A);
	
	private int posExtendFull = -690,
			posEdge = -560,
			posCorner = -510,
			posStart = 0;
	
	private FriendScan friendScan;
	
	public MotorColour(FriendScan friendScan) {
		this.friendScan = friendScan;
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
