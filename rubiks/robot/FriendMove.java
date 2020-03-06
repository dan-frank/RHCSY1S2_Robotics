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
	private boolean inAction; 

	public FriendMove() {
		this.stateFlip = StateFlip.PAUSE;
		this.stateRotate = StateRotate.PAUSE;
		this.inAction = false;
	}

	public void setStateFlip(StateFlip state) {
		this.stateFlip = state;
	}

	public StateFlip getStateFlip() {
		return this.stateFlip;
	}

	public void setStateRotate(StateRotate state) {
		this.stateRotate = state;
	}

	public StateRotate getStateRotate() {
		return this.stateRotate;
	}
	
	public void setInAction(boolean inAction) {
		this.inAction = inAction;
		System.out.println("FriendMoveInActionSet: " + this.inAction);
	}
	
	public boolean getInAction() {
		System.out.println("FriendMoveInActionCalled: " + this.inAction);
		return this.inAction;
	}
}
