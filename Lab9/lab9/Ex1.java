package lab9;

import FormatIO.Console;

public class Ex1 
{
	public static void main(String[] arg)
	{
		Console con = new Console();

// Test Dates
		// 2000 year
		MyDate d1 = new MyDate(1, 2, 3);
		d1.print(con);
		con.println(" = " + d1.getDay() + " " 
				+ d1.getMonth() + " " + d1.getYear());
		
		// 2000 year ddmmyy format
		MyDate d2 = new MyDate(10203);
		d2.print(con);
		con.println(" = " + d2.getDay() + " " 
				+ d2.getMonth() + " " + d2.getYear());	
		
		// 1900 year
		MyDate d3 = new MyDate(11, 2, 33);
		d3.print(con);
		con.println(" = " + d3.getDay() + " " 
				+ d3.getMonth() + " " + d3.getYear());
		
		// 1900 year ddmmyy format
		MyDate d4 = new MyDate(110233);
		d4.print(con);
		con.println(" = " + d4.getDay() + " " 
				+ d4.getMonth() + " " + d4.getYear());	
		con.println(d4.getDate());

// Test Person
		Person ron = new Person("Ron", "Poet", 
new MyDate(01,02,03));
		con.println();
		ron.print(con);
		con.print(" = " + ron.getFirstName() + " " 
+ ron.getLastName());
		con.print(" dob ");
		con.println(ron.getDOB().getDate());
	}
}
