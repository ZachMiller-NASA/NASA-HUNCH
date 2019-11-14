package UML;

public class Customizations {
	double spinSpeed;
	double dropHeight;
	Velocity initialVelocity;
	public Customizations() {
		
	}
	
	public Customizations(double spinSpeed, double dropHeight, Velocity initialVelocity) {
		this.spinSpeed = spinSpeed;
		this.dropHeight = dropHeight;
		this.initialVelocity = initialVelocity;
	}
	
	public double getSpinSpeed() {
		return spinSpeed;
	}
	public void setSpinSpeed(double spinSpeed) {
		this.spinSpeed = spinSpeed;
	}
	
	public double getDropHeight() {
		return dropHeight;
	}
	public void setDropHeight(double dropHeight) {
		this.dropHeight = dropHeight;
	}
	
	public Velocity getInitialVelocity() {
		return initialVelocity;
	}
	public void setInitialVelocity(Velocity initialVelocity) {
		this.initialVelocity = initialVelocity;
	}
}
