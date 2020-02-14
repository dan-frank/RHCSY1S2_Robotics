import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;

public class TestWaitStop {
  final static int TOTAL = 1440;
	public static void main(String[] args) {
		BaseRegulatedMotor mL = new EV3LargeRegulatedMotor(MotorPort.A);
		BaseRegulatedMotor mR = new EV3LargeRegulatedMotor(MotorPort.B);
		mL.synchronizeWith(new BaseRegulatedMotor[] {mR});
		
		Thread watcher = new WatcherThread(mL);
		watcher.setDaemon(true);watcher.start();
		mL.startSynchronization();
		mL.rotate(TOTAL);
		mR.rotate(TOTAL);
		mL.endSynchronization();
		LCD.drawString("Finished "+Motor.A.getTachoCount(), 2, 4);
		Button.ENTER.waitForPressAndRelease();

	}

}
