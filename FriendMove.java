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
	private StateMoveAction stateMoveAction;
	private int actionStep = 0;
	private StateRotate totalRotations;
	private boolean inAction;
	private boolean inActionMove;

	private final BaseRegulatedMotor motorFlip = new EV3LargeRegulatedMotor(MotorPort.B);
	private final BaseRegulatedMotor motorRotate = new EV3LargeRegulatedMotor(MotorPort.C);

	public FriendMove() {
		this.stateFlip = StateFlip.PAUSE;
		this.stateRotate = StateRotate.PAUSE;
		this.stateMoveAction = StateMoveAction.PAUSE;
		this.inAction = false;
		this.inActionMove = false;
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
	}

	public boolean getInAction() {
		return this.inAction;
	}

	public void setActionStep(int actionStep) {
		this.actionStep = actionStep;
	}

	public int getActionStep() {
		return this.actionStep;
	}

	public void setStateMoveAction(StateMoveAction stateMoveAction) {
		this.stateMoveAction = stateMoveAction;
	}

	public StateMoveAction getStateMoveAction() {
		return this.stateMoveAction;
	}

	public void setTotalRotations(StateRotate totalRotations) {
		this.totalRotations = totalRotations;
	}

	public StateRotate getTotalRotations() {
		return this.totalRotations;
	}


	public void setInActionMove(boolean inActionMove) {
		this.inActionMove = inActionMove;
	}

	public boolean getInActionMove() {
		return this.inActionMove;
	}
	
}
