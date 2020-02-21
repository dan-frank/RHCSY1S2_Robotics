package rubiks.robot;

public class ThreadRotateCube extends Thread {

	private MotorRotate m;
	private int threeSixty = 4;
	
	public ThreadRotateCube() {
		this.m = new MotorRotate();
	}
	
	public void run() {
		m.setRotate(threeSixty);
		m.rotate();
	}
}
