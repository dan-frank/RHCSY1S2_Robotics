package rubiks.robot;

import lejos.hardware.sensor.SensorMode;

public class SensorUltrasonic implements RubeDaddy {
	private SensorMode mode;
	private float[] measurement;
	
	public SensorUltrasonic() {
		this.mode = (SensorMode) sensorUltrasonic.getDistanceMode();
		this.measurement = new float[1];
	}
	
	public float scan() {
		mode.fetchSample(measurement, 0);
		return measurement[0];
	}
}
