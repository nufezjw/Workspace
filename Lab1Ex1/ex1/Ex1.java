package ex1;

import FormatIO.Console;
import FormatIO.FileOut;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Console con=new Console();
con.println("Hello World");

/*
 * *Creating a new file called "greeting.txt" and write to it */
FileOut fout=new FileOut("greeting.txt");  
fout.println("Hi, David");
	}

}
