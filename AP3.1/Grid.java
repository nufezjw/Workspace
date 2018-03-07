import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
	private Car gridCar;      
	private boolean isOccupied;
	
	//guarantee only one vehicle can be in one grid square
	private ReentrantLock gridlock=new ReentrantLock();
	private Condition empty=gridlock.newCondition();
	
	public Grid() {
		gridCar=null;
		isOccupied=false;
	}
	
	/**
	 * a car enters one grid square
	 */
	public void enterGrid(Car car) {
		gridlock.lock();
		try {
			while(isOccupied) {
				empty.await();
			}
			isOccupied=true;
			gridCar=car;
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			gridlock.unlock();
		}
	}
	
	/**
	 * a car leave one grid square
	 */
	public void leaveGrid() {
		gridlock.lock();
		try {
			isOccupied=false;
			gridCar=null;
			empty.signalAll();
		}finally {
			gridlock.unlock();
		}
	}
	
	/**
	 * getters and setters method to access to the attributes
	 */
	public Car getGridCar() {
		return gridCar;
	}

	public void setGridCar(Car gridCar) {
		this.gridCar = gridCar;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	
}
