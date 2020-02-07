package checkpoints.checkpoint_5;

import lejos.hardware.lcd.LCD;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Trundle implements Behavior {
	private MovePilot pilot;
	private double[] s = new double[1];

	Trundle(MovePilot p, double[] speed) {
		this.pilot = p;
		this.s = speed;
	}

	// Start trundling and return control immediately.
	public void action() {
		LCD.clear(5);
		LCD.drawString("Trundle", 1, 5);
		
		pilot.setLinearSpeed(s[0]);
		if (!pilot.isMoving()) { pilot.forward(); }
	}

	// Since action returns immediately this is probably never called
	public void suppress() {
	}

	// Is it my turn?
	public boolean takeControl() {
		return true;
	}
}
