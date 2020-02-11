package checkpoints.dans_thread;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class Driver {
	private static HelloWorldThread hwt;
	private static MoveThread mt;
	private static TunePlayerThread tpt;
	
	public static void main(String[] args){
		hwt = new HelloWorldThread();
		mt = new MoveThread();
		tpt = new TunePlayerThread();
		
		hwt.start();
		mt.start();
		tpt.start();
		
		while(!Button.ENTER.isDown()){}
		
		hwt.interrupt();
		
		while(!Button.ENTER.isDown()){}
		
		mt.interrupt();
		tpt.interrupt();
		
		Delay.msDelay(5000);
		
		System.exit(0);
	}

}
