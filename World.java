package main;

public class World {

	//field values; the world of this simulation contains a runway with a plane on it
	private Runway runway;
	private Plane plane;
	
	//constructor initialises the class variables
	public World() {
		
		plane = new Plane();
		runway = new Runway(plane);
		
	}
	
	//Get methods gives access to field variables
	public Plane getPlane() {
		return plane;
	}
	
	public Runway getRunway() {
		return runway;
	}
	//
	
	
	//Get methods for fields means that Demeter's law will not be broken in the main method
	public int getPlaneX() {
		return plane.getX();
	}
	
	public int getPlaneY() {
		return plane.getY();
	}
	
	public int getPlaneSpeed() {
		return plane.getSpeed();
	}
	
	public int getPlaneElevation() {
		return plane.getElevation();
	}
	
	public int getPlaneTimeAtSpeed10() {
		return plane.getTimeAtSpeed10();
	}
	
	public int getRunwayLength() {
		return runway.getLength();
	}
	
	public int getRunwayWidth() {
		return runway.getWidth();
	}
	

	//Set methods for fields means that Demeter's law will not be broken in the main method
	public void setPlaneX(int x) {
		plane.setX(x);
	}
	
	public void setPlaneY(int y) {
		plane.setY(y);
	}
	
	public void setPlaneSpeed(int speed) {
		plane.setSpeed(speed);
	}
	
	
	//methods which call plane methods which allow us not to break Demeter's law in the main method
	public void travelPlane() {
		plane.travel();
	}
	
	public void elevatePlane() {
		plane.elevate();
	}
	
	//we created a resetAll method to be able to obtain a new plane and runway whenever it is used
	public void resetAll() {
		
		plane = new Plane();
		runway = new Runway(plane);
		
	}
	
}
