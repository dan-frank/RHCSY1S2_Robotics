package rubiks.robot;

import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

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

	@Override
	public boolean takeControl() {
		StateCube state = friendCube.getStateCube();
		System.out.println("Move: State = " + state);
		System.out.println("Move: InAction = " + friendMove.getInAction());
		boolean control = state == StateCube.SOLVED && !friendMove.getInAction();
		Delay.msDelay(2000);
		return control;
	}

	@Override
	public void action() {
		System.out.println("Move behavior action");
		
		String[] moves = friendCube.getSolvedCube();
		for (int i = 0; i < moves.length; i++) {
			reset();
			move(moves[i]);
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
	}

	public void move(String action) {
		System.out.println("Move Behavior Move");
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

	private void up(StateRotate rotate) {
		System.out.println("Move behavior move up");
		flip();
		flip();

		rotateLoop(rotate);

		flip();
		flip();
	}

	private void down(StateRotate rotate) {
		System.out.println("Move behavior move down");
		rotateLoop(rotate);
	}

	private void left(StateRotate rotate) {
		System.out.println("Move behavior move left");
		flip();

		rotateLoop(rotate);

		rotate(uturn);
		flip();
	}

	private void right(StateRotate rotate) {
		System.out.println("Move behavior move right");
		rotate(uturn);
		flip();

		rotateLoop(rotate);

		flip();
	}

	private void front(StateRotate rotate) {
		System.out.println("Move behavior move front");
		rotate(clockwise);
		flip();

		rotateLoop(rotate);

		rotate(uturn);
		flip();
		rotate(anticlockwise);
	}

	private void back(StateRotate rotate) {
		System.out.println("Move behavior move back");
		rotate(anticlockwise);
		flip();

		rotateLoop(rotate);

		rotate(uturn);
		flip();
		rotate(clockwise);
	}

	private void rotateLoop(StateRotate rotate) {
		System.out.println("Move behavior move rotate cube");
		pin();
		rotate(rotate);
		retract();
	}
	
	private void rotate(StateRotate rotate) {
		System.out.println("Move behavior rotate");
		friendMove.setStateRotate(rotate);
//		while ()
	}
	
	private void flip() {
		System.out.println("Move behavior flip");
		friendMove.setStateFlip(StateFlip.FLIP);
	}

	private void pin() {
		System.out.println("Move behavior pin");
		friendMove.setStateFlip(StateFlip.PIN);
	}
	
	private void retract() {
		System.out.println("Move behavior retract");
		friendMove.setStateFlip(StateFlip.RETRACT);
	}
	
	private void reset() {
		Delay.msDelay(1000);
		System.out.println("Move behavior reset");
		friendMove.setStateFlip(StateFlip.PAUSE);
		friendMove.setStateRotate(StateRotate.PAUSE);
	}
}