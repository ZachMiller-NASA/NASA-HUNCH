package mtCleverest;

import java.util.ArrayList;

public class ProjectileMotion {
	
	public ProjectileMotion() {
		
	}
	
	
	/**
	 * @param MOON_GRAVITY
	 * @param MASS 
	 * @param xVelocity
	 * @param yVelocity
	 * @param angleOfFall
	 * @param distanceTraveled
	 * @param height
	 * @param potentialEnergy 
	 * @param kineticEnergy 
	 * @param speed 
	 * @param index
	 */
	protected void allCalcs(final double MOON_GRAVITY, final double MASS, ArrayList<Double> xVelocity, 
			ArrayList<Double> yVelocity, ArrayList<Double> angleOfFall,
			ArrayList<Double> distanceTraveled, ArrayList<Double> height, 
			ArrayList<Double> time, ArrayList<Double> speed, ArrayList<Double> kineticEnergy,
			ArrayList<Double> potentialEnergy, int index) {

		yVelocity.add(yVelocity.get(index - 1) + MOON_GRAVITY * (time.get(index) - 
				time.get(index - 1)));
		xVelocity.add(xVelocity.get(index - 1));
		angleOfFall.add(calcAngle(xVelocity, yVelocity, index));
		height.add(calcDistance(yVelocity, height, time, index));
		distanceTraveled.add(calcDistance(xVelocity, distanceTraveled, time, index));
		speed.add(calcSpeed(xVelocity, yVelocity, index));
		kineticEnergy.add(calcKineticEnergy(MASS, speed, index));
		potentialEnergy.add(calcPotentialEnergy(MOON_GRAVITY, MASS, height, index));
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
		
		xVelocity.add(xVelocity.get(index-1));
		angleOfFall.add(Math.toDegrees(Math.atan((yVelocity.get(timeIndex) / xVelocity.get(timeIndex)))));
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
		return (.5 * (velocity.get(timeIndex) + velocity.get(index)) * (time.get(timeIndex) - 
				time.get(index))) + distanceTraveled.get(index);
	}
	
	/**
	 * @param xVelocity
	 * @param yVelocity
	 * @param index
	 * @return the vector of the x and y velocities as speed
	 */
	protected double calcSpeed(ArrayList<Double> xVelocity, ArrayList<Double> yVelocity, 
			int index) {
		return Math.sqrt(Math.pow(xVelocity.get(index), 2) + Math.pow(yVelocity.get(index), 2));
	}
	
	/**
	 * @param MASS
	 * @param speed
	 * @param index
	 * @return kinetic energy in kilojoules
	 */
	protected double calcKineticEnergy(final double MASS, ArrayList<Double> speed, int index) {
		return .5*MASS*Math.pow(speed.get(index), 2);
	}
	
	/**
	 * @param MOON_GRAVITY
	 * @param MASS
	 * @param height
	 * @param index
	 * @return potential energy in kilojoules
	 */
	protected double calcPotentialEnergy(final double MOON_GRAVITY, final double MASS,
			ArrayList<Double> height, int index) {
		return (MASS * -MOON_GRAVITY * height.get(index))/1000.0;
	}
}
