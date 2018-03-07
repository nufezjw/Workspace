

public class MaxMain1 {
	
	public static class MinMaxFinder implements Runnable {
	private double maxValue;
	private double minValue;
	private Double[] myArray;
	public MinMaxFinder(Double[] d) {
		myArray=d;
	}

	public void run() {
		//find the max and min
		maxValue=myArray[0];
		minValue=myArray[0];
		for(Double d:myArray) {
			if(d>maxValue) {
				maxValue=d;
			}
			if(d<minValue) {
				minValue=d;
			}	
		}			
	}
	
	public Double getMax() {
		return maxValue;
	}
	public Double getMin() {
		return minValue;
	}
	
	public static void main(String[] args) {
		int nRows=100;
		int nCols=20;
		Double[][] d = MakeData.generateRandomData(nRows,nCols);//generate the array randomly
		MinMaxFinder[] finder=new MinMaxFinder[nRows];
		Thread[] threadArray = new Thread[nRows];
		for(int i=0;i<nRows;i++) {
			finder[i]=new MinMaxFinder(d[i]);
			threadArray[i]=new Thread(finder[i]);
	//		threadArray[i]=new Thread(finder[i]);
			threadArray[i].start();
		}
		
		//wait for all them to finish
		for(int i=0;i<nRows;i++) {
		try {
			threadArray[i].join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		}	
		Double globalmin=finder[0].getMin();
		Double globalmax=finder[0].getMax();
		for(int i=0;i<nRows;i++) {
			if(finder[i].getMax()>globalmax) {
				globalmax=finder[i].getMax();
			}
			if(finder[i].getMin()<globalmin) {
				globalmin=finder[i].getMin();
			}
		}
		System.out.println("Global min: " + globalmin);
		System.out.println("Global max: " + globalmax);
		
	}
	
}
}