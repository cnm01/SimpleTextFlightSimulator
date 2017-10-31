package main;

public class Runway {
	
	//field values; runway has the given qualities(length, width, and a plane which is on the runway)
	private int length;
	private int width;
	private Plane plane;
	
	//constructor initialises the variables and we can pass an already existing plane to put on the runway
	public Runway(Plane plane) {
		
		this.plane = plane;
		length = 100;
		width = 10;
		
	}
	
	//get methods gives access to values in field variables
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Plane getPlaneOnRunway() {
		return plane;
	}
	

}
