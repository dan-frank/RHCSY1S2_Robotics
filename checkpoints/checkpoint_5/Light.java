package checkpoints.checkpoint_5;


import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Light implements Behavior {
	private double averageAmb;
	private MovePilot p;
	private double[] s;
	private SampleProvider sp;
	private float[] samples = new float[1];

	Light(MovePilot p, double[] speed, double averageAmb, EV3ColorSensor cs) {
		this.p = p;
		this.s = speed;
		this.averageAmb = averageAmb;
		this.sp = cs.getAmbientMode();

	}

	public void action() {
		LCD.clear(5);
		LCD.drawString("Light", 1, 5);
		
		s[0] = 150;
		if (!p.isMoving()) { p.forward(); }
	}

	// It is not sensible to suppress this Behavior. Just let it finish.
	public void suppress() {
	}

	// Is it my turn?
	public boolean takeControl() {
		sp.fetchSample(samples, 0);
		return samples[0] > averageAmb;
	}
	
}
