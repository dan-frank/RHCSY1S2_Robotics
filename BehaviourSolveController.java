import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
import solve.Search;

public class BehaviourSolveController implements Behavior {

	private FriendCube friendCube;
	
	public BehaviourSolveController(FriendCube friendCube) {
		this.friendCube = friendCube;
	}
	
	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.READ;
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		System.out.println("solving");
		
		String solvedString = simpleSolve(friendCube.getScrambledCube());
		System.out.println("solvedString:" + solvedString);
		String[] solvedCube = new String[0];
		solvedCube = solvedString.split("\\s+");

		friendCube.setSolvedCube(solvedCube);
		
		friendCube.setStateCube(StateCube.SOLVED);
		Delay.msDelay(1000);
	}

	@Override
	public void suppress() { }

	public static String simpleSolve(String scrambledCube) {
		String result = new Search().solution(scrambledCube, 21, 100000000, 0, 0);
		return result;
	}
}
