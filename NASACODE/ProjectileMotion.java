package ProjectileMotion;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectileMotion {

	public static void main(String[] args) {
		
		final double MOON_GRAVITY = -1.62;
		
		Scanner input = new Scanner(System.in);
		ArrayList<Double> xVelocity = new ArrayList<Double>();
		ArrayList<Double> yVelocity = new ArrayList<Double>();
		ArrayList<Double> angleOfFall = new ArrayList<Double>();
		ArrayList<Double> distanceTraveled = new ArrayList<Double>();
		ArrayList<Double> height = new ArrayList<Double>();
		ArrayList<Double> time = new ArrayList<Double>();
		
		int index = 0;
		boolean closeToZero = false;
		
		
		System.out.print("X Velocity: ");
		xVelocity.add(input.nextDouble());
		
		System.out.print("Y Velocity: ");
		yVelocity.add(-input.nextDouble());
		
		height.add(1000.0);
		distanceTraveled.add(0.0);
		angleOfFall.add(calcAngle(xVelocity, yVelocity, index));
		time.add((double) index);
		
		index++;
		while (!closeToZero) {	
			
			time.add((double) index);
			allCalcs(MOON_GRAVITY, xVelocity, yVelocity, angleOfFall, distanceTraveled, height, time, 
					index);
			
			closeToZero = (height.get(index) < 0) ? true : false;

			index++;
		}
		index--;
		
		if (height.get(index) != 0) {
			yVelocity.remove(index);
			xVelocity.remove(index);
			angleOfFall.remove(index);
			height.remove(index);
			distanceTraveled.remove(index);
			time.remove(index);
			
			index--;
			
			time.add(calcForZeroHeight(yVelocity, time, index, MOON_GRAVITY));
			allCalcs(MOON_GRAVITY, xVelocity, yVelocity, angleOfFall, distanceTraveled, height, time, 
					index);
		}
		
		System.out.printf("%5s%10s%12s%19s%19s%n", "Time", "Height", "Distance", "X Velocity(m/s)",
				"Y Velocity(m/s)");

		for (int x = 0; x < time.size(); x++) {
			System.out.printf("%5.2f%10.2f%12.2f%19.2f%19.2f%n", time.get(x), height.get(x), 
					distanceTraveled.get(x), xVelocity.get(x), yVelocity.get(x));
		}
		
		input.close();
	}

	/**
	 * @param yVelocity
	 * @param index
	 * @param MOON_GRAVITY
	 * @return
	 */
	private static double calcForZeroHeight(ArrayList<Double> yVelocity, ArrayList<Double> time, 
			int index, final double MOON_GRAVITY) {
		return (((roundedVelocity(yVelocity, index) - roundedVelocity(yVelocity, index-1)) / 
				MOON_GRAVITY) + (time.get(index)));
	}
	
	/**
	 * @param yVelocity
	 * @param index
	 * @return
	 */
	private static double roundedVelocity(ArrayList<Double> yVelocity, int index) {
		return (Math.round(yVelocity.get(index)*100)/100);
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
	private static void allCalcs(final double MOON_GRAVITY, ArrayList<Double> xVelocity, 
			ArrayList<Double> yVelocity, ArrayList<Double> angleOfFall,
			ArrayList<Double> distanceTraveled, ArrayList<Double> height, 
			ArrayList<Double> time, int index) {
		
		yVelocity.add(yVelocity.get(index - 1) + MOON_GRAVITY * (time.get(index) - 
				time.get(index - 1)));
		xVelocity.add(xVelocity.get(index-1));
		angleOfFall.add(calcAngle(xVelocity, yVelocity, index));
		height.add(calcDistance(yVelocity, height, time, index));
		distanceTraveled.add(calcDistance(xVelocity, distanceTraveled, time, index));
	}


	/**
	 * @param xVelocity
	 * @param yVelocity
	 * @param index
	 * @return the angle of fall
	 */
	private static double calcAngle(ArrayList<Double> xVelocity, ArrayList<Double> yVelocity, 
			int index) {
		return Math.toDegrees(Math.atan((yVelocity.get(index) / xVelocity.get(index))));
	}
	
	/**
	 * @param velocity
	 * @param distanceTraveled
	 * @param index
	 * @return the distance traveled
	 */
	private static double calcDistance(ArrayList<Double> velocity, ArrayList<Double> distanceTraveled,
			ArrayList<Double> time, int index) {
		return (.5 * (velocity.get(index) + velocity.get(index - 1)) * (time.get(index) - 
				time.get(index - 1))) + distanceTraveled.get(index - 1);
	}
}
