import lejos.robotics.subsumption.Behavior;

public class BehaviourScanActionCorner implements Behavior {
	private FriendScan friendScan;
	private MotorColour motorColour;

	public BehaviourScanActionCorner(FriendScan friendScan, MotorColour motorColour) {
		this.friendScan = friendScan;
		this.motorColour = motorColour;

	}

	@Override
	public boolean takeControl() {
		return friendScan.getStateMoveColourMotor() == StateMoveColourMotor.CORNER;
	}

	@Override
	public void action() {
		motorColour.run(StateMoveColourMotor.CORNER);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
