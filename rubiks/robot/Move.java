package rubiks.robot;

import lejos.robotics.subsumption.Behavior;

public class Move implements Behavior {
	// Friends
	FriendCube friendCube;
	FriendMove friendMove;

	// Moves
	private static final StateRotate clockwise = StateRotate.CLOCKWISE;
	private static final StateRotate uturn = StateRotate.UTURN;
	private static final StateRotate anticlockwise = StateRotate.ANTICLOCKWISE;

	public Move(FriendCube friendCube, FriendMove friendMove) {
		this.friendCube = friendCube;
		this.friendMove = friendMove;
	}

	public void run() {
		String[] moves = friendCube.getSolvedCube();

		for (int i = 0; i < moves.length; i++) {
			move(moves[i]);
		}
	}

	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.SOLVED;
	}

	@Override
	public void action() {
		String[] moves = friendCube.getSolvedCube();
		for (int i = 0; i < moves.length; i++) {
			move(moves[i]);
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
	}

	public void move(String action) {
		switch (action) {
		case "U":
			up(clockwise);
			break;
		case "U2":
			up(uturn);
			break;
		case "U'":
			up(anticlockwise);
			break;

		case "D":
			down(clockwise);
			break;
		case "D2":
			down(uturn);
			break;
		case "D'":
			down(anticlockwise);
			break;

		case "L":
			left(anticlockwise);
			break;
		case "L2":
			left(uturn);
			break;
		case "L'":
			left(clockwise);
			break;

		case "R":
			right(anticlockwise);
			break;
		case "R2":
			right(uturn);
			break;
		case "R'":
			right(clockwise);
			break;

		case "F":
			front(anticlockwise);
			break;
		case "F2":
			front(uturn);
			break;
		case "F'":
			front(clockwise);
			break;

		case "B":
			back(anticlockwise);
			break;
		case "B2":
			back(uturn);
			break;
		case "B'":
			back(clockwise);
			break;
		}
	}

	private void rotateLoop(StateRotate rotate) {
		pin();
		rotate(rotate);
		retract();
	}

	private void up(StateRotate rotate) {
		flip();
		flip();

		rotateLoop(rotate);

		flip();
		flip();
	}

	private void down(StateRotate rotate) {
		rotateLoop(rotate);
	}

	private void left(StateRotate rotate) {
		flip();

		rotateLoop(rotate);

		rotate(uturn);
		flip();
	}

	private void right(StateRotate rotate) {
		rotate(uturn);
		flip();

		rotateLoop(rotate);

		flip();
	}

	private void front(StateRotate rotate) {
		rotate(clockwise);
		flip();

		rotateLoop(rotate);

		rotate(uturn);
		flip();
		rotate(anticlockwise);
	}

	private void back(StateRotate rotate) {
		rotate(anticlockwise);
		flip();

		rotateLoop(rotate);

		rotate(uturn);
		flip();
		rotate(clockwise);
	}
	
	private void rotate(StateRotate rotate) {
		friendMove.setStateRotate(rotate);
		pause();
	}
	
	private void flip() {
		friendMove.setStateFlip(StateFlip.FLIP);
		pause();
	}

	private void pin() {
		friendMove.setStateFlip(StateFlip.PIN);
		pause();
	}
	
	private void retract() {
		friendMove.setStateFlip(StateFlip.RETRACT);
		pause();
	}
	
	private void pause() {
		while (friendMove.getInAction()) {}
		friendMove.setStateFlip(null);
		friendMove.setStateRotate(null);
	}
}