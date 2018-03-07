import java.util.*;

public class APSpec1 {
	
	public static void main(String[] args) {
		
		Grid l = new Grid(10,20);	//Length is respect to the number of rows. 20 is number of columns
 		

		//Making a test case of two car objects on their own thread with the grid
		
		Car car1 = new Car(l); 				// Once it goes higher than grid length it falls off. - Starts from Zero
		CarSouth car2 = new CarSouth(l); //Or make its own thread in the main? each object would need its own thread, and in the run method a set number of times for it increase x or y
										//Would defo need its own thread generation in the grid class. 		
		l.positionCars(car1, car2);
		
		//For pair of cars
		
		//-------Array
		
		Car[] carArray = new Car[5];					//REDUCED
		CarSouth[] carSouthArray = new CarSouth[5];
		
		System.err.println(l.carEast1.getSpeed());	//Random speed generators
		System.err.println(l.carSouth1.getSpeed());
		
		
		for (int i =0; i<carArray.length;i++) {	//Same number of array slots
			Car carE = new Car(l);
			carArray[i]= carE;
			
			CarSouth carSouth = new CarSouth(l);
			carSouthArray[i] = carSouth;
		}
		
		l.arrayCar(carArray, carSouthArray);
		
		Thread g = new Thread(l);
		g.start();	//Can't have a thread actually loop - need the loop to be in the run method
		
		// Make random insertion points along the 2D array for that specific car. For
		// Car1 randomise the X variable to insert at row to go east - car2 randomise the Y variable
	
		
	}

}
