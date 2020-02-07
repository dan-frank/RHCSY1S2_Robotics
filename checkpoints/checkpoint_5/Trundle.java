package checkpoints.checkpoint_5;

import lejos.hardware.lcd.LCD;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Trundle implements Behavior {
	private MovePilot pilot;

	Trundle(MovePilot p) {
		this.pilot = p;
	}

	// Start trundling and return control immediately.
	public void action() {
		LCD.clear(5);
		LCD.drawString("Trundle", 1, 5);
		
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
