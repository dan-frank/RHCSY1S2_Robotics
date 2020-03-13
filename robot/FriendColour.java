package robot;

/**
 * Friend can be called by
 * 		- Scan 
 * 		- MotorColour
**/

public class FriendColour {
	
	private StateMoveColourMotor stateMoveColourMotor;
	private StateReadColour stateReadColour;
	
	public FriendColour() {
		this.stateMoveColourMotor = null;
		this.stateReadColour = null;
	}

	public StateMoveColourMotor getStateMoveColourMotor() {
		return stateMoveColourMotor;
	}

	public void setStateMoveColourMotor(StateMoveColourMotor stateMoveColourMotor) {
		this.stateMoveColourMotor = stateMoveColourMotor;
	}

	public StateReadColour getStateReadColour() {
		return stateReadColour;
	}

	public void setStateReadColour(StateReadColour stateReadColour) {
		this.stateReadColour = stateReadColour;
	}
	
	
}
