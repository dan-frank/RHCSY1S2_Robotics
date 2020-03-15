import lejos.hardware.Sound;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourScan implements Behavior {
	private FriendCube friendCube;
	private FriendMove friendMove;
	
	public BehaviourScan(FriendCube friendCube, FriendMove friendMove) {
		this.friendCube = friendCube;
		this.friendMove = friendMove;
	}
	
	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.UNREAD && !friendMove.getInActionMove();
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		Sound.buzz();
		
		int suppresscount = friendCube.getSolvedCubePos();
		
		if (suppresscount % 2 == 0) {
			friendMove.setTotalRotations(StateRotate.UTURN);
			friendMove.setStateMoveAction(StateMoveAction.LEFT);
			friendMove.setInAction(true);
		} else {
			friendMove.setTotalRotations(StateRotate.CLOCKWISE);
			friendMove.setStateMoveAction(StateMoveAction.LEFT);
			friendMove.setInAction(true);
		}
		
		System.out.println("statemoveaction + " + friendMove.getStateMoveAction());

		
		
		suppresscount++;
		friendCube.incrementSolvedCubePos();
		
		System.out.println("behaviour one supress count: " + suppresscount);
		if (suppresscount == 10) {
			friendCube.setStateCube(StateCube.READ);
		}
	}

	@Override
	public void suppress() { }

}