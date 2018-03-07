/**
 * Exercise 3  (Extension)

You may have noticed that drawTop and drawSide are very similar helper methods. 
Replace them with a single method called drawRow that is able to do the work of both drawTop and drawSide. 
Hint: it will need two extra inputs.


 */
package lab8;

import FormatIO.Console;

public class ex3 {

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
			ex3 ex=new ex3();
			ex.drawRow(row,col, con2);
			
		}
		}
	

	}
	/*
	 * drawTop method to draw the Top and the Bottom 
	 */
	public void drawRow(int row,int col,Console con1) {
		
		con1.print("+"+" ");
		for(int i=0;i<col-2;i++) 
			con1.print("-"+" ");
		con1.println("+");
		
		for(int j=0;j<row-2;j++) {
			con1.print("|");
			for(int k=0;k<(col-2)*2+1;k++)
				con1.print(" ");
			con1.println("|");}
		
		con1.print("+"+" ");
		for(int m=0;m<col-2;m++)
			con1.print("-"+" ");
		con1.println("+");
	}
	
	}


