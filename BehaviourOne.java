import lejos.hardware.Sound;
import lejos.robotics.subsumption.Behavior;

public class BehaviourOne implements Behavior {
	private FriendOne friendOne;
	private int suppresscount = 0;
	
	public BehaviourOne(FriendOne friendOne) {
		this.friendOne = friendOne;
	}
	
	@Override
	public boolean takeControl() {
		return friendOne.getStateAction();
	}

	@Override
	public void action() {
		Sound.buzz();
		friendOne.setStateOne(true);
		friendOne.setStateActionCount(friendOne.getStateActionCount() + 1);
		
		suppresscount++;
		System.out.println("behaviour one supress count: " + suppresscount);
		if (friendOne.getStateActionCount() == 10) {
			friendOne.setStateAction(false);
		}
	}

	@Override
	public void suppress() {
	}

}
