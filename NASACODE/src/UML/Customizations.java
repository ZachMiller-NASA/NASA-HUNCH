package UML;

public class Customizations {
	double spinSpeed,dropHeight,speedAtRelease,mass,releaseAngle;
	Velocity initialVelocity;
	
	/**
	 * @return the releaseAngle
	 */
	public double getReleaseAngle() {
		return releaseAngle;
	}
	/**
	 * @param releaseAngle the releaseAngle to set
	 */
	public void setReleaseAngle(double releaseAngle) {
		this.releaseAngle = releaseAngle;
	}
	
	
	public Customizations() {
		
	}
	
	public Customizations(double spinSpeed, double dropHeight, double speedAtRelease, double mass,
			Velocity initialVelocity) {
		super();
		this.spinSpeed = spinSpeed;
		this.dropHeight = dropHeight;
		this.speedAtRelease = speedAtRelease;
		this.mass = mass;
		this.initialVelocity = initialVelocity;
	}
	
	
	/**
	 * @return the spinSpeed
	 */
	public double getSpinSpeed() {
		return spinSpeed;
	}
	/**
	 * @param spinSpeed the spinSpeed to set
	 */
	public void setSpinSpeed(double spinSpeed) {
		this.spinSpeed = spinSpeed;
	}
	/**
	 * @return the dropHeight
	 */
	
	
	public double getDropHeight() {
		return dropHeight;
	}
	/**
	 * @param dropHeight the dropHeight to set
	 */
	public void setDropHeight(double dropHeight) {
		this.dropHeight = dropHeight;
	}
	/**
	 * @return the speedAtRelease
	 */
	
	
	public double getSpeedAtRelease() {
		return speedAtRelease;
	}
	/**
	 * @param speedAtRelease the speedAtRelease to set
	 */
	public void setSpeedAtRelease(double speedAtRelease) {
		this.speedAtRelease = speedAtRelease;
	}
	/**
	 * @return the mass
	 */
	
	
	public double getMass() {
		return mass;
	}
	/**
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}
	/**
	 * @return the initialVelocity
	 */
	
	
	public Velocity getInitialVelocity() {
		return initialVelocity;
	}
	/**
	 * @param initialVelocity the initialVelocity to set
	 */
	public void setInitialVelocity(Velocity initialVelocity) {
		this.initialVelocity = initialVelocity;
	}
	
	
	
	
	
	
	
	
}
