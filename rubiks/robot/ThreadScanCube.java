package rubiks.robot;

import java.util.Arrays;

import lejos.hardware.lcd.LCD;

public class ThreadScanCube extends Thread {

	private SensorColour s;
	private String[] side;
	private int tilesOnCube = 9;
	private int[] tileOrder = { 4, 5, 2, 1, 0, 3, 6, 7, 8 };
	
	public ThreadScanCube() {
		this.s = new SensorColour();
		this.side = new String[9];
	}
	
	public void run() {
		int pos;
		
		for (int i = 0; i < tilesOnCube; i++) {
			pos = tileOrder[i];
			side[pos] = getColour(s.scan());
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
		
		if (measurement == 0.85f) {
			colour = "U";
		} else if (measurement == 0.22f) {
			colour = "L";
		} else if (measurement == 0.51f) {
			colour = "F";
		} else if (measurement == 0.13f) {
			colour = "R";
		} else if (measurement == 0.67f) {
			colour = "B";
		} else if (measurement == 0.72f) {
			colour = "D";
		}
		
		return colour;
	}
}
