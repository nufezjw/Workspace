import java.util.Arrays;



public class Grid implements Runnable { // Class to instantiate the grid array AND refresh

	private int rows;
	private int columns;
	String[][] f;
	
	Car carEast1;
	CarSouth carSouth1;
	
	Car[] carE;
	CarSouth[] carS;
	Thread[] arrayE = new Thread[5];	//Changed
	Thread[] arrayS = new Thread[5];
	
	Thread t = new Thread(carEast1);
	Thread t2 = new Thread(carSouth1);
	

	public Grid(int r, int c) { // Constructor, having this class on its own thread. I.e run method. Need
								// runnable

		this.rows = r;
		this.columns = c;
		f = new String[this.rows][this.columns];
	}
	
	public void positionCars(Car e, CarSouth s) {	//Set cars on the grid 
		this.carEast1 = e;							//Transfer of objects
		this.carSouth1 = s;
	}
	
	
	public void startCars() {
		Thread tE = new Thread(carEast1);	//Give cars a thread object
	    tE.start();
	  
	    Thread tS = new Thread(carSouth1);
	    tS.start();
	}
	
	public void startArray() {	//Give array of threads a car object
		
		for (int i = 0; i < arrayE.length;i++) {		//Changed
			arrayE[i] = new Thread(carE[i]);
			
			arrayS[i] = new Thread(carS[i]);
			
			arrayE[i].start();
			arrayS[i].start();
			
			
		}
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public void arrayCar(Car[] e1, CarSouth[] s1) {	//position cars for array - should already have objects in this. 
		this.carE = e1;								//Pass object array
		this.carS = s1;
		
	}
	
	
	public void gridCarArray() {
		
		System.out.println("--------------------");
		
		for (int r = 0; r < f.length; r++) {		
			for (int c = 0; c < f.length; c++) {

					f[r][c] = " |";	//What grid consists of

				for (int i = 0; i < carE.length; i++) {
					
					if (r == carE[i].getX() && c == carE[i].getY()) { 	//Matching spaces of grid and car
						f[carE[i].getX()][carE[i].getY()] = carE[i].getSymbol();
					}	
					else if (r == carS[i].getX() && c == carS[i].getY()) {
						f[carS[i].getX()][carS[i].getY()] = carS[i].getSymbol();
						
					}
					checkCar(); //Not picking up object
				}
				System.out.print(f[r][c]);
			}
			System.out.println();
		}
		System.out.println("--------------------"); // Grid separator.
		
		try {
			Thread.sleep(200);	//Refresh rate
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		startArray();	//Give array of cars method - needed to start the car obejcts
		checkCar();
		for (int t = 0; t < arrayE.length; t++) { //passing the condition object?	Changed
		carE[t].pass();
		}
		
	}
	
	public void placeOnGrid(int r, int c) {		//Why carE length? - not used
		
		for (int i = 0; i < carE.length; i++) {
		
			if (r == carE[i].getX() && c == carE[i].getY()) { 
				f[carE[i].getX()][carE[i].getY()] = carE[i].getSymbol();
			}	
			else if (r == carS[i].getX() && c == carS[i].getY()) {
				
				f[carS[i].getX()][carS[i].getY()] = carS[i].getSymbol();
			}
			
		}
	}
	
	
	public void makeGrid() { // Put this in the run method - for single cars

		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f.length; c++) {
				if (r == carEast1.getX() && c == carEast1.getY()) { // getting the X which is the position in the array
																	// where
																	// the symbol will show up

					f[carEast1.getX()][carEast1.getY()] = carEast1.getSymbol(); // Increase only X axis to go down, Y to
																				// go across.

				} else if (r == carSouth1.getX() && c == carSouth1.getY()) {
					f[carSouth1.getX()][carSouth1.getY()] = carSouth1.getSymbol();

				} else
					f[r][c] = " |";
				System.out.print(f[r][c]); // Grid prints
			}
			System.out.println();
		}
		System.out.println("--------------------"); // Grid separator.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		startCars();	//Start for two object array
		
		carEast1.pass();

	}
	
	public void check() {
		carSouth1.checkEmpty();
	}
	
	public void crash() {
		carSouth1.checkCrash();
	}
	
	public void seeC() {
		carEast1.seeConflict();
	}

	public boolean seeConflict() {	//Am I checking them all against one another? If carE values are the same as all the other ones? E.g 1 and 5 could have the same values
		for (int i = 0; i < carE.length; i++) {
			if (carE[i].getX()+1 == carS[i].getX()+1 && carE[i].getY()+1 == carS[i].getY()+1) {
				//System.err.print("			Anticipation of crash");
					return true;
		}
	} 
		return false;
	}

	public boolean checkCrash() {
		for (int i = 0; i < carE.length; i++) {
			if (carE[i].getX() == carS[i].getX() && carE[i].getY() == carS[i].getY()) {
					return true;
		}
	}
		return false;
	}
	
	public boolean occupied() {	//Check is string is empty ??
		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f.length; c++) {
				if (checkCrash() == true ) {			//Empty AND if x + 1 is empty move? f[r][c].isEmpty() && 
					return true;
				}
				
			}
		}
		return false;
	}
	
	
	
	public boolean checkCar() {	//Loop entire grid
		
		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f.length; c++) {
				
				
				if (f[r][c].equals(carE[r].getSymbol())|| f[r][c].equals(carS[r].getSymbol()) ) {	//Never getting to this if? - method for match?
					System.err.print("occupied");
					return false;
				}
				
				if (f[r][c].equals(" |")) {
					//System.err.print("empty");
					return true;
				}

			}
		}
		return false;
	}
	

	
	
	
	
	
	
	
	/*public boolean checkCar() {	//Loop entire grid
		
		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f.length; c++) {
				if (f[r][c].isEmpty()) {		//is this checking entire grid spaces - move up to grid?
					System.err.println("Check complete");
					return true;
				}
			}
		}
		
		for (int i = 0; i < carE.length; i++) {
													//Plus one so the next space is free - Talking about the grid specifically not the car
			if (f[carE[i].getX()][carE[i].getY()].isEmpty()) {
				return true;
			}
			if (f[carS[i].getX()][carS[i].getY()].isEmpty()) {
				return true;
			}
		}
		
		return false;
	}*/
	
	
	/*public void makeGrid() { // Put this in the run method - for single cars

		f = new String[this.rows][this.columns];
		// System.out.println(f.length);

		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f.length; c++) {
				if (r == car1.getX() && c == car1.getY()) { // getting the X which is the position in the array where
															// the symbol will show up

					f[car1.getX()][car1.getY()] = car1.getSymbol(); // Increase only X axis to go down, Y to go across.
					// car1.x++; //This method completes all the movement first, then goes.
					// f[car1.getX()][car1.getY()] = "x";
					// car1.y++;
					// Here print grid?

					
					 * try { Thread.sleep(car1.speed); } catch (InterruptedException e) {
					 * 
					 * e.printStackTrace(); }
					 
					// Basic idea is to get where the X and Y co ordinates are from the car object
					// And insert them into the Grid.
				} else if (r == car2.getX() && c == car2.getY()) {
					f[car2.getX()][car2.getY()] = car2.getSymbol();

				} else

					f[r][c] = " |";
				System.out.print(f[r][c]); // Grid prints

			}

			System.out.println();

		}
		System.out.println("--------------------"); // Grid separator.
	}*/

	public void run() { // Trying to make grid print and refresh after when the incrementing is done. So
						// it looks like the O is moving through
						// Maybe have to make Grid and the car object insertion separately.
		
		
		
		
		for (int i = 0; i < 200; i++) {
			
			gridCarArray();
		}
		
		System.out.println(carE[4].getSpeed());	
		System.out.println(carE[4].getX());
		System.out.println(carE[4].getY());
		checkCar();
		for (int i = 0; i < arrayE.length; i++) {
			System.err.println(carE[i].x + " E x");
			System.err.println(carE[i].y);
			System.err.println(carS[i].y + " S y");
			System.err.println(carS[i].x);
		}
		
		
	}

}
