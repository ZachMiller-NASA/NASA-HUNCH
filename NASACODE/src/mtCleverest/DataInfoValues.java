package mtCleverest;

// THIS CLASS ALLOWS THE DATAINFO TABLE TO READ THE VALUES GENERATED
public class DataInfoValues {
	double time, height, distance, xVel, yVel, angleOfFall, kinEnergy, potEnergy;
	
	/**
	 * 
	 * @param time
	 * @param height
	 * @param distance
	 * @param xVel
	 * @param yVel
	 * @param angleOfFall
	 * @param kinEnergy
	 * @param potEnergy
	 */
	public DataInfoValues(double time, double height, double distance, double xVel, double yVel, double angleOfFall,
			double kinEnergy, double potEnergy) {
		this.time = time;
		this.height = height;
		this.distance = distance;
		this.xVel = xVel;
		this.yVel = yVel;
		this.angleOfFall = angleOfFall;
		this.kinEnergy = kinEnergy;
		this.potEnergy = potEnergy;
	}
	
	/**
	 * 
	 * @return time rounded to the second decimal
	 */
	public double getTime() {
		return Math.round(time*100)/100.0;
	}

	/**
	 * 
	 * @return height rounded to the second decimal
	 */
	public double getHeight() {
		return Math.round(height*100)/100.0;
	}

	/**
	 * 
	 * @return distance rounded to the second decimal
	 */
	public double getDistance() {
		return Math.round(distance*100)/100.0;
	}
	
	/**
	 * 
	 * @return x velocity rounded to the second decimal
	 */
	public double getXVel() {
		return Math.round(xVel*100)/100.0;
	}
	
	/**
	 * 
	 * @return y velocity rounded to the second decimal
	 */
	public double getYVel() {
		return Math.round(yVel*100)/100.0;
	}
	
	/**
	 * 
	 * @return angle of fall rounded to the second decimal
	 */
	public double getAngleOfFall() {
		return Math.round(angleOfFall*100)/100.0;
	}
	
	/**
	 * 
	 * @return kinetic energy rounded to the second decimal
	 */
	public double getKinEnergy() {
		return Math.round(kinEnergy*100)/100.0;
	}
	
	/**
	 * 
	 * @return potential rounded to the second decimal
	 */
	public double getPotEnergy() {
		return Math.round(potEnergy*100)/100.0;
	}
}
