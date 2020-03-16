import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.subsumption.Behavior;

public class BehaviourRunningController implements Behavior {

	private FriendCube friendCube;
	private EV3UltrasonicSensor sensorUltrasonic;
	private SensorMode distance;
	float[] sample = new float[1];
	
	public BehaviourRunningController(FriendCube friendCube, EV3UltrasonicSensor sensorUltrasonic) {
		this.friendCube = friendCube;
		this.sensorUltrasonic = sensorUltrasonic;
		this.distance = (SensorMode) this.sensorUltrasonic.getDistanceMode();
	}
	
	@Override
	public boolean takeControl() {
		distance.fetchSample(sample, 0);
		return (sample[0] < 0.15f && friendCube.getStateCubeExists() == StateCubeExists.NOCUBE) && sample[0] > 0.5f;
	}

	@Override
	public void action() {
		if (sample[0] < 0.15f) {
			friendCube.setStateCubeExists(StateCubeExists.CUBE);
		} else {
			friendCube.setStateCubeExists(StateCubeExists.NOCUBE);
		}
	}

	@Override
	public void suppress() { }

}
