import java.util.Random;

public class Vehicle {		//Class to define the vehicles who are going on the road. This will never be instantiated.
							//May make it abstract. Think of other things common to vehicles in this example. 
	
	int speed;
	Random r = new Random();
	
	public Vehicle() {	//Constructor
		randomSpeed();
	}
	
	public void randomSpeed() {
		speed = (int) (Math.random() * 500 + 1);	//Changed
		
		//speed = r.nextInt(2000-1000) + 1000;
	}
	
	public void setSpeed(int speed) {
										//This method will generate a random speed. Need to set a limit
		this.speed = speed;	
	}
	
	public int getSpeed() {
		return speed;
	}
	

}
