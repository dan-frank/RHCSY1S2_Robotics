package checkpoints.checkpoint_5;

import java.util.Random;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Dark implements Behavior {
	private double averageAmb;
	private MovePilot turner;
	private EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S1);
	private SampleProvider sp = us.getDistanceMode();
	private Random rgen = new Random();
	private float[] samples = new float[1];

	Dark(MovePilot p, double averageAmb) {
		turner = p;
		this.averageAmb = averageAmb;
	}

	public void action() {
		turner.travel(-50);
		turner.rotate((2 * rgen.nextInt(2) - 1) * 30);
	}

// It is not sensible to suppress this Behavior. Just let it finish.
	public void suppress() {
	}

// Is it my turn?
	public boolean takeControl() {
		sp.fetchSample(samples, 0);
		return (samples[0] < 0.20f);
	}
}
