



import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Dark implements Behavior {
	private MovePilot pilot;
	private double averageAmb;
	private EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
	private SampleProvider sp = cs.getAmbientMode();

	private float[] samples = new float[1];

	Dark(MovePilot p,double averageAmb) {
		pilot = p;
		this.averageAmb= averageAmb;
	}

	public void action() {
		double cur = pilot.getLinearSpeed();
		pilot.setLinearSpeed(cur/2);
		pilot.forward();
		
		
	}

// It is not sensible to suppress this Behavior. Just let it finish.
	public void suppress() {
	}

// Is it my turn?
	public boolean takeControl() {
		sp.fetchSample(samples, 0);
		return (samples[0] < averageAmb);
	}
}
