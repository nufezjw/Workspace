import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Grid implements Runnable {
	private int rows;
	private int columns;
	private String[][] grids;
//	private NsCar nsCar;
//	private WeCar weCar;
	
	private NsCar[] nsCars;
	private WeCar[] weCars;
	
	
	public Grid(int rows,int columns) {
		this.rows=rows;
		this.columns=columns;
		grids=new String[rows][columns];
	}

	public void setCars(NsCar[] nsCars,WeCar[] weCars) {
		this.nsCars=nsCars;
		this.weCars=weCars;
	}
	
	public void startCars(NsCar[] nsCars,WeCar[] weCars) {
		
		for(int i=0;i<nsCars.length;i++) {
			nsCars[i].start();
		}
		for(int i=0;i<weCars.length;i++) {
			weCars[i].start();
		}
	
	}
	
	public  void printGrid() {
		System.out.println("------------------------------------------");
		for(int i=0;i<getRows();i++) {
			for(int j=0;j<getColumns();j++) {
				grids[i][j]=" |";
				for(int k=0;k<nsCars.length;k++) {
					if(i==nsCars[k].getX()&&j==nsCars[k].getY()) {	
						grids[nsCars[k].getX()][nsCars[k].getY()]="o|";	
					}
				}
				for(int m=0;m<weCars.length;m++) {
					if(i==weCars[m].getX()&&j==weCars[m].getY()) {
						grids[weCars[m].getX()][weCars[m].getY()]="-|";
					}
				}
			}
		}
			for (int i=0; i<getRows(); i++) { 
			 	for (int j=0; j<getColumns(); j++) {
			 		System.out.print(grids[i][j]);
			     }
		System.out.println();
		}
		System.out.println("------------------------------------------");
		
	}
	
	
//	public  void printGrid() {
//		System.out.println("------------------------------------------");
//		for(int i=0;i<getRows();i++) {
//			for(int j=0;j<getColumns();j++) {
//				grids[i][j]=" |";
//				for(int k=0;k<nsCars.length;i++) {
//					if(i==nsCars[k].getX()&&j==nsCars[k].getY()) {	
//						grids[nsCars[k].getX()][nsCars[k].getY()]="o|";	
//					}else if(i==weCars[k].getX()&&j==weCars[k].getY()) {
//						grids[weCars[k].getX()][weCars[k].getY()]="-|";
//					}
//				}
//				System.out.println(grids[i][j]);
//			}
//		}
//		for (int i=0; i<getRows(); i++) {
//			 for (int j=0; j<getColumns(); j++) {
//			 	System.out.print(grids[i][j]);
//			 }
//		System.out.println();
////		}
//		System.out.println("------------------------------------------");
//		startCars(nsCars, weCars);
//	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}



	public String[][] getGrids() {
		return grids;
	}

	public void setGrids(String[][] grids) {
		this.grids = grids;
	}
	
	
	public NsCar[] getNsCars() {
		return nsCars;
	}

	public void setNsCars(NsCar[] nsCars) {
		this.nsCars = nsCars;
	}

	public WeCar[] getWeCars() {
		return weCars;
	}

	public void setWeCars(WeCar[] weCars) {
		this.weCars = weCars;
	}

	@Override
	public void run() {
		for(int i=0;i<2000;i++) {	
			printGrid();
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
