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
		
		int time = 0;
		boolean closeToZero = false;
		
		
		System.out.print("X Velocity: ");
		xVelocity.add(input.nextDouble());
		
		System.out.print("Y Velocity: ");
		yVelocity.add(input.nextDouble());
		height.add(1000.0);
		distanceTraveled.add(0.0);
		
		time++;
		while (!closeToZero) {	
			
			allCalcs(MOON_GRAVITY, xVelocity, yVelocity, angleOfFall, distanceTraveled, height, time);

			closeToZero = (height.get(time) < 0) ? true : false;

			time++;
		}
		time--;
		
		if (height.get(time) != 0) {
			yVelocity.remove(time);
			xVelocity.remove(time);
			angleOfFall.remove(time);
			height.remove(time);
			distanceTraveled.remove(time);
			
			double lastTime = calcForZeroHeight();
			
		}
		
		System.out.printf("%s%10s%12s%19s%19s%n", "Time", "Height", "Distance", "X Velocity(m/s)",
				"Y Velocity(m/s)");

		for (int x = 0; x < yVelocity.size(); x++) {
			System.out.printf("%4d%10.2f%12.2f%19.2f%19.2f%n", x, height.get(x), distanceTraveled.get(x)
					, xVelocity.get(x), yVelocity.get(x));
		}
		
		input.close();
	}


	private static double calcForZeroHeight() {
		
		return 0;
	}


	/**
	 * @param MOON_GRAVITY
	 * @param xVelocity
	 * @param yVelocity
	 * @param angleOfFall
	 * @param distanceTraveled
	 * @param height
	 * @param time
	 */
	private static void allCalcs(final double MOON_GRAVITY, ArrayList<Double> xVelocity, 
			ArrayList<Double> yVelocity, ArrayList<Double> angleOfFall,
			ArrayList<Double> distanceTraveled, ArrayList<Double> height, int time) {
		
		yVelocity.add(yVelocity.get(time - 1) + MOON_GRAVITY * (time - (time - 1)));
		xVelocity.add(xVelocity.get(time-1));
		angleOfFall.add(calcAngle(xVelocity, yVelocity, time));
		height.add(calcDistance(yVelocity, height, time));
		distanceTraveled.add(calcDistance(xVelocity, distanceTraveled, time));
	}


	/**
	 * @param xVelocity
	 * @param yVelocity
	 * @param time
	 * @return
	 */
	private static double calcAngle(ArrayList<Double> xVelocity, ArrayList<Double> yVelocity, int time) {
		return Math.toDegrees(Math.atan((yVelocity.get(time) / xVelocity.get(time))));
	}
	
	/**
	 * @param velocity
	 * @param distanceTraveled
	 * @param time
	 * @return the distance traveled
	 */
	private static double calcDistance(ArrayList<Double> velocity, ArrayList<Double> distanceTraveled,
			int time) {
		return (.5 * (velocity.get(time) + velocity.get(time - 1)) * (time - (time - 1))) +
				distanceTraveled.get(time - 1);
	}
}