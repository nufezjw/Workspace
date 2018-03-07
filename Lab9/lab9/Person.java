package lab9;

import FormatIO.Console;

public class Person 
{
	private String firstName, lastName;
	private MyDate dob;
	
	public Person(String fn, String ln, MyDate d)
	{
		firstName = fn;
		lastName = ln;
		dob = d;
	}
	
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public MyDate getDOB() { return dob; }
	
	public void print(Console con)
	{
		con.print(firstName + " " + lastName + ":born on ");
		dob.print(con);
	}
	public int age(MyDate now) {
		return dob.differenceInYears(now);
		
	}
	


	
}

