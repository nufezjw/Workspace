package lab9;
/*
 *  A class to represent dates.
 */
import FormatIO.*;

public class MyDate 
{
	private int day, month, year;
	
	public MyDate(int d, int m, int y)
	{
		day   = d;
		month = m;
		year  = (y <= 20) ? 2000 + y : 1900 + y;//We always store year as fout digits
	}
	
	public MyDate(int ddmmyy)
	{
		day   = ddmmyy / 10000;
		ddmmyy %= 10000; // get rid of the day part
		month = ddmmyy / 100;
		year  = ddmmyy % 100;
		year  = (year <= 20) ? 2000 + year : 1900 + year;
	}
	
	public int getDay() { return day; }
	public int getMonth() { return month; }
	public int getYear() { return year; }
	public String getDate() { 
   return String.format("%02d%02d%02d", day, month, 
year%100);
}

	public void print(Console con)
	{
		con.print(String.format("%02d/%02d/%04d",
day, month, year));
	}
	public int differenceInYears(MyDate now)
	{
		if (now.getMonth() > this.getMonth())
			return now.getYear() - this.getYear();
		else if (now.getMonth() < this.getMonth())
			return now.getYear() - this.getYear() - 1;
		else if (now.getDay() >= this.getDay())
			return now.getYear() - this.getYear();
		else
			return now.getYear() - this.getYear() - 1;			
	}

}
