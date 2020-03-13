import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class TestMain {

	public static void main(String[] args) {
		Delay.msDelay(1000);
		
		FriendOne friendOne = new FriendOne();
		FriendMove friendMove = new FriendMove();
		
		Behavior one = new BehaviourOne(friendOne, friendMove);
		Behavior rotate = new BehaviourMotorRotate(friendMove);
		Delay.msDelay(1000);

		Behavior[] behaviours = new Behavior[] { one, rotate };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
		arby.go();
	}

}