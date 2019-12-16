package mtCleverest;

import java.util.ArrayList;

public class ProjectileMotion {
	
	public ProjectileMotion() {
		
	}
	
	
	/**
	 * @param MOON_GRAVITY
	 * @param xVelocity
	 * @param yVelocity
	 * @param angleOfFall
	 * @param distanceTraveled
	 * @param height
	 * @param index
	 */
	protected void allCalcs(final double MOON_GRAVITY, ArrayList<Double> xVelocity, 
			ArrayList<Double> yVelocity, ArrayList<Double> angleOfFall,
			ArrayList<Double> distanceTraveled, ArrayList<Double> height, 
			ArrayList<Double> time, int index) {

		yVelocity.add(yVelocity.get(index - 1) + MOON_GRAVITY * (time.get(index) - 
				time.get(index - 1)));
		xVelocity.add(xVelocity.get(index - 1));
		angleOfFall.add(calcAngle(xVelocity, yVelocity, index));
		height.add(calcDistance(yVelocity, height, time, index));
		distanceTraveled.add(calcDistance(xVelocity, distanceTraveled, time, index));
	}

	/**
	 * @param MOON_GRAVITY
	 * @param xVelocity
	 * @param yVelocity
	 * @param angleOfFall
	 * @param distanceTraveled
	 * @param height
	 * @param time
	 * @param index
	 * @param timeIndex
	 */
	protected void allCalcs(final double MOON_GRAVITY, ArrayList<Double> xVelocity, 
			ArrayList<Double> yVelocity, ArrayList<Double> angleOfFall,
			ArrayList<Double> distanceTraveled, ArrayList<Double> height, ArrayList<Double> time,
			int index, int timeIndex) {
		
		yVelocity.add(yVelocity.get(index - 1) + MOON_GRAVITY * (time.get(timeIndex) - 
				time.get(index)));
		xVelocity.add(xVelocity.get(index - 1));
		angleOfFall.add(calcAngle(xVelocity, yVelocity, index));
		height.add(calcDistance(yVelocity, height, time, index, timeIndex));
		distanceTraveled.add(calcDistance(xVelocity, distanceTraveled, time, index, timeIndex));
	}
	
	/**
	 * @param xVelocity
	 * @param yVelocity
	 * @param index
	 * @return THE ANGLE OF FALL
	 */
	protected double calcAngle(ArrayList<Double> xVelocity, ArrayList<Double> yVelocity, 
			int index) {
		return Math.toDegrees(Math.atan((yVelocity.get(index) / xVelocity.get(index))));
	}
	
	/**
	 * @param velocity
	 * @param distanceTraveled
	 * @param index
	 * @return THE DISTANCE TRAVELED
	 */
	protected double calcDistance(ArrayList<Double> velocity, ArrayList<Double> distanceTraveled,
			ArrayList<Double> time, int index) {
		return (.5 * (velocity.get(index) + velocity.get(index - 1)) * (time.get(index) - 
				time.get(index - 1))) + distanceTraveled.get(index - 1);
	}
	
	/**
	 * @param velocity
	 * @param distanceTraveled
	 * @param time
	 * @param index
	 * @param timeIndex
	 * @return THE DISTANCE FOR WHEN THE POD HITS THE GROUND
	 */
	protected Double calcDistance(ArrayList<Double> velocity, ArrayList<Double> distanceTraveled,
			ArrayList<Double> time, int index, int timeIndex) {
		return (.5 * (velocity.get(index) + velocity.get(index - 1)) * (time.get(timeIndex) - 
				time.get(index))) + distanceTraveled.get(index - 1);
	}

	/**
	 * @param yVelocity
	 * @param index
	 * @param MOON_GRAVITY
	 * @return TIME FOR ZERO HEIGHT
	 */
	protected double calcTimeAtZeroHeight(ArrayList<Double> yVelocity, ArrayList<Double> time, 
			int index, final double MOON_GRAVITY) {
		return (((roundedVelocity(yVelocity, index) - roundedVelocity(yVelocity, index - 1)) /
				MOON_GRAVITY) + (time.get(index)));
	}
	
	/**
	 * @param yVelocity
	 * @param index
	 * @return velocity rounded to nearest hundredth place
	 */
	protected double roundedVelocity(ArrayList<Double> yVelocity, int index) {
		return Math.round(yVelocity.get(index) * 100) / 100.0;
	}
}