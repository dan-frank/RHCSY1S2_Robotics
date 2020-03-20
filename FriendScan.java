import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class FriendScan {
	private StateScan stateScan;
	private StateMoveColourMotor stateMoveColourMotor;
	private boolean inAction;
	private int actionStep = 0;
	private int actionStep2 = 0;
	private static float[][][] scrambledCubeArray = new float[6][9][3];
	
	public int getActionStep() {
		return actionStep;
	}

	public void setActionStep(int actionStep) {
		this.actionStep = actionStep;
	}
	
	public static float[][][] getScrambledCubeArray() {
		return scrambledCubeArray;
	}
	
	public int getActionStep2() {
		return actionStep2;
	}
	
	public void setActionStep2(int actionStep2) {
		this.actionStep2 = actionStep2;
	}

	private final BaseRegulatedMotor motorColour = new EV3MediumRegulatedMotor(MotorPort.A);
	
	public FriendScan() {
		this.stateMoveColourMotor = StateMoveColourMotor.BACK;
		this.stateScan = StateScan.DONTREAD;
		this.inAction = false;
		this.actionStep = 0;
	}

	public StateScan getStateScan() {
		return stateScan;
	}

	public void setStateScan(StateScan stateScan) {
		this.stateScan = stateScan;
	}

	public boolean isInAction() {
		return inAction;
	}

	public void setInAction(boolean inAction) {
		this.inAction = inAction;
	}
	
	public void resetActionStep() {
		this.actionStep = 0;
	}


	public BaseRegulatedMotor getMotorColour() {
		return motorColour;
	}

	public StateMoveColourMotor getStateMoveColourMotor() {
		return stateMoveColourMotor;
	}

	public void setStateMoveColourMotor(StateMoveColourMotor stateMoveColourMotor) {
		this.stateMoveColourMotor = stateMoveColourMotor;
	}
}
