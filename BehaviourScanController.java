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
	private String cube;

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
		this.squareValue = new float[5];
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
		}

		if (actionStep < 9 && actionStep >= 0) {
			switch (actionStep) {
			case 0:
				motorColour.run(StateMoveColourMotor.CENTRE);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][4] = valueConverter(squareValue);
				break;
			case 1:
				motorColour.run(StateMoveColourMotor.EDGE);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][7] = valueConverter(squareValue);
				break;
			case 2:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][8] = valueConverter(squareValue);
				break;
			case 3:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][5] = valueConverter(squareValue);
				break;
			case 4:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][2] = valueConverter(squareValue);
				break;
			case 5:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][1] = valueConverter(squareValue);
				break;
			case 6:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][0] = valueConverter(squareValue);
				break;
			case 7:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.EDGE);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][3] = valueConverter(squareValue);
				break;
			case 8:
				motorRotate.run(StateRotate.HALF);
				motorColour.run(StateMoveColourMotor.CORNER);
				sampleProvider.fetchSample(squareValue, 0);
				sampleProvider.fetchSample(squareValue, 1);
				sampleProvider.fetchSample(squareValue, 2);
				sampleProvider.fetchSample(squareValue, 3);
				sampleProvider.fetchSample(squareValue, 4);
				cubeValues[actionStep2][6] = valueConverter(squareValue);
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
				int i = 0;
				int U = 0;
				int L = 0;
				int F = 0;
				int R = 0;
				int B = 0;
				int D = 0;
				
				for (String[] side : cubeValues) {
					for (String square : side) {
						cube += square;
						if (square == "U") {U++;}
						else if (square == "L") {L++;}
						else if (square == "F") {F++;}
						else if (square == "R") {R++;}
						else if (square == "B") {B++;}
						else if (square == "D") {D++;}
						i++;
					}
				}
				
				System.out.println(cube + " , " + i);
				
				if (U > 10 || L > 10 || F > 10 || R  > 10 || B > 10 || D > 10) {
					actionStep = 0;
					actionStep2 = 0;
				}
				else {
					friendCube.setScrambledCube(cube);
					friendCube.setStateCube(StateCube.READ);
				}
			}
		}
	}

	@Override
	public void suppress() {
	}

	public String valueConverter(float[] squareValue) {
//			**U**: Upper/Top   = White  (0.75)
//			**L**: Left        = Green  (0.21)
//			**F**: Front       = Red    (0.55)
//			**R**: Right       = Blue   (0.10)
//			**B**: Back        = Black 	(0.065)
//			**D**: Down/Bottom = Yellow (0.64)
		
		float square = (squareValue[0] + squareValue[1] + squareValue[2] + squareValue[3] + squareValue[4])/5;
		System.out.println(square);
				
		if (square >= 0.70f && square < 1.0f) {
			cube = "U";
		} else if (square >= 0.15f && square < 0.25f) {
			cube = "L";
		} else if (square >= 0.50f && square < 0.60f) {
			cube = "F";
		} else if (square >= 0.08f && square < 0.15f) {
			cube = "R";
		} else if (square >= 0.00f && square < 0.08f) {
			cube = "B";
		} else if (square >= 0.60f && square < 0.70f) {
			cube = "D";
		}
		System.out.println(cube);

		return cube;
	}

}