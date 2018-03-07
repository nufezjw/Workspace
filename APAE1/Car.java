
public class Car extends Thread{
	private int xIndex;
	private int yIndex;
	private boolean directions;  //if directions equal true(north to south) otherwise(west to east)
	
	public Car(int xIndex,int yIndex) {
		this.xIndex=xIndex;
		this.yIndex=yIndex;
	}
	
	public void run() {
		if(directions==true) {
			xIndex++;
		}else
			yIndex++;
	}

}
