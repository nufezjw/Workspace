import java.util.Random;

public class GenerateCar extends Thread{
	private int rowIndex;
	private int colIndex;
	Count m;
	
	
	public GenerateCar(int rowIndex,int colIndex,Count c) {
		this.rowIndex=rowIndex;
		this.colIndex=colIndex;
		this.m=c;
	}
	
	public void run() {
		while(m.count<2000) {
			synchronized(m) {
		if(!m.check) {
			try {
				m.wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			moveDown();
			m.count++;
			m.check=false;
			m.notify();
		}
	}
			}
	}

	public void moveDown() {

			for(int i=0;i<10;i++) {
				int temp = getRowIndex();	
				temp++;
				setRowIndex(temp);
			}
	}
	
	public int getRowIndex() {
		return rowIndex;
	}



	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}



	public int getColIndex() {
		return colIndex;
	}



	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}

}
