import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class WatcherThread extends Thread{

	
		private BaseRegulatedMotor m;
		public WatcherThread (BaseRegulatedMotor _m) {m=_m;}
        public void run() {
        	EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S1); 
        	SampleProvider sp = us.getDistanceMode();
        	float[]samples = new float[1];
        	while (true) {
        		
        		sp.fetchSample(samples, 0);
        		m.setSpeed(samples[0]>0.2?1:720);
        		Thread.yield();
        	}
        }
	}


