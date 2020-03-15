import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class ScanFriend {
	private StateScan stateScan;
	private boolean inAction;
	private int actionStep;
	
	public int getActionStep() {
		return actionStep;
	}

	public void setActionStep(int actionStep) {
		this.actionStep = actionStep;
	}

	private final BaseRegulatedMotor motorFlip = new EV3LargeRegulatedMotor(MotorPort.B);
	private final BaseRegulatedMotor motorRotate = new EV3LargeRegulatedMotor(MotorPort.C);
	private final BaseRegulatedMotor motorColour = new EV3MediumRegulatedMotor(MotorPort.A);
	
	public ScanFriend() {
		this.stateScan = stateScan.DONTREAD;
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

	public BaseRegulatedMotor getMotorFlip() {
		return motorFlip;
	}

	public BaseRegulatedMotor getMotorRotate() {
		return motorRotate;
	}

	public BaseRegulatedMotor getMotorColour() {
		return motorColour;
	}
}
