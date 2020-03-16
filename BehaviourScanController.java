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
		this.sampleProvider = colourSensor.getRedMode();
		this.cubeValues = new float[6][9];
		this.cube = "";
	}

	@Override
	public boolean takeControl() {
		return friendCube.getStateCube() == StateCube.UNREAD && !friendMove.getInActionMove()
				&& friendCube.getStateCubeExists() == StateCubeExists.CUBE;
	}

	@Override
	public void action() {
		Delay.msDelay(1000);
		Sound.beep();

//		friendScan.setStateMoveColourMotor(StateMoveColourMotor.CENTRE);

		int actionStep = friendScan.getActionStep();
		int actionStep2 = friendScan.getActionStep2();

		if ((actionStep2 < 6 && actionStep2 >= 0) && actionStep == 0) {
			switch (actionStep2) {
			case 0:
				break;
			case 1:
				motorFlip.run(StateFlip.FLIP);
				motorRotate.run(StateRotate.CLOCKWISE);
				break;
			case 2:
				motorRotate.run(StateRotate.ANTICLOCKWISE);
				motorFlip.run(StateFlip.FLIP);
				motorRotate.run(StateRotate.UTURN);
				break;
			case 3:
				motorRotate.run(StateRotate.UTURN);
				motorFlip.run(StateFlip.FLIP);
				motorRotate.run(StateRotate.ANTICLOCKWISE);
				break;

			case 4:
				motorRotate.run(StateRotate.UTURN);
				motorFlip.run(StateFlip.FLIP);
				motorRotate.run(StateRotate.UTURN);
				break;
			case 5:
				motorFlip.run(StateFlip.FLIP);
				motorFlip.run(StateFlip.FLIP);
				break;

			}
			motorFlip.run(StateFlip.PIN);
			motorFlip.run(StateFlip.RETRACT);
		}

		if (actionStep < 9 && actionStep >= 0) {
			switch (actionStep) {
			case 0:
				motorColour.run(StateMoveColourMotor.CENTRE4);
				sampleProvider.fetchSample(cubeValues[actionStep2], 4);
				break;
			case 1:
				motorColour.run(StateMoveColourMotor.EDGE5);
				sampleProvider.fetchSample(cubeValues[actionStep2], 7);
				break;
			case 2:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER2);
				sampleProvider.fetchSample(cubeValues[actionStep2], 8);
				break;
			case 3:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE1);
				sampleProvider.fetchSample(cubeValues[actionStep2], 5);
				break;
			case 4:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER0);
				sampleProvider.fetchSample(cubeValues[actionStep2], 2);
				break;
			case 5:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE3);
				sampleProvider.fetchSample(cubeValues[actionStep2], 1);
				break;
			case 6:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER6);
				sampleProvider.fetchSample(cubeValues[actionStep2], 0);
				break;
			case 7:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE7);
				sampleProvider.fetchSample(cubeValues[actionStep2], 3);
				break;
			case 8:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER8);
				sampleProvider.fetchSample(cubeValues[actionStep2], 6);
				motorColour.run(StateMoveColourMotor.BACK);
				motorRotate.run(StateRotate.HALF);
				break;
			}

			actionStep++;
			friendScan.setActionStep(actionStep);
		} else {
			friendScan.resetActionStep();
			Delay.msDelay(200);
			actionStep2++;
			friendScan.setActionStep2(actionStep2);
			if (actionStep2 == 6) {
				motorRotate.run(StateRotate.CLOCKWISE);
				motorFlip.run(StateFlip.FLIP);
				motorRotate.run(StateRotate.ANTICLOCKWISE);
				friendCube.setStateCube(StateCube.READ);
			}
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