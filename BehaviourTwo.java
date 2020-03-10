import lejos.robotics.subsumption.Behavior;
import lejos.hardware.Sound;

public class BehaviourTwo implements Behavior {
	private FriendOne friendOne;
	
	public BehaviourTwo(FriendOne friendOne) {
		this.friendOne = friendOne;
	}

	@Override
	public boolean takeControl() {
		return friendOne.getStateOne() && friendOne.getStateAction();
	}

	@Override
	public void action() {
		Sound.beep();
		friendOne.setStateOne(false);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
	}
}
