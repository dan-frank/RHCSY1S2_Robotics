import lejos.hardware.Sound;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourMoveActionController implements Behavior {
	private FriendOne friendOne;
	private FriendMove friendMove;
	
	public BehaviourMoveActionController(FriendOne friendOne, FriendMove friendMove) {
		this.friendOne = friendOne;
		this.friendMove = friendMove;
	}
	
	@Override
	public boolean takeControl() {
		return friendOne.getStateAction() && !friendMove.getInActionMove();
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		Sound.buzz();
		
		int suppresscount = friendOne.getStateActionCount();
		
		if (suppresscount % 2 == 0) {
			friendMove.setTotalRotations(StateRotate.UTURN);
			friendMove.setStateMoveAction(StateMoveAction.FRONT);
			friendMove.setInAction(true);
		} else {
			friendMove.setTotalRotations(StateRotate.CLOCKWISE);
			friendMove.setStateMoveAction(StateMoveAction.DOWN);
			friendMove.setInAction(true);
		}
		
		System.out.println("statemoveaction + " + friendMove.getStateMoveAction());

		
		
		suppresscount++;
		friendOne.setStateActionCount(suppresscount);
		
		System.out.println("behaviour one supress count: " + suppresscount);
		if (suppresscount == 10) {
			friendOne.setStateAction(false);
		}
	}

	@Override
	public void suppress() { }

}
