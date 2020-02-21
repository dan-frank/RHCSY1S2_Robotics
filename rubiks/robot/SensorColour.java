package rubiks.robot;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class SensorColour extends RubeDaddy {
	private EV3ColorSensor s;
	private SampleProvider mode;
	private float[] measurement;
	
	public SensorColour() {
		this.s = sensorPortColour;
		this.mode = this.s.getRedMode();
		this.measurement = new float[1];
	}
	
	public float scan() {
		mode.fetchSample(measurement, 0);
		return measurement[0];
	}
}
