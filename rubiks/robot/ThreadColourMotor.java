package rubiks.robot;

import lejos.utility.Delay;

public class ThreadColourMotor extends Thread {
	private MotorColour m;
	private int cubeRotations = 4;
	private int delay = 450;
	
	public ThreadColourMotor() {
		this.m = new MotorColour();
	}
	
	public void run() {
		m.goCentre();
		Delay.msDelay(delay);
		
		for (int i = 0; i < cubeRotations; i++) {
			m.goEdge();
			Delay.msDelay(delay);
			m.goCorner();
			Delay.msDelay(delay);
			m.returnToStart();
		}
		
		m.returnToStart();
	}
}