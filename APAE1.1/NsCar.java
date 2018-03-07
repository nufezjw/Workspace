import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NsCar extends Thread {
	private int x;
	private int y;
//	private final String car="|o"; 	//car from north to south
	private Grid grid;
	private int speed;
	private String sign="|o";
	private boolean empty=false;
	private ReentrantLock gridlock=new ReentrantLock();
	private Condition isEmpty=gridlock.newCondition();
	
	public NsCar(Grid grid) {
		int boundary=grid.getColumns();
		this.x=0;
		Random ran=new Random();
		this.y=ran.nextInt(boundary);
		this.speed=ran.nextInt(2000)+200;
		this.grid=grid;
	}
	
//	/**
//	 * method to check whether the next grid is empty
//	 */
//	public void isOccupied() {
//		for(int i=0;i<grid.getRows();i++) {
//			for(int j=0;j<grid.getColumns();j++) {
//				if(grid.getGrids()[i][j].equals(" |")) {
//					empty=true;
//				}else 
//					empty=false;
//				}
//		}
//	}
	
	public void moveNs() {
		gridlock.lock(); 	
			try {
			while(!grid.getGrids()[x+1][y].equals(" |")) {
					isEmpty.await();
			}
			x++;
			}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}finally {
				gridlock.unlock();
			}
			
			try {
				Thread.sleep(speed);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
	}
	

	public  void run() {
		for(int i=0;i<grid.getRows();i++) {
			moveNs();
		}
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
