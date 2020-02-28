package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;

public class MotorRotate implements Behavior {

	private final BaseRegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.C);

	
	private final float speedDefault = 360f;
	private final int ninetyDegrees = 270;
	
	private float speed;
	private int rotate;

	public MotorRotate() {
		this.speed = speedDefault;
		this.rotate = ninetyDegrees;
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
	}

	public void setRotate(int multiplier) {
		this.rotate = ninetyDegrees * multiplier;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void rotate() {
		m.setSpeed(speed);
		m.rotate(rotate);
		resetVars();
	}
	
	public void rotateHalf() {
		m.setSpeed(speed);
		m.rotate(rotate / 2);
		resetVars();
	}
	
	public void resetVars() {
		rotate = ninetyDegrees;
		speed = speedDefault;
	}
}
