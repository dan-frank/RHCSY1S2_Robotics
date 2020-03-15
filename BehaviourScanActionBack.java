import lejos.robotics.subsumption.Behavior;

public class BehaviourScanActionBack implements Behavior {
	private FriendScan friendScan;
	private MotorColour motorColour;

	public BehaviourScanActionBack(FriendScan friendScan, MotorColour motorColour) {
		this.friendScan = friendScan;
		this.motorColour = motorColour;

	}

	@Override
	public boolean takeControl() {
		return friendScan.getStateMoveColourMotor()==StateMoveColourMotor.BACK;
	}

	@Override
	public void action() {
	     motorColour.run(StateMoveColourMotor.BACK);

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
