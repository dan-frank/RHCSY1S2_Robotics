package checkpoints.checkpoint_5;

import lejos.robotics.subsumption.Behavior;

public class Bluetooth implements Behavior {
	
	public boolean takeControl() {
		return true;	//returns true if a bluetooth message is available
	}
	
	public void action(){}
	
	public void suppress(){}
}
