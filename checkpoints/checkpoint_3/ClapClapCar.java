package checkpoints.checkpoint_3;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTSoundSensor;
import lejos.robotics.SampleProvider;

public class ClapClapCar {

	public static void main(String[] args) {
		float[] level = new float[1]; // A sound sample is just one number
		NXTSoundSensor ss = new NXTSoundSensor(SensorPort.S2);
		SampleProvider sound = ss.getDBAMode();
		
		String soundLevel = "";
		
		while(true) {
			sound.fetchSample(level, 0);
			
			soundLevel = String.valueOf(level[0]);
			
			LCD.clear();
			LCD.drawString(soundLevel, 2 , 2);
		}
	}

}
