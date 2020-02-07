package checkpoints.checkpoint_5;

import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class Sonic implements Behavior {
	
	private MovePilot p;
	private double[] s;
	
	Sonic (MovePilot pilot, double[] speed) {
		this.p = pilot;
		this.s = speed;
	}
	
	public void action() {
		p.setLinearSpeed(s[0]);
	}

	// It is not sensible to suppress this Behavior. Just let it finish.
	public void suppress() {
	}

	// Is it my turn?
	public boolean takeControl() {
		return true;
	}

}
