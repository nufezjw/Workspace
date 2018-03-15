import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
	private Car gridCar;      
	private boolean isOccupied;
	
	//guarantee only one vehicle can be in one grid square
	private ReentrantLock gridLock=new ReentrantLock();
	private Condition empty=gridLock.newCondition();
	
	public Grid() {
		this.gridCar=null;
		this.isOccupied=false;
	}
	
	/**
	 * a car enters one grid square
	 */
	public void enterGrid(Car car) {
		gridLock.lock();
		try {
			while(isOccupied) {
				empty.await();
			}
			isOccupied=true;
			gridCar=car;
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			gridLock.unlock();
		}
	}
	
	/**
	 * a car leave one grid square
	 */
	public void leaveGrid() {
		gridLock.lock();
		try {
			gridCar=null;
			isOccupied=false;	
			empty.signalAll();
		}finally {
			gridLock.unlock();
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
