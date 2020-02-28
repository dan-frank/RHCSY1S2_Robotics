package rubiks.robot;
//- MoveCube (Scan, Move, MotorRotate, MotorFlip)

//- States
//	- Move motor rotate
//		- Sub-states
//			- Clockwise
//			- Anti-clockwise
//			- U-turn
//	- Move motor flip
//		- Sub-states
//			- Pin
//			- Retract
//			- Flip

public class FriendMove {
	private StateFlip stateFlip;
	private StateRotate stateRotate;

	public FriendMove() {
		this.stateFlip = null;
		this.stateRotate = null;

	}

	public StateFlip getStateFlip() {
		return this.stateFlip;
	}

	public StateRotate getStateRotate() {
		return this.stateRotate;
	}

	public void setStateFlip(StateFlip state) {
		this.stateFlip = state;
	}

	public void setStateRotate(StateRotate state) {
		this.stateRotate = state;
	}
}
