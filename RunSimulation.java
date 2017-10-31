package main;

public class RunSimulation {
	
	public static void main(String[] args){
		
		//creates a new window containing the UI
		Window window = new Window();
		//creates a new world which will be represented in the window
		World world = new World();
		
		//original time is zero
		int time = 0;
		
		//main game loop
		for(int i = 0; i <= 1000; i++) {	
			
			//if reset button is pressed during gameplay then everything is returned to default position and time is sent back to zero
			if (window.getReset()) {
				time = 0;
				window.resetAll();
				world.resetAll();
			}
		
			//time increases by 1 second with each iteration
			time++;
			
			//adds actual values of plane to to the text panel in the window
			window.setTextInPanel(window.getTextInPanel()+"\ntime= "+time + "   x = " + world.getPlaneX() + "   y = " + world.getPlaneY() + "   speed = " + world.getPlaneSpeed() + "   elevation = " + world.getPlaneElevation());
			//sets the x coordinate of the plane to the value of the xslider
			world.setPlaneX(window.getXValue());
			//sets the value of the speed of the plane to the value of the yslider
			world.setPlaneSpeed(window.getYValue());
			//allows plane to travel through the runway each second
			world.travelPlane();
			//allows plane to elevate if determined necessary by the planes elevate method
			world.elevatePlane();
			
			//if plane reaches end of the runway and is below the specified elevation(5) or is not in the centre of the runway (at x=5) then take off will fail
			if ((world.getPlaneY() >= world.getRunwayLength() && world.getPlaneElevation() < 5) || (world.getPlaneY() >= world.getRunwayLength() && world.getPlaneX() != 5)) {
				//pause for 1 second
				try { Thread.sleep(1000); } catch ( InterruptedException e ) {}
				//prints plane details one more time
				window.setTextInPanel(window.getTextInPanel()+"\ntime= "+time + "   x = " + world.getPlaneX() + "   y = " + world.getPlaneY() + "   speed = " + world.getPlaneSpeed() + "   elevation = " + world.getPlaneElevation());
				//sends failure message
				window.setTextInPanel(window.getTextInPanel() + "\nTake off failed!");
				//pauses for one second
				try { Thread.sleep(1000); } catch ( InterruptedException e ) {}
				//exit loop
				break;
			}
			
			//if plane reaches elevation=5 and the plane is in the centre of the runway then takeoff is successfull
			if (world.getPlaneElevation() >= 5 && world.getPlaneX() == 5) {
				//pause for 1 second
				try { Thread.sleep(1000); } catch ( InterruptedException e ) {}
				//print details one more time
				window.setTextInPanel(window.getTextInPanel()+"\ntime= "+time + "   x = " + world.getPlaneX() + "   y = " + world.getPlaneY() + "   speed = " + world.getPlaneSpeed() + "   elevation = " + world.getPlaneElevation());
				//print success message
				window.setTextInPanel(window.getTextInPanel() + "\nSuccessful take off!");
				//pause for one second
				try { Thread.sleep(1000); } catch ( InterruptedException e ) {}
				//exit loop
				break;
			}
			
			//details of plane are printed once every second
			try { Thread.sleep(1000); } catch ( InterruptedException e ) {}
			
		}
		
	}
	
}
