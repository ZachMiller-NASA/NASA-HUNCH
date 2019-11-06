package UML;

public class Velocity {
	double velocityX,velocityY;

	/**
	 * @return the velocityX
	 */
	public double getVelocityX() {
		return velocityX;
	}

	/**
	 * @param velocityX the velocityX to set
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	/**
	 * @return the velocityY
	 */
	public double getVelocityY() {
		return velocityY;
	}

	/**
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public Velocity() {
		
	}
	public Velocity(double velocityX, double velocityY) {
		
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}
	public double calcVector() {
		
		return 0;
	}
	
	
}

