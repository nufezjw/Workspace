
public class Printer implements Runnable{
	private Grid grid;

	public Printer(Grid grid) {
		this.grid=grid;
	}

	@Override
	public void run() {
		while(true) {
		printGrid();
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	public synchronized void printGrid() {
		for(int i=0;i<grid.getRows();i++) {
			for(int j=0;i<grid.getColumns();j++) {
				if(i==grid.getNsCar().getX()&&j==grid.getNsCar().getY()) {
					grid.getGrids()[i][j]="o|";
				}
				else if(i==grid.getWeCar().getX()&&j==grid.getWeCar().getY()) {
					grid.getGrids()[i][j]="-|";
				}else {
					grid.getGrids()[i][j]=" |";
				}
					
			}
		}
	}
	
	

}
