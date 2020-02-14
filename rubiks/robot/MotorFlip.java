package rubiks.robot;

public class MotorFlip {
	private BaseRegulatedMotor m;
	
	
	MotorFlip(BaseRegulatedMotor m)
	{
		
		this.m=m;
		
	}
	public void flip() {
		m.rotate(360);
		
	}
	public void pin() {
		m.rotate(90);
	}
	public void retract() {
		m.rotate(-90);
		
	}
	

}
