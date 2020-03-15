import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class TestMain {

	public static void main(String[] args) {
		Delay.msDelay(1000);
		
		FriendOne friendOne = new FriendOne();
		FriendMove friendMove = new FriendMove();
		
		Behavior one = new BehaviourOne(friendOne, friendMove);
		Behavior moveActionLeft = new BehaviourMoveActionLeft(friendMove);
		Behavior moveRotate = new BehaviourMotorRotate(friendMove);
		Behavior moveFlip = new BehaviourMotorFlip(friendMove);
		Delay.msDelay(1000);

		Behavior[] behaviours = new Behavior[] { moveRotate, moveFlip, one, moveActionLeft };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
		arby.go();
	}

}