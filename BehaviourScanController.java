import lejos.hardware.Sound;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class BehaviourScanController implements Behavior {
	private FriendCube friendCube;
	private FriendMove friendMove;
	private FriendScan friendScan;
	private MotorColour motorColour;
	private MotorRotate motorRotate;
	private MotorFlip motorFlip;
	private EV3ColorSensor colourSensor;
	private float[][][] scrambledCubeArray;
	private SampleProvider sampleProvider;
	private float[][] cubeValues;
	private String cube;

	public BehaviourScanController(FriendCube friendCube, FriendMove friendMove, FriendScan friendScan,
			MotorColour motorColour, MotorRotate motorRotate, MotorFlip motorFlip, EV3ColorSensor colourSensor) {
		this.friendCube = friendCube;
		this.friendMove = friendMove;
		this.friendScan = friendScan;
		this.motorColour = motorColour;
		this.motorRotate = motorRotate;
		this.motorFlip = motorFlip;
		this.colourSensor = colourSensor;
		this.scrambledCubeArray = FriendScan.getScrambledCubeArray();
		this.sampleProvider = colourSensor.getRedMode();
		this.sideValues = new float[9];
		this.cubeValues = new float[6][9];
		this.cube = "";
	}

	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.UNREAD && !friendMove.getInActionMove() && friendCube.getStateCubeExists() == StateCubeExists.CUBE;
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		Sound.beep();

//		friendScan.setStateMoveColourMotor(StateMoveColourMotor.CENTRE);

		int actionStep = friendScan.getActionStep();
		int actionStep2 = friendScan.getActionStep2();

		if (actionStep < 9 && actionStep >= 0) {
//			if (actionStep2 < 6 && actionStep2 >= 1) {}
			switch (actionStep) {
			case 0:
				motorColour.run(StateMoveColourMotor.CENTRE);
				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 1:
				motorColour.run(StateMoveColourMotor.EDGE);
				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 2:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 3:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 4:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 5:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 6:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 7:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				break;
			case 8:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
//				sampleProvider.fetchSample(sample, 0);
//				scrambledCubeArray[0][actionStep] = sample;
				motorColour.run(StateMoveColourMotor.BACK);
				break;
			}

			actionStep++;
			friendScan.setActionStep(actionStep);
		} else {
			friendScan.resetActionStep();
			Delay.msDelay(200);
		}
	}

	@Override
	public void suppress() {
	}
	
	public String valueConverter(float[][] cubeValues) {
//			**U**: Upper/Top   = White  (0.85)
//			**L**: Left        = Green  (0.22)
//			**F**: Front       = Red    (0.51)
//			**R**: Right       = Blue   (0.13)
//			**B**: Back        = Orange (0.67)
//			**D**: Down/Bottom = Yellow (0.72)
		
		for (float[] sideValues : cubeValues) {
			for (float square : sideValues) {
				if (square >= 0.80f && square <= 1.00f) {
					cube += "U";
				} else if (square >= 0.20f && square <= 0.30f) {
					cube += "L";
				} else if (square >= 0.45f && square <= 0.55f) {
					cube += "F";
				} else if (square >= 0.10f && square <= 0.20f) {
					cube += "R";
				} else if (square >= 0.60f && square <= 0.70f) {
					cube += "B";
				} else if (square >= 0.70f && square <= 0.80f) {
					cube += "D";
				}
			}
		}
		
		return cube;
	}

}