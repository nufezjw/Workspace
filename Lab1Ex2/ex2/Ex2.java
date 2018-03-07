package ex2;

import FormatIO.*;


public class Ex2 {

	public static void main(String[] args) {
		
		String s1,s2,s3;
		double radius=0;
	  FileIn fin=new FileIn("C:\\Users\\Jerry\\eclipse-workspace\\Lab1Ex2\\radius.txt");
	  s1=fin.readWord();
	  s2=fin.readWord();
	  radius=fin.readDouble();
	  s3=fin.readWord();
	  
	  double area=Math.PI * radius * radius;
	  String message="The area is "+area;
	  
	  Console con1=new Console("Console 1",5,20);
	  Console con2=new Console("Console 2",5,20);
	  
	  con1.println(message);
//	  con2.println(message);
//	  
	  FileOut fout=new FileOut("Lab2Out.txt");
	  fout.println(message);
	
	
	}

}
