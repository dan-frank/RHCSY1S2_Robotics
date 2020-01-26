package checkpoints.checkpoint_3;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTSoundSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class SimpleChap {

	public static void main(String[] args) {
		float[] level = new float[2]; // A sound sample is just one number
		NXTSoundSensor sensor = new NXTSoundSensor(SensorPort.S2);
		SensorMode sound = (SensorMode) sensor.getDBAMode();
		SampleProvider clap = new ClapFilter(sound, 0.6f, 100);
		
		float[] level2 = new float[1];
		EV3UltrasonicSensor sensor2 = new EV3UltrasonicSensor(SensorPort.S1);
		SensorMode distance = (SensorMode) sensor2.getDistanceMode();
		
		
		BaseRegulatedMotor mLeft = new EV3LargeRegulatedMotor ( MotorPort.A );
		BaseRegulatedMotor mRight = new EV3LargeRegulatedMotor ( MotorPort.B );
		mLeft.setSpeed(360); // 1 Revolution Per Second ( RPS )
		mRight.setSpeed(360);
		mLeft.synchronizeWith( new BaseRegulatedMotor[] { mRight });
		
		boolean count = true;
		distance.fetchSample(level2, 0);
		
		// Follows the line
		while(level[0] > 0.50) {
			// Stores light into level[0]
			clap.fetchSample(level, 0);
			
			mLeft.startSynchronization();
			if (level[0] == 1.0f) {
				if (count) {
					mLeft.forward();
					mRight.forward();
					count = false;
				} else {
					mRight.stop();
					mLeft.stop();
					mLeft.rotate(707);
					Delay.msDelay(500);
					count = true;
				}
			}
			mLeft.endSynchronization();
			distance.fetchSample(level2, 0);
		}
		
		sensor.close();
		mLeft.close(); mRight.close();
	}

}
