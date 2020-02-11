package checkpoints.checkpoint_5_4_2;

import lejos.hardware.Button;

public class ThreadTest1 {
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
		
		while(!Button.ESCAPE.isDown()){	}
		
		System.exit(0);
	}

}
