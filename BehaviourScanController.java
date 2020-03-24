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
	private SampleProvider sampleProvider;
	private String[][] cubeValues;
	private float[] squareValue;
	private float square;
	private String cube;
	private int scanNum;
	
	public BehaviourScanController(FriendCube friendCube, FriendMove friendMove, FriendScan friendScan,
			MotorColour motorColour, MotorRotate motorRotate, MotorFlip motorFlip, EV3ColorSensor colourSensor) {
		this.friendCube = friendCube;
		this.friendMove = friendMove;
		this.friendScan = friendScan;
		this.motorColour = motorColour;
		this.motorRotate = motorRotate;
		this.motorFlip = motorFlip;
		this.sampleProvider = colourSensor.getRedMode();
		colourSensor.setFloodlight(true);
		this.cubeValues = new String[6][9];
		this.scanNum = 500;
		this.squareValue = new float[scanNum];
		this.square = 0;
		this.cube = "";
		friendScan.getMotorColour();
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
		}

		if (actionStep < 9 && actionStep >= 0) {
			switch (actionStep) {
			case 0:
				motorColour.run(StateMoveColourMotor.CENTRE);
				square = getAverageColour();
				cubeValues[actionStep2][4] = valueConverter(square);
				break;
			case 1:
				motorColour.run(StateMoveColourMotor.EDGE);
				square = getAverageColour();
				cubeValues[actionStep2][5] = valueConverter(square);
				break;
			case 2:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				square = getAverageColour();
				cubeValues[actionStep2][2] = valueConverter(square);
				break;
			case 3:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
				square = getAverageColour();
				cubeValues[actionStep2][1] = valueConverter(square);
				break;
			case 4:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				square = getAverageColour();
				cubeValues[actionStep2][0] = valueConverter(square);
				break;
			case 5:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
				square = getAverageColour();
				cubeValues[actionStep2][3] = valueConverter(square);
				break;
			case 6:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				square = getAverageColour();
				cubeValues[actionStep2][6] = valueConverter(square);
				break;
			case 7:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
				square = getAverageColour();
				cubeValues[actionStep2][7] = valueConverter(square);
				break;
			case 8:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				square = getAverageColour();
				cubeValues[actionStep2][8] = valueConverter(square);
				motorColour.run(StateMoveColourMotor.RESET);
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
				int i = 0;
				int U = 0;
				int L = 0;
				int F = 0;
				int R = 0;
				int B = 0;
				int D = 0;

				cube = "";
				int[] order = new int[] { 0, 1, 5, 2, 3, 4 };
				for (int j = 0; j < cubeValues.length; j++) {
					for (int k = 0; k < cubeValues[j].length; k++) {
						String cell = cubeValues[order[j]][k];
						
						cube += cell;
						if (cell == "U") {
							U++;
						} else if (cell == "L") {
							L++;
						} else if (cell == "F") {
							F++;
						} else if (cell == "R") {
							R++;
						} else if (cell == "B") {
							B++;
						} else if (cell == "D") {
							D++;
						}
						
						i++;
					}
				}
//				System.out.println();
				System.out.println(cube + " , " + i);

				if (U == 9 && L == 9 && F == 9 && R == 9 && B == 9 && D == 9) {
					friendCube.setScrambledCube(cube);
					friendCube.setStateCube(StateCube.READ);
				} else {
					friendScan.setActionStep(0);
					friendScan.setActionStep2(0);
					cubeValues = new String[6][9];
					squareValue = new float[scanNum];
				}
			}
		}
	}

	@Override
	public void suppress() {
	}

	public String valueConverter(float square) {
		cube = "";

		while (cube == "") {
//			System.out.println(square);
			if (square >= 0.69f && square < 1.0f) {
				cube = "U";
			} else if (square >= 0.15f && square < 0.27f) {
				cube = "L";
			} else if (square >= 0.27f && square < 0.39f) {
				cube = "F";
			} else if (square >= 0.099998f && square < 0.155f) {
				cube = "R";
			} else if (square >= 0.00f && square < 0.099998f) {
				cube = "B";
			} else if (square >= 0.41f && square < 0.69f) {
				cube = "D";
			} else {
				square = getAverageColour();
			}
		}
//		System.out.println(cube);

		return cube;
	}

	public float getAverageColour() {

		for (int i = 0; i < scanNum; i++) {
			sampleProvider.fetchSample(squareValue, i);
		}
		float total = 0;
		for (float value : squareValue) {
			total += value;
		}
		return total / scanNum;
	}

}