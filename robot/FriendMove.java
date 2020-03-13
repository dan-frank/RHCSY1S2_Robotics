package robot;
//- MoveCube (Scan, Move, MotorRotate, MotorFlip)

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

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
	
	private final BaseRegulatedMotor motorRotate = new EV3LargeRegulatedMotor(MotorPort.C);
	private final BaseRegulatedMotor motorFlip = new EV3LargeRegulatedMotor(MotorPort.B);


	public FriendMove() {
		this.stateFlip = StateFlip.PAUSE;
		this.stateRotate = StateRotate.PAUSE;
		this.inAction = false;
	}
	
	public BaseRegulatedMotor getMotorRotate() {
		return motorRotate;
	}
	
	
	public BaseRegulatedMotor getMotorFlip() {
		return motorFlip;
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
//		System.out.println("FriendMoveInActionSet: " + this.inAction);
	}
	
	public boolean getInAction() {
//		System.out.println("FriendMoveInActionCalled: " + this.inAction);
		return this.inAction;
	}
}
