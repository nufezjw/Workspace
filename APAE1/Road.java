
public class Road extends Thread{
	private int nrows;
	private int ncols;
	private String[][] gridArray;
	private static final String LINE="-----------------------------------------";
	private GenerateCar car;
	Count m;

	public Road(int nrows,int ncols, GenerateCar car,Count m) {
		this.nrows=nrows;
		this.ncols=ncols;	
		gridArray=new String[nrows][ncols];
		this.car=car;
		this.m=m;
		
	}
	public void run() {
		while(m.count<2000) {
			synchronized(m) {
				if(m.check) {
					try {
						m.wait();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
		System.out.println(LINE);
		for(int i=0;i<nrows;i++) {			
			for(int j=0;j<ncols;j++) {
				gridArray[i][j]="|"+" ";
				gridArray[car.getRowIndex()][0]="|"+"o";
				System.out.print(gridArray[i][j]);
			}
			System.out.println();
		}
		System.out.println(LINE);
		try {									//draw the grid every 20 milliseconds
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.count++;
		m.check=true;
		m.notify();
				}
				}
	}
	}
	
	public int getNrows() {
		return nrows;
	}
	public void setNrows(int nrows) {
		this.nrows = nrows;
	}
	public int getNcols() {
		return ncols;
	}
	public void setNcols(int ncols) {
		this.ncols = ncols;
	}
	public String[][] getGridArray() {
		return gridArray;
	}
	public void setGridArray(String[][] gridArray) {
		this.gridArray = gridArray;
	}
	
}
