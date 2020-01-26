package checkpoints.checkpoint_3;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTSoundSensor;
import lejos.robotics.SampleProvider;

public class ClapClapCar {

	public static void main(String[] args) {
		float[] level = new float [1]; // A sound sample is just one number
		NXTSoundSensor ss = new NXTSoundSensor(SensorPort.S1);
		SampleProvider sound = ss.getDBAMode();
		
		while(true) {
			
		}
	}

}
