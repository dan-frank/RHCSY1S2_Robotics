import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class TestMain {

	public static void main(String[] args) {
		Delay.msDelay(1000);
		System.out.println("Rube starts his long and arduous journey...");

		FriendCube friendCube = new FriendCube();
		FriendMove friendMove = new FriendMove();

		MotorRotate motorRotate = new MotorRotate(friendMove);
		MotorFlip motorFlip = new MotorFlip(friendMove);
		Delay.msDelay(1000);
		System.out.println("Rube made some friends along the way...");
		
		friendCube.setStateCube(StateCube.SOLVED);
		friendCube.setSolvedCube(new String[] { "L", "U", "D", "L", "R'", "F2", "B'" });
		Delay.msDelay(1000);
		System.out.println("Rube made fake friends...");

		Behavior moveController = new BehaviourMoveController(friendCube, friendMove);
		Behavior moveActionUp = new BehaviourMoveActionUp(friendMove, motorRotate, motorFlip);
		Behavior moveActionDown = new BehaviourMoveActionDown(friendMove, motorRotate, motorFlip);
		Behavior moveActionLeft = new BehaviourMoveActionLeft(friendMove, motorRotate, motorFlip);
		Behavior moveActionRight = new BehaviourMoveActionRight(friendMove, motorRotate, motorFlip);
		Behavior moveActionFront = new BehaviourMoveActionFront(friendMove, motorRotate, motorFlip);
		Behavior moveActionBack = new BehaviourMoveActionBack(friendMove, motorRotate, motorFlip);
		Delay.msDelay(1000);
		System.out.println("Rube developed behaviours...");

		Behavior[] behaviours = new Behavior[] { moveController, moveActionUp, moveActionDown, moveActionLeft, moveActionRight, moveActionFront, moveActionBack };
		Arbitrator arby = new Arbitrator(behaviours);
		Delay.msDelay(1000);
		System.out.println("Rube met arby...");
		arby.go();
	}

}