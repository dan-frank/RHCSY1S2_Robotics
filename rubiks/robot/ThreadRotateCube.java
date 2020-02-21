package rubiks.robot;

import lejos.utility.Delay;

public class ThreadRotateCube extends Thread {

	private MotorRotate m;
	private int threeSixty = 4;
	
	public ThreadRotateCube() {
		this.m = new MotorRotate();
	}
	
	public void run() {
		Delay.msDelay(2000);
		m.setRotate(threeSixty);
		m.rotate();
	}
}
