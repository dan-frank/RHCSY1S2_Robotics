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
	private int stateRotateTimes;
	private boolean inAction; 

	public FriendMove() {
		this.stateFlip = null;
		this.stateRotate = null;
		this.stateRotateTimes = 1;
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
	}
	
	public boolean getInAction() {
		return this.inAction;
	}

	public void setStateRotateTimes(int times) {
		this.stateRotateTimes = times;
	}

	public int getStateRotateTimes() {
		return this.stateRotateTimes;
	}
}
