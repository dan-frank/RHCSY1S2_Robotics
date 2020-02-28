package rubiks.robot;

import java.util.Arrays;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class ThreadScanCube extends Thread {
	public static EV3ColorSensor scanLight = new EV3ColorSensor(SensorPort.S2);
	public static SensorMode modeRed = scanLight.getRedMode();
	
	private String[] side;
	private int tilesOnCube;
	
	public ThreadScanCube() {
		this.tilesOnCube = 9;
		this.side = new String[this.tilesOnCube];
	}
	
	public void run() {
		Delay.msDelay(2500);
		
		int[] tileOrder = { 4, 5, 2, 1, 0, 3, 6, 7, 8 };
		float[] sample = new float[modeRed.sampleSize()];
		int pos;
		
		for (int i = 0; i < tilesOnCube; i++) {
			modeRed.fetchSample(sample, 0);
			pos = tileOrder[i];
			LCD.clear(6);
			LCD.drawString("" + sample[0], 1, 6);
			side[pos] = getColour(sample[0]);
			Delay.msDelay(300);
		}
		
		LCD.drawString(Arrays.deepToString(side), 0, 7);
	}
	
	private String getColour(float measurement) {
		String colour = "";
		
//		**U**: Upper/Top   = White  (0.85)
//		**L**: Left        = Green  (0.22)
//		**F**: Front       = Red    (0.51)
//		**R**: Right       = Blue   (0.13)
//		**B**: Back        = Orange (0.67)
//		**D**: Down/Bottom = Yellow (0.72)
		
		if (measurement >= 0.80f && measurement <= 1.00f) {
			colour = "U";
		} else if (measurement >= 0.20f && measurement <= 0.30f) {
			colour = "L";
		} else if (measurement >= 0.45f && measurement <= 0.55f) {
			colour = "F";
		} else if (measurement >= 0.10f && measurement <= 0.20f) {
			colour = "R";
		} else if (measurement >= 0.60f && measurement <= 0.70f) {
			colour = "B";
		} else if (measurement >= 0.70f && measurement <= 0.80f) {
			colour = "D";
		}
		
		return colour;
	}
}
