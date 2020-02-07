package checkpoints.checkpoint_5;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class SuperRobo {

	public static void main(String[] args) {
		MovePilot pilot = getPilot(56.0, 73.5);
		pilot.setLinearSpeed(200);
		Behavior trundle = new Trundle(pilot);
		Behavior backup = new Backup(pilot);
		float[] level = new float[2];

		EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S3);
		SampleProvider light = sensor.getAmbientMode();

		double maxLightLevel = 0;
		double minLightLevel = 1;

		// For print
		String lightLevelMax = "";
		String lightLevelMin = "";

		// Gets the average light levels
		while (!Button.ENTER.isDown()) {
			// Stores light into level[0]
			light.fetchSample(level, 0);

			// Gets largest sound
			if (level[0] > maxLightLevel) {
				maxLightLevel = level[0];
			}

			// Gets smallest sound
			if (level[0] < minLightLevel) {
				minLightLevel = level[0];
			}

			lightLevelMax = "MAX:" + String.valueOf(maxLightLevel);
			lightLevelMin = "MIN:" + String.valueOf(minLightLevel);

			LCD.clear(1);
			LCD.clear(2);
			LCD.drawString(lightLevelMax, 1, 1);
			LCD.drawString(lightLevelMin, 1, 2);

			Delay.msDelay(200);
		}

		double lightLevelAvg = (maxLightLevel + minLightLevel) / 2;
		String lightLevelAverage = "AVG:" + lightLevelAvg;

		LCD.clear(3);
		LCD.drawString(lightLevelAverage, 1, 3);

		Behavior dark = new Dark(pilot, lightLevelAvg);
		
		sensor.close();

	}

	private static MovePilot getPilot(double diam , double offset) {
		BaseRegulatedMotor mL = new EV3LargeRegulatedMotor(MotorPort.A) ;
		Wheel wL = WheeledChassis.modelWheel (mL,diam).offset(-1 * offset);
		BaseRegulatedMotor mR = new EV3LargeRegulatedMotor(MotorPort.B) ;
		Wheel wR = WheeledChassis.modelWheel (mR, diam ).offset(offset) ;
		Wheel[] ws = new Wheel[] {wR, wL} ;
		Chassis chassis = new WheeledChassis (ws, WheeledChassis.TYPE_DIFFERENTIAL);
		return new MovePilot(chassis) ;
	}
		


}
