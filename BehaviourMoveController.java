import lejos.hardware.Sound;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourMoveController implements Behavior {
	private FriendCube friendCube;
	private FriendMove friendMove;

	public BehaviourMoveController(FriendCube friendCube, FriendMove friendMove) {
		this.friendCube = friendCube;
		this.friendMove = friendMove;
	}

	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.SOLVED && !friendMove.getInActionMove() && friendCube.getStateCubeExists() == StateCubeExists.CUBE;
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		Sound.beep();

		int solvedCubePos = friendCube.getSolvedCubePos();
		String[] solvedCube = friendCube.getSolvedCube();

		friendCube.incrementSolvedCubePos();
		
		if (solvedCubePos >= solvedCube.length) {
			friendCube.setStateCube(StateCube.COMPLETE);
		} else {
			String move = solvedCube[solvedCubePos];
			
			switch (move) {
			case "U":
				friendMove.setTotalRotations(StateRotate.CLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.UP);
				break;
			case "U2":
				friendMove.setTotalRotations(StateRotate.UTURN);
				friendMove.setStateMoveAction(StateMoveAction.UP);
				break;
			case "U'":
				friendMove.setTotalRotations(StateRotate.ANTICLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.UP);
				break;

			case "D":
				friendMove.setTotalRotations(StateRotate.CLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.DOWN);
				break;
			case "D2":
				friendMove.setTotalRotations(StateRotate.UTURN);
				friendMove.setStateMoveAction(StateMoveAction.DOWN);
				break;
			case "D'":
				friendMove.setTotalRotations(StateRotate.ANTICLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.DOWN);
				break;

			case "L":
				friendMove.setTotalRotations(StateRotate.ANTICLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.LEFT);
				break;
			case "L2":
				friendMove.setTotalRotations(StateRotate.UTURN);
				friendMove.setStateMoveAction(StateMoveAction.LEFT);
				break;
			case "L'":
				friendMove.setTotalRotations(StateRotate.CLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.LEFT);
				break;

			case "R":
				friendMove.setTotalRotations(StateRotate.ANTICLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.RIGHT);
				break;
			case "R2":
				friendMove.setTotalRotations(StateRotate.UTURN);
				friendMove.setStateMoveAction(StateMoveAction.RIGHT);
				break;
			case "R'":
				friendMove.setTotalRotations(StateRotate.CLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.RIGHT);
				break;

			case "F":
				friendMove.setTotalRotations(StateRotate.ANTICLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.FRONT);
				break;
			case "F2":
				friendMove.setTotalRotations(StateRotate.UTURN);
				friendMove.setStateMoveAction(StateMoveAction.FRONT);
				break;
			case "F'":
				friendMove.setTotalRotations(StateRotate.CLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.FRONT);
				break;

			case "B":
				friendMove.setTotalRotations(StateRotate.ANTICLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.BACK);
				break;
			case "B2":
				friendMove.setTotalRotations(StateRotate.UTURN);
				friendMove.setStateMoveAction(StateMoveAction.BACK);
				break;
			case "B'":
				friendMove.setTotalRotations(StateRotate.CLOCKWISE);
				friendMove.setStateMoveAction(StateMoveAction.BACK);
				break;
			}
			friendMove.setInAction(true);
		}
	}

	@Override
	public void suppress() {
	}

}
