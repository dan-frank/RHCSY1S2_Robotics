package checkpoints.checkpoint_5_4_2;

import lejos.hardware.Button;

public class ThreadTest1 {
	private static HelloWorldThread hwt;
	
	public static void main(String[] args){
		hwt = new HelloWorldThread();
		hwt.start();
		
		while(!Button.ESCAPE.isDown()){
			
		}
		
		System.exit(0);
	}

}
