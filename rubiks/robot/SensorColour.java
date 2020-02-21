package rubiks.robot;

import lejos.hardware.sensor.EV3ColorSensor;

public class SensorColour extends RubeDaddy {
	
	private EV3ColorSensor s;
	private float[] measurement;
	
	public SensorColour() {
		this.s = sensorPortColour;
		this.measurement = new float[1];
	}
	
	public float scan() {
		s.fetchSample(measurement, 0);
		return measurement[0];
	}
}
