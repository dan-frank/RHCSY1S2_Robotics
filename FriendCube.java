/*
 * This friend is used by these behaviours:
 * - Scan
 * - Solve
 * - Move
 */

public class FriendCube {
	private StateCubeExists stateCubeExists;
	private StateCube stateCube;
	private String scrambledCube;
	private String[] solvedCube;
	private int solvedCubePos;
	
	public FriendCube() {
		stateCubeExists = StateCubeExists.CUBE;
		stateCube = StateCube.UNREAD;
		solvedCube = new String[1];
		solvedCubePos = 0;
	}
	
	public void setStateCubeExists(StateCubeExists stateCubeExists) {
		this.stateCubeExists = stateCubeExists;
	}
	
	public StateCubeExists getStateCubeExists() {
		return stateCubeExists;
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
	
	public void incrementSolvedCubePos() {
		solvedCubePos++;
	}
	
	public int getSolvedCubePos() {
		return solvedCubePos;
	}
}
