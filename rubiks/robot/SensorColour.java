package rubiks.robot;

import lejos.robotics.SampleProvider;

public class SensorColour implements RubeDaddy {
	private SampleProvider mode;
	private float[] measurement;
	
	public SensorColour() {
		this.mode = (SampleProvider) sensorColour.getRedMode();
		this.measurement = new float[1];
	}
	
	public float scan() {
		mode.fetchSample(measurement, 0);
		return measurement[0];
	}
}
