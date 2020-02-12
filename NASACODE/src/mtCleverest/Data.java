package mtCleverest;

import java.util.ArrayList;

// ALLOWS THE SIMDRIVER TO GET THE DATA
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
	
	// WHATEVER THE OBJECT REQUEST IT WILL RETURN
	static ArrayList<Double> retrieve(Object request) {
		if (request == "Altitude")
			return height;
		else if (request == "Time")
			return currentTime;
		else if (request == "Distance")
			return distanceTraveled;
		else if (request == "Velocity") 
			return speed;
		else if (request == "Potential Energy")
			return potentialEnergy;
		else if (request == "Kinetic Energy")
			return kineticEnergy;
		else
			return angleOfFall;
	}
}
