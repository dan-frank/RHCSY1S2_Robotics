package rubiks.robot;

/**
 * Friend can be called by
 * 		- Scan 
 * 		- MotorColour
**/

public class FriendColour {
	
	private StateMoveMotor stateMoveMotor;
	private StateReadColour stateReadColour;
	
	public FriendColour() {
		this.stateMoveMotor = null;
		this.stateReadColour = null;
	}

	public StateMoveMotor getStateMoveMotor() {
		return stateMoveMotor;
	}

	public void setStateMoveMotor(StateMoveMotor stateMoveMotor) {
		this.stateMoveMotor = stateMoveMotor;
	}

	public StateReadColour getStateReadColour() {
		return stateReadColour;
	}

	public void setStateReadColour(StateReadColour stateReadColour) {
		this.stateReadColour = stateReadColour;
	}
	
	
}
