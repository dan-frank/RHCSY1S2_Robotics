package rubiks.robot;

import lejos.utility.Delay;

public class ThreadRotateCube extends Thread {

	private MotorRotate m;
	private int threeSixty = 4;
	
	public ThreadRotateCube() {
		this.m = new MotorRotate();
	}
	
	public void run() {
		Delay.msDelay(2500);
		m.setSpeed(360);
		m.setRotate(threeSixty);
		m.rotate();
	}
}
