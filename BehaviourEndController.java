import lejos.hardware.Battery;
import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourEndController implements Behavior {
	private FriendCube friendCube;
	private FriendMove friendMove;
	private FriendScan friendScan;
	
	private boolean exitSteps;

	public BehaviourEndController(FriendCube friendCube, FriendMove friendMove, FriendScan friendScan) {
		this.friendCube = friendCube;
		this.friendMove = friendMove;
		this.friendScan = friendScan;
		this.exitSteps = false;
	}

	@Override
	public boolean takeControl() {
		return (!friendMove.getInAction() || !friendScan.isInAction()) && (exitSteps || Button.ESCAPE.isDown() || Battery.getVoltage() < 6.5 || friendCube.getStateCube() == StateCube.COMPLETE);
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		
		exitSteps = true;

		int exitStep = friendMove.getExitStep();

		if (exitStep < 7 && exitStep >= 0) {
			switch (exitStep) {
			case 0:
				System.out.println("Resetting rotate motor positions...");
				friendMove.setStateRotate(StateRotate.RESET);
				break;
			case 1:
				System.out.println("Resetting colour motor positions...");
				friendScan.setStateMoveColourMotor(StateMoveColourMotor.RESET);
				break;
			case 2:
				System.out.println("Resetting flip motor positions...");
				friendMove.setStateFlip(StateFlip.RESET);
				break;
			}

			friendMove.setInAction(true);
			friendScan.setInAction(true);
			
			exitStep++;
			friendMove.setExitStep(exitStep);
			Delay.msDelay(200);
		} else {
			friendMove.resetExitStep();
			Delay.msDelay(200);
			
			System.out.println("Exiting programme...");
			System.exit(0);
		}
	}

	@Override
	public void suppress() {
	}

}
