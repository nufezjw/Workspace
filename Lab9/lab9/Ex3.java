package lab9;
import FormatIO.*;
public class Ex3 {
	public static void main(String[] args) {
	Console con=new Console();
	Person ron = new Person("Ron", "Poet", new MyDate(01,02,03));
	MyDate now1 = new MyDate(12, 01, 06);
	now1.print(con);
	con.println(" Ron is " + ron.age(now1));
	MyDate now2 = new MyDate(01, 02, 06);
	now2.print(con);
	con.println(" Ron is " + ron.age(now2));
	MyDate now3 = new MyDate(12, 02, 06);
	now3.print(con);
	con.println(" Ron is " + ron.age(now3));
	MyDate now4 = new MyDate(12, 03, 06);
	now4.print(con);
	con.println(" Ron is " + ron.age(now4));

}
	
	
}