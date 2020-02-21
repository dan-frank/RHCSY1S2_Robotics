package rubiks.robot;

import lejos.hardware.motor.BaseRegulatedMotor;

public class ThreadRotateCube extends Thread {

	private MotorRotate m;
	private int threeSixty = 4;
	
	public ThreadRotateCube(BaseRegulatedMotor mpr) {
		this.m = new MotorRotate(mpr);
	}
	
	public void run() {
		m.setRotate(threeSixty);
		m.rotate();
	}
}
