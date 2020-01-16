package mtCleverest;

import java.lang.Math;
import java.util.ArrayList;

public class Data {
	public static ArrayList<Double> xVelocity = new ArrayList<Double>();
	public static ArrayList<Double> yVelocity = new ArrayList<Double>();
	public static ArrayList<Double> angleOfFall = new ArrayList<Double>();
	public static ArrayList<Double> distanceTraveled = new ArrayList<Double>();
	public static ArrayList<Double> height = new ArrayList<Double>();
	public static ArrayList<Double> currentTime = new ArrayList<Double>();
	public static ArrayList <Double> kineticEnergy = new ArrayList<Double>();
	public static ArrayList <Double> potentialEnergy = new ArrayList<Double>();
	
	static ArrayList<Double> retrieve(Object request) {
		if (request == "Altitude")
			return height;
		else if (request == "Time")
			return currentTime;
		else if (request == "Distance")
			return distanceTraveled;
		else if (request == "Temperature")
			return currentTime; //CHANGE THIS WHEN WE HAVE TEMP
		else if (request == "Force")
			return currentTime; //CHANGE THIS WHEN WE HAVE FORCE
		else if (request == "Speed") {
			ArrayList<Double> speed = new ArrayList<Double>();
			for (short count = 0; count < xVelocity.size(); count++) {
				speed.add(Math.sqrt(Math.pow(xVelocity.get(count), 2)
						+ Math.pow(yVelocity.get(count), 2)));
			}
			return speed;
		}
		else
			return angleOfFall;
	}
}
