import java.util.Random;

public class Car extends Thread {
	//(x,y) represent the position of car 
	private int x;  
	private int y;
	private int speed;
	private String symbol;
	private boolean onGrid;
	private Intersection intersection;
	private String direction;
	private double startTime;
	private double endTime;
	private double gridTime; //the time a vehicle takes to travel through the grid
	
	public Car(int x,int y,String symbol,Intersection intersection,String direction) {
		this.x=x;
		this.y=y;
		this.symbol=symbol;
		this.intersection=intersection;
		this.onGrid=true;
		this.direction=direction;
		
		Random r=new Random();
		this.speed=r.nextInt(300)+50; // set the initial speed of the car from 50 to 350
	}
	
	/**
	 * add a car to the grid(initialization)
	 */
	public void addCar() {
		intersection.getSpecificGrid(x, y).enterGrid(this);
		startTime=System.currentTimeMillis();
	}
	
	/**
	 * remove a car from the grid(the car has reached the edge of the grid)
	 */
	public void removeCar() {
		intersection.getSpecificGrid(x, y).leaveGrid();
		onGrid=false;
		endTime=System.currentTimeMillis();
		gridTime=endTime-startTime;
	}
	
	/**
	 * The following four methods represent that the car moves from four different
	 * directions respectively.
	 * moveWE(): WEST TO EAST
	 * moveEW(): EAST TO WEST
	 * moveNS(): NORTH TO SOUTH
	 * moveSN(): SOUTH TO NORTH
	 */
	public void moveWE() {  // the car moves from west to east
		if(y>=intersection.getColumns()-1) {
			removeCar();
		}else {
			intersection.getSpecificGrid(x, y+1).enterGrid(this);
			intersection.getSpecificGrid(x, y).leaveGrid();
			y++;
		}
	}
	
	public void moveEW() {
		if(y==0) {
			removeCar();
		}else {
			intersection.getSpecificGrid(x, y-1).enterGrid(this);
			intersection.getSpecificGrid(x, y).leaveGrid();
			y--;
		}
	}
	
	public void moveNS() {	// the car moves from north to south
		if(x>=intersection.getRows()-1) {
			removeCar();
		}else {
			intersection.getSpecificGrid(x+1, y).enterGrid(this);
			intersection.getSpecificGrid(x, y).leaveGrid();
			x++;
		}
	}
	
	public void moveSN() {
		if(x==0) {
			removeCar();
		}else {
			intersection.getSpecificGrid(x-1, y).enterGrid(this);
			intersection.getSpecificGrid(x, y).leaveGrid();
			x--;
		}
	}
	
	@Override
	public void run() {
		while(onGrid) {
			try {
				sleep(speed);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		//according to the argument "direction" to choose the different methods
		switch(direction) {
		case "WE":
			moveWE();
			break;
		case "EW":
			moveEW();
			break;
		case "NS":
			moveNS();
			break;
		case "SN":
			moveSN();
			break;
		}
		}
	}

	
	public boolean isOnGrid() {
		return onGrid;
	}

	public void setOnGrid(boolean onGrid) {
		this.onGrid = onGrid;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getGridTime() {
		return gridTime;
	}

	public void setGridTime(double gridTime) {
		this.gridTime = gridTime;
	}
}
