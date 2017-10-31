package main;

public class Plane {
	
	//field values; plane has given qualities (coordinates x/y  , a speed , an elevation and a time at speed 10 to modify the elevation)
	private int x;
	private int y;
	private int speed;
	private int elevation;
	private int timeAtSpeed10;
	
	//constructor initialises plane with set parameters
	public Plane() {
		
		x = 5;
		y = 0;
		speed = 0;
		elevation = 0;
		
	}
	
	
	//get methods to obtain the values of the variables in another classes
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getElevation() {
		return elevation;
	}
	
	public int getTimeAtSpeed10() {
		return timeAtSpeed10;
	}
	
	
	//set methods to give values to the variables
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}
	
	/*creates a travel method where the y coordinate will be added by the
	value of the speed each second so we know how the plane travels across the runway*/
	public void travel() {
		y += speed;
	}
	
	/*if plane is at speed 10 for 5 seconds then it will elevate by 1 unit per second,
	 * if it is changed to less than 10 at any point then the elevation will decrease*/
	public void elevate() {
		
		if(speed == 10) {
			timeAtSpeed10++;
			//if timeAtSpeed10 is equal or greater than to 5 then place will elevate
			if (timeAtSpeed10 >= 5) {
				elevation++;
			}
		}
		else {
			timeAtSpeed10 = 0;
			if(elevation > 0) {
				elevation--;
			}
		}
		
	}

}
