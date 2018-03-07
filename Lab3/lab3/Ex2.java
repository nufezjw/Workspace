package lab3;

import FormatIO.Console;
import FormatIO.FileOut;
import FormatIO.StringIn;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Console con= new Console();
con.print("Please enter your first name:");
String firstname=con.readLine();
con.print("Please enter your second name:");
String lastname=con.readLine();

/**input the date*/
con.print("Enter day month and year of birth:");
int year,month,day;
day=con.readInt();
month=con.readInt();
year=con.readInt();


String out=String.format("%12s  %12s  %02d/%02d/%04d",firstname,lastname,day,month,year);//格式化数据
FileOut fout=new FileOut("Lab3personnel.txt");
fout.println(out);
fout.close();

	}

}
