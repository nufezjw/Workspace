import java.io.IOException;

public class Draw extends Thread {
	private Intersection intersection;
	private final static int drawFrequency=20;

	
	public Draw(Intersection intersection){
		this.intersection=intersection;	
	}
	
	/**
	 * method to draw the "---------"
	 */
	public void drawLine() {
		for(int i=0;i<2*intersection.getColumns()+1;i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	/**
	 * method to draw the lanes
	 */
	public void drawLane() {
		try {
			//clear the command line after each draw
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawLine();
		for(int i=0;i<intersection.getRows();i++) {
			for(int j=0;j<intersection.getColumns();j++) {
				Car gridCar=intersection.getGrids()[i][j].getGridCar();
				if(gridCar==null) {
					System.out.print("| ");	
				}else
					System.out.print("|"+gridCar.getSymbol());
			}
			System.out.println("|");
		}
		drawLine();
		
	}
	
	public void run() {
		for(int i=0;i<2000;i++) { 
		try {
			sleep(drawFrequency);
			drawLane();
		//	System.out.println("picture"+i);
		}catch(InterruptedException e) {}
		}
		//The simulator should stop after the grid has been drawn 2000 times(stop the generators)
		intersection.setSignal(true);
	}
}
