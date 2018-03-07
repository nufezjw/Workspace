package lab6;

import FormatIO.Console;

public class drawStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Console con=new Console("Triangle");
    con.print("How many rows of stars?");
    int nRows=con.readInt();
    for(int i=1;i<=nRows;i++) {
    	drawRow(con,i);
    }
	}

	private static void drawRow(Console con, int nStars) {
		// TODO Auto-generated method stub
		for(int i=1;i<=nStars;i++) 
			con.print("*");
		con.println();
			
		}
	}


