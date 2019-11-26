package UML;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		final double MOON_GRAVITY = -1.62;

		ProjectileMotion motion = new ProjectileMotion();
		Scanner input = new Scanner(System.in);
		ArrayList<Double> xVelocity = new ArrayList<Double>();
		ArrayList<Double> yVelocity = new ArrayList<Double>();
		ArrayList<Double> angleOfFall = new ArrayList<Double>();
		ArrayList<Double> distanceTraveled = new ArrayList<Double>();
		ArrayList<Double> height = new ArrayList<Double>();
		ArrayList<Double> time = new ArrayList<Double>();

		int index = 0;
		int timeIndex = 0;
		boolean closeToZero = false;

		System.out.print("X Velocity: ");
		xVelocity.add(input.nextDouble());

		System.out.print("Y Velocity: ");
		yVelocity.add(-input.nextDouble());

		height.add(1000.0);
		distanceTraveled.add(0.0);
		angleOfFall.add(motion.calcAngle(xVelocity, yVelocity, index));
		time.add((double) index);

		index++;
		while (!closeToZero) {

			time.add((double) index);

			motion.allCalcs(MOON_GRAVITY, xVelocity, yVelocity, angleOfFall, distanceTraveled, height, time, index);

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

			time.add(motion.calcTimeAtZeroHeight(yVelocity, time, index, MOON_GRAVITY));

			timeIndex = index + 1;

			motion.allCalcs(MOON_GRAVITY, xVelocity, yVelocity, angleOfFall, distanceTraveled, height, time, index,
					timeIndex);
		}

		System.out.printf("%5s%10s%12s%19s%19s%17s%n", "Time", "Height", "Distance", "X Velocity(m/s)",
				"Y Velocity(m/s)", "Angle of Fall");

		// Distance of fall now at 0
		for (int x = 0; x < time.size() - 1; x++) {
			System.out.printf("%5.2f%10.2f%12.2f%19.2f%19.2f%17.2f%n", time.get(x), height.get(x),
					distanceTraveled.get(x), xVelocity.get(x), yVelocity.get(x), angleOfFall.get(x));
		}

		// how far will it roll
		System.out.printf("%5.2f%10.2f%12.2f%19.2f%19.2f%17.2f%n", time.get(time.size() - 1), 0.0,
				distanceTraveled.get(time.size() - 1), xVelocity.get(time.size() - 1), 0.0, 0.0);

		input.close();
	}

}
