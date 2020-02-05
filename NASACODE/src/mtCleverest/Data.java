package mtCleverest;

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
	public static ArrayList<Double> speed = new ArrayList<Double>();
	
	static ArrayList<Double> retrieve(Object request) {
		if (request == "Altitude")
			return height;
		else if (request == "Time")
			return currentTime;
		else if (request == "Distance")
			return distanceTraveled;
		else if (request == "Speed") 
			return speed;
		else
			return angleOfFall;
	}
}
