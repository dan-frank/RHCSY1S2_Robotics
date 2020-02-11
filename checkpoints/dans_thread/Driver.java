package checkpoints.dans_thread;

import lejos.hardware.Button;
import lejos.utility.Delay;

public class Driver {
	private static HelloWorldThread hwt;
	private static MoveThread mt;
//	private static BeepThread bt;
	private static TunePlayerThread tpt;
	
	public static void main(String[] args){
		hwt = new HelloWorldThread();
		mt = new MoveThread();
//		bt = new BeepThread();
		tpt = new TunePlayerThread();
		
		hwt.start();
		mt.start();
//		bt.start();
		tpt.start();
		
		while(!Button.ENTER.isDown()){}
		
		Delay.msDelay(5000);
		
		System.exit(0);
	}

}
