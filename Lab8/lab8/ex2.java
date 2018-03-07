/**
 * Exercise 1

Write a helper method called drawTop that draws the top and bottom of the box. 
 It will draw a +, a sequence of -, and then a +.  
 It will need a Console and the number of columns as inputs.  
 It does not return any outputs.  
 Test this program by calling it from main.  
 main should create the Console and provide the number of columns.  
 You do not have to get any information from the user at this stage.  
 You can just hard code the number of columns in main.

Now write a helper method called drawSide to draw both sides of the box. 
 Once again test it by calling it from main.

 */
package lab8;

import FormatIO.Console;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console con1=new Console();
		while(true) {
		con1.print("Do you want to draw a box?");
		String s=con1.readWord();
		con1.print("How many rows?");
		int row=con1.readInt();
		con1.print("How many cols?");
		int col=con1.readInt();
		
		if(s.equals("yes")) {
			Console con2=new Console();
			ex2 ex=new ex2();
			ex.drawTop(col, con2);
			ex.drawSide(row, col, con2);
			ex.drawTop(col, con2);
		}
		}
	

	}
	/*
	 * drawTop method to draw the Top and the Bottom 
	 */
	public void drawTop(int col,Console con1) {
		con1.print("+"+" ");
		for(int i=0;i<col-2;i++)
			con1.print("-"+" ");
		con1.println("+");
	}
	/*
	 * drawSide method to draw the both sides
	 */
	public void drawSide(int row,int col,Console con1) {
		for(int i=0;i<row-2;i++) {
			con1.print("|");
			for(int j=0;j<(col-2)*2+1;j++)
				con1.print(" ");
			con1.println("|");
		}	    	
	}

}
