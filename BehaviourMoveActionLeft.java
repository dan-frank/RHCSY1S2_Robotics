import lejos.robotics.subsumption.Behavior;

public class BehaviourMoveActionLeft implements Behavior {

	private FriendMove friendMove;
	private MotorRotate motorRotate;
	private MotorFlip motorFlip;
	
	public BehaviourMoveActionLeft(FriendMove friendMove) {
		this.friendMove = friendMove;
		this.motorRotate = new MotorRotate(friendMove);
		this.motorFlip = new MotorFlip(friendMove);
	}
	
	@Override
	public boolean takeControl() {
		return friendMove.getStateMoveAction() == StateMoveAction.LEFT;
	}

	@Override
	public void action() {
		System.out.println("move action left");
		
		int actionStep = friendMove.getActionStep();
		
		if (actionStep < 6 && actionStep >= 0) {
			switch (actionStep) {
			case 0:
				motorFlip.run(StateFlip.FLIP);
				break;
			case 1:
				motorFlip.run(StateFlip.PIN);
				break;
			case 2:
				motorRotate.run(friendMove.getTotalRotations());
				break;
			case 3:
				motorFlip.run(StateFlip.RETRACT);
				break;
			case 4:
				motorRotate.run(StateRotate.UTURN);
				break;
			case 5:
				motorFlip.run(StateFlip.FLIP);
				break;
			}
			
			actionStep++;
			friendMove.setActionStep(actionStep);
		} else {
			friendMove.setStateMoveAction(StateMoveAction.PAUSE);
			friendMove.setInAction(false);
			friendMove.setInActionMove(false);
			friendMove.setActionStep(0);
		}
	}

	@Override
	public void suppress() {}

}
