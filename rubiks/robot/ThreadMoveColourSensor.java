package rubiks.robot;

public class ThreadMoveColourSensor extends Thread {

	private MotorColour m;
	private int rotateCube = 4;
	
	public ThreadMoveColourSensor() {
		this.m = new MotorColour();
	}
	
	public void run() {
		m.goCentre();
		for (int i = 0; i < rotateCube; i++) {
			m.goEdge();
			m.goCorner();
		}
		m.returnToStart();
	}
}
