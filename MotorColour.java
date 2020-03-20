import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorColour {
	
	private final BaseRegulatedMotor m;
	
	private int corner = -520,
			edge = -580,
			center = -690;
	
	private int posStart = 0,
			pos0 = corner,	// Corner
			pos1 = edge,	// Edge
			pos2 = corner,	// Corner
			pos3 = edge,	// Edge
			pos4 = center,	// Centre
			pos5 = edge,	// Edge
			pos6 = corner,	// Corner
			pos7 = edge,	// Edge
			pos8 = corner;	// Corner
			
	
	public MotorColour(FriendScan friendScan) {
		this.m = friendScan.getMotorColour();
	}

	public void run(StateMoveColourMotor state) {
		switch (state) {
		case CENTRE4:
			System.out.println("Motor rotate clockwise");
			goCentre4();
			break;

		case EDGE5:
			System.out.println("Motor rotate anticlockwise");
			goEdge5();
			break;
		
		case EDGE3:
			System.out.println("Motor rotate anticlockwise");
			goEdge3();
			break;
			
		case EDGE1:
			System.out.println("Motor rotate anticlockwise");
			goEdge1();
			break;
		
		case EDGE7:
			System.out.println("Motor rotate anticlockwise");
			goEdge7();
			break;

		case CORNER2:
			System.out.println("Motor rotate uturn");
			goCorner2();
			break;
			
		case CORNER6:
			System.out.println("Motor rotate uturn");
			goCorner6();
			break;
			
		case CORNER0:
			System.out.println("Motor rotate uturn");
			goCorner0();
			break;
			
		case CORNER8:
			System.out.println("Motor rotate uturn");
			goCorner8();
			break;

		case BACK:
			returnToStart();
		default:
			System.out.println("Motor rotate pause");
			break;
		}
	}

	
	public void goCentre4() {
		m.rotateTo(pos4);
	}

	public void goEdge5() {
		m.rotateTo(pos5);
	}
	
	public void goEdge3() {
		m.rotateTo(pos3);
	}
	
	public void goEdge1() {
		m.rotateTo(pos1);
	}
	
	public void goEdge7() {
		m.rotateTo(pos7);
	}

	public void goCorner2() {
		m.rotateTo(pos2);
	}
	
	public void goCorner6() {
		m.rotateTo(pos6);
	}
	
	public void goCorner0() {
		m.rotateTo(pos0);
	}
	
	public void goCorner8() {
		m.rotateTo(pos8);
	}

	public void returnToStart() {
		m.rotateTo(posStart);
	}
}
