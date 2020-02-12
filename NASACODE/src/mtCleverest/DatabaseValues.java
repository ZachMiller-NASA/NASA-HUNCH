package mtCleverest;

// THIS CLASS ALLOWS THE DATABASE TABLE TO READ THE VALUES FROM THE DATABASE
public class DatabaseValues {
	String height, yVel, xVel, maxPotEnergy, time, distance, impactAngle, maxKinEnergy;
	
	/**
	 * @param height
	 * @param yVel
	 * @param xVel
	 * @param maxPotEnergy
	 * @param time
	 * @param distance
	 * @param impactAngle
	 * @param maxKinEnergy
	 */
	public DatabaseValues(String height,String yVel,String xVel,String maxPotEnergy,String time,String distance, 
			String impactAngle,String maxKinEnergy) {
		this.height = height;
		this.yVel = yVel;
		this.xVel = xVel;
		this.maxPotEnergy = maxPotEnergy;
		this.time = time;
		this.distance = distance;
		this.impactAngle = impactAngle;
		this.maxKinEnergy = maxKinEnergy;
	}

	/**
	 * 
	 * @return height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * 
	 * @return y velocity
	 */
	public String getYVel() {
		return yVel;
	}

	/**
	 * 
	 * @return x velocity
	 */
	public String getXVel() {
		return xVel;
	}

	/**
	 * 
	 * @return max potential energy
	 */
	public String getMaxPotEnergy() {
		return maxPotEnergy;
	}

	/**
	 * 
	 * @return the amount of time the test took 
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 *  
	 * @return distance traveled
	 */
	public String getDistance() {
		return distance;
	}
	
	/**
	 * 
	 * @return the impact angle
	 */
	public String getImpactAngle() {
		return impactAngle;
	}
	
	/**
	 * 
	 * @return max kinetic energy
	 */
	public String getMaxKinEnergy() {
		return maxKinEnergy;
	}
}
