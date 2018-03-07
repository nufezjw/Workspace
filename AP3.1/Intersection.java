
public class Intersection {
	private int rows;
	private int columns;
	private Grid[][] grids;
	//once the draw method stopped, 
	//the intersection.signal should inform the generators to stop
	private boolean signal;	
	
	public Intersection(int rows,int columns) {
		this.rows=rows;
		this.columns=columns;
		grids=new Grid[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				grids[i][j]=new Grid();
			}
		}
	}
	
	/**
	 * method to get a specific grid from the intersection
	 * @return
	 */
	public Grid getSpecificGrid(int x,int y) {
		return grids[x][y];
		
	}
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

	public Grid[][] getGrids() {
		return grids;
	}

	public void setGrids(Grid[][] grids) {
		this.grids = grids;
	}

	public boolean isSignal() {
		return signal;
	}

	public void setSignal(boolean signal) {
		this.signal = signal;
	}
	
}
