import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WeCar extends Thread{
	private int x;
	private int y;
	private final String car="|-"; 	//car from west to east
	private Grid grid;
	private int speed;
	private ReentrantLock gridlock=new ReentrantLock();
	private Condition isEmpty=gridlock.newCondition();
	
	public WeCar(Grid grid) {
		Random ran=new Random();
		int boundary=grid.getRows(); 
		this.x=ran.nextInt(boundary);
		this.y=0;
		this.speed=200+ran.nextInt(0200);   //generate the speed randomly
		this.grid=grid;
	}
	
	public void moveWe() {
		for(int i=0;i<grid.getColumns();i++) {
			y++;
			try {
				Thread.sleep(speed);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		moveWe();
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

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getCar() {
		return car;
	}

}
