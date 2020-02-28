package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public class MotorFlip implements Behavior {
	private BaseRegulatedMotor m;	
	
	MotorFlip(BaseRegulatedMotor m) {
		this.m = m;
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
	
	public void flip() {
		m.rotate(360);
	}
	
	public void pin() {
		m.rotate(90);
	}
	
	public void retract() {
		m.rotate(-90);	
	}
}
