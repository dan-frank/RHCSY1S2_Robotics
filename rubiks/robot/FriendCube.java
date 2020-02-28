package rubiks.robot;

/*
 * This friend can only be called by these behaviours:
 * - Scan
 * - Solve
 * - Move
 */

public class FriendCube {
	private StateCube stateCube;
	private String scrambledCube;
	private String[] solvedCube;
	
	public FriendCube() {
		stateCube = StateCube.UNREAD;
		solvedCube = new String[1];
	}
	
	public void setStateCube(StateCube stateCube) {
		this.stateCube = stateCube;
	}
	
	public StateCube getStateCube() {
		return stateCube;
	}
	
	public void setScrambledCube(String scrambledCube) {
		this.scrambledCube = scrambledCube;
	}
	
	public String getScrambledCube() {
		return scrambledCube;
	}
	
	public void setSolvedCube(String[] solvedCube) {
		this.solvedCube = solvedCube;
	}
	
	public String[] getSolvedCube() {
		return solvedCube;
	}
}
