public class FriendOne {
	private boolean stateAction = true;
	private boolean stateOne;
	private int count = 0;
	
	public FriendOne() {
		stateOne = false;
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
	
	public boolean getStateOne() {
		return stateOne;
	}
	
	public void setStateOne(boolean state) {
		this.stateOne = state;
	}
}
