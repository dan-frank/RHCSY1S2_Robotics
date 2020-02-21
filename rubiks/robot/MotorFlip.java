package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class MotorFlip implements RubeDaddy {
	private BaseRegulatedMotor m;	
	
	MotorFlip() {
		this.m = motorPortFlip;
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
