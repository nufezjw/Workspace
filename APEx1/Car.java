import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Car extends Vehicle implements Runnable {	//Sub-class of vehicle
	
	public int x = (int) (Math.random() * 9 + 1);	//Positions in the array - move into vehicle?
	public int y;
	String symbol;
	Grid lane;
	//public int x =(int) (Math.random() * lane.getRows() + 1);	//Positions in the array - move into vehicle?
	ReentrantLock counterLock = new ReentrantLock();
	Condition isEmpty = counterLock.newCondition();
	
	
	public Car(Grid l) {	//Constructor - X and Y co ordinates - DO cars need to know about the Grid?
		//System.out.println("This is the car class");
		
		this.y = 0;
		setSymbol(); 	//Getter to use for the manipulation of the grid
		this.lane = l;
		
	}
	
	
	public void setSymbol() {		//Set car representation. How lol? Or have it as a String in the Grid class
		symbol = "x|";
	}
	
	public boolean checkEmpty() { 							//- better in the grid class? or be in the run method?
		//If grid space is not null and there is no x or o
		
		if (lane.carEast1.getX() == x && lane.carEast1.getY() == y && lane.carSouth1.getX() == x && lane.carSouth1.getY() == y) {
			System.err.println("Occupied");
			return false;
			//Only for two cars BUT can swap the array in? If occupied wait? Tell one to wait. 
		}
		else
			//System.err.println("Empty");
		return true;
	}
	
	public boolean seeConflict() {
		
		if (lane.carEast1.getX()+1 == lane.carSouth1.getX()+1 && lane.carEast1.getY()+1 == lane.carSouth1.getY()+1) {
			System.err.print("			Anticipation of crash");
			return true;
		}
		else
		
		return false;
		
	}
	
	public void moveEast() {	//Increase the Y variable. 
		
		for(int i = y; i <100; i++) {
		 
			y++;
		try {
			Thread.sleep(speed);			//This is correct, but the cars would need to be on their own separate thread - pass same object? 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	
	public void pass() {
		lane.carSouth1.passLock(isEmpty);
	}
	
	public boolean checkCar() {	//Loop entire grid
		
		for (int r = 0; r < lane.f.length; r++) {
			for (int c = 0; c < lane.f.length; c++) {
				if (lane.f[r][c].equals(" |")) {
					return true;
				}
				else if (lane.f[r][c].equals("x|") || lane.f[r][c].equals("o|") ) {
					return false;
				}
			}
		}
		return false;
	}
	
	public void run() {	

		counterLock.lock();	//Lock 
		
		try {
			while(lane.seeConflict() == true) {	
		//If false, it just waits - seeConflict or checkCrash - ask see conflict is from grid class with arrays lane.seeConflict()
		//Condition throws null pointer - this could be that a car has just moved into the space which its just checked?

				
				isEmpty.await();				//Wait until what? 
			}	
				y++;
				if (lane.checkCrash() == true) { //Just a tester
					y--;	//Go back a step if there is a collision? Temp step maybe
					System.err.println("				Crash");	//Check to see if there actually is a crash
				}
				
				try {
					Thread.sleep(speed);			//This is correct, but the cars would need to be on their own separate thread - pass same object? 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}catch (InterruptedException e) {
			// Fall through
			}	finally {
					//isEmpty.signalAll(); The one without the condition has the signal all - not this class
					counterLock.unlock();
			}
		
		if (y > lane.getRows()) {	//Re set method
			y = 0;
			x = (int) (Math.random() * lane.getRows() + 1);
			speed = (int) (Math.random() * 500 + 1);
		}
		
	}
	public boolean checkCrash() {
		if(lane.carEast1.getX() == lane.carSouth1.getX() && lane.carEast1.getY() == lane.carSouth1.getY()) {
			//System.err.println("Crash");
			return true;
		}
		else
		return false;
		
	}
	
	
	
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getX() { 
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() { 
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	
}
