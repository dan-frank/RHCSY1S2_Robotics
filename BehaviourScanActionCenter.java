import lejos.robotics.subsumption.Behavior;

public class BehaviourScanActionCenter implements Behavior {
	private FriendScan friendScan;
	private MotorColour motorColour;

	public BehaviourScanActionCenter(FriendScan friendScan, MotorColour motorColour) {
		this.friendScan = friendScan;
		this.motorColour = motorColour;

	}

	@Override
	public boolean takeControl() {
		return friendScan.getStateMoveColourMotor()==StateMoveColourMotor.CENTRE;
	}

	@Override
	public void action() {
	     motorColour.run(StateMoveColourMotor.CENTRE);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
