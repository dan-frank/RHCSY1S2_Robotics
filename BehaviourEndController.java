import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourEndController implements Behavior {
	private FriendCube friendCube;

	public BehaviourEndController(FriendCube friendCube) {
		this.friendCube = friendCube;
	}

	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.COMPLETE;
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		
		System.exit(0);
	}

	@Override
	public void suppress() {
	}

}
