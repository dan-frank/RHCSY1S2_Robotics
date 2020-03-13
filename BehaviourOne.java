import lejos.hardware.Sound;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourOne implements Behavior {
	private FriendOne friendOne;
	private FriendMove friendMove;
	private int suppresscount = 0;
	
	public BehaviourOne(FriendOne friendOne, FriendMove friendMove) {
		this.friendOne = friendOne;
		this.friendMove = friendMove;
	}
	
	@Override
	public boolean takeControl() {
		return friendOne.getStateAction();
	}

	@Override
	public void action() {
		Sound.buzz();
		friendMove.setStateRotate(StateRotate.CLOCKWISE);
		Delay.msDelay(1000);
		System.out.println("friend move in action: " + friendMove.getInAction());
		while (friendMove.getInAction()) {}
		friendMove.setStateRotate(StateRotate.UTURN);
		
		
		
		
		
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
