package rubiks.robot;

import lejos.utility.Delay;

public class ThreadRotateCube extends Thread {

	private MotorRotate m;
	private MotorFlip f;
	private int threeSixty = 4;
	
	public ThreadRotateCube() {
		this.m = new MotorRotate();
		this.f= new MotorFlip();
	}
	
	public void run() {
		for(int i =0;i<4;i++) {
		Delay.msDelay(2500);
		m.setSpeed(200);
		m.rotate();
		Delay.msDelay(2500);
		f.pin();
		f.retract();
		
		
		}
	
		
	}
}
