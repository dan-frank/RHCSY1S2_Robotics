import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourMoveActionDown implements Behavior {

	private FriendMove friendMove;
	private MotorRotate motorRotate;
	private MotorFlip motorFlip;
	
	public BehaviourMoveActionDown(FriendMove friendMove, MotorRotate motorRotate, MotorFlip motorFlip) {
		this.friendMove = friendMove;
		this.motorRotate = motorRotate;
		this.motorFlip = motorFlip;
	}
	
	@Override
	public boolean takeControl() {
		return friendMove.getStateMoveAction() == StateMoveAction.UP;
	}

	@Override
	public void action() {
		int actionStep = friendMove.getActionStep();
		
		if (actionStep < 7 && actionStep >= 0) {
			switch (actionStep) {
			case 0:
				motorFlip.run(StateFlip.FLIP);
				break;
			case 1:
				motorFlip.run(StateFlip.FLIP);
				break;
			case 2:
				motorFlip.run(StateFlip.PIN);
				break;
			case 3:
				motorRotate.run(friendMove.getTotalRotations());
				break;
			case 4:
				motorFlip.run(StateFlip.RETRACT);
				break;
			case 5:
				motorFlip.run(StateFlip.FLIP);
				break;
			case 6:
				motorFlip.run(StateFlip.FLIP);
				break;
			}
			
			actionStep++;
			friendMove.setActionStep(actionStep);
		} else {
			friendMove.setStateMoveAction(StateMoveAction.PAUSE);
			friendMove.setInAction(false);
			friendMove.setInActionMove(false);
			friendMove.resetActionStep();
			Delay.msDelay(200);
		}
	}

	@Override
	public void suppress() {}

}
