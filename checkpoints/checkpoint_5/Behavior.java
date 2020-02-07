package checkpoints.checkpoint_5;

public class Behavior {

	public static void main(String[] args) {
		MovePilot pilot = getPilot(MotorPort.A, MotorPort.B,56,73.5 );
		pilot.setLinearSpeed(200);
		Behavior trundle = new Trundle(pilot);
		Behavior backup = new Backup(pilot);
		
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

		
		
		Behavior dark = new Dark (pilot,lightLevelAvg);
		
		
	}
	private static MovePilot getPilot() {
		Motorport left,MotorPort right, int diam , int offset) {
		BaseRegulatedMotor mL = new EV3LargeRegulatedMotor (left) ;
		Wheel wL = WheeledChassis . ModelWheel (mL,diam).offset(-1 *
		offset);
		BaseRegulatedMotor mR = new EV3LargeRegulatedMotor (right) ;
		Wheel wR = WheeledChassis.ModelWheel (mR, diam ).offset(offset) ;
		Wheel ws = new Wheel [] {wR, wL} ;
		return new MovePilot (ws,WheeledChassis.TYPE_DIFFERENTIAL) ;
		}


}
