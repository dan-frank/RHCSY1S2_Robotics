public class FriendOne {
	private boolean stateAction = true;
	private StateCube stateOne;
	private int count = 0;
	
	public FriendOne() {
		stateOne = StateCube.UNREAD;
	}
	
	public boolean getStateAction() {
		return stateAction;
	}
	
	public void setStateAction(boolean state) {
		this.stateAction = state;
	}
	
	public int getStateActionCount() {
		return count;
	}
	
	public void setStateActionCount(int count) {
		this.count = count;
	}
	
	public StateCube getStateOne() {
		return stateOne;
	}
	
	public void setStateOne(StateCube state) {
		this.stateOne = state;
	}
}
