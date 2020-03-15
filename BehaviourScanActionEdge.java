import lejos.robotics.subsumption.Behavior;

public class BehaviourScanActionEdge implements Behavior {
	private FriendScan friendScan;
	private MotorColour motorColour;

	public BehaviourScanActionEdge(FriendScan friendScan, MotorColour motorColour) {
		this.friendScan = friendScan;
		this.motorColour = motorColour;

	}

	@Override
	public boolean takeControl() {
		return friendScan.getStateMoveColourMotor()==StateMoveColourMotor.EDGE;
	}

	@Override
	public void action() {
	     motorColour.run(StateMoveColourMotor.EDGE);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
