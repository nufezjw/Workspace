package project1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import GUI.JavaBallGUI;

public class testIO {

public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

/**
 * read the file*/
	try {
	FileReader reader=new FileReader("RefereesIn.txt");
	Scanner in=new Scanner(reader);
   while(in.hasNext()) {
 	String s=in.nextLine();
 	System.out.println(s);
    }
   reader.close();
	}
    catch(IOException x) {
    	System.out.println("File Problem");
    }
 
}  

}

	


