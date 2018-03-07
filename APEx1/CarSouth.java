import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CarSouth extends Vehicle implements Runnable {
	
	public int x;	//Positions in the array - move into vehicle?
	public int y = (int) (Math.random() * 9 + 1);	//Set these private later
	String symbol;
	Grid lane;
	//public int y =(int) (Math.random() * lane.getRows() + 1);	//Set these private later
	ReentrantLock counterLock = new ReentrantLock();
	Condition isEmpty; 
	
	
	public CarSouth(Grid l) {	//Constructor for class of car moving south
		
		this.x = 0;
		setSymbol();
		this.lane = l;
		
	}
	
	
	public void setSymbol() {	
		symbol = "o|";
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

	
	public void moveSouth() {	//This would increase the X variable - speed variable here? 
		
		for(int i = x; i <20; i++) {
			 
			x++;
		try {
			Thread.sleep(speed);			//This is correct, but the cars would need to be on their own separate thread - pass same object? 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		if (x > lane.getRows()) {
			y =(int) (Math.random() * 9 + 1);
			x =  0;
		}
	
		
		/*try {
			Thread.sleep(speed);	//Both going to sleep concurrently during the same update phase. need to split
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	//Boolean to check is spaces are empty?
	
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
	
	public boolean checkCrash() {
		if(lane.carEast1.getX() == lane.carSouth1.getX() && lane.carEast1.getY() == lane.carSouth1.getY()) {
			System.err.println("Crash");
			return true;
		}
		else
		return false;
		
	}
	
	public boolean seeConflict() {
		
		if (lane.carEast1.getX()+1 == lane.carSouth1.getX()+1 && lane.carEast1.getY()+1 == lane.carSouth1.getY()+1) {
			System.err.println("Anticipation of crash");
			return true;
		}
		else
		
		return false;
		
	}
	
	
	
	public void run() {
		isEmpty = counterLock.newCondition();
		counterLock.lock();
		
		try {
			/*while(lane.seeConflict() == true) {
				try {
					isEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			/*if (lane.checkCrash() == true) { //Chance of deadlock
				x--;
			}*/
			x++;
			
			try {
				Thread.sleep(speed); // Set speed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			isEmpty.signalAll();		//If there is space in the next lane --	Do I need to put it in the grid class - because both objects are using it
		}finally {
			counterLock.unlock();
		}

		
		if (x > lane.getRows()) {	//Re set method
			y =(int) (Math.random() * lane.getRows() + 1);
			x =  0;
			speed = 800; //(int) (Math.random() * 500 + 1);
		}
		//x++;
			
			/*try {
				Thread.sleep(speed);		//Set speed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//counterLock.unlock();
		
	}
	
	
	public void passLock(Condition e) {	//Passed same object?
		this.isEmpty = e;
		
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
