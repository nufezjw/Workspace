import java.util.Arrays;

/** Defines an object representing a single fitness class
 */
public class FitnessClass implements Comparable<FitnessClass> {
private static final int WEEKNUM=5;
private String id,className,tutorName,startTime;
private int[] attendance=new int[WEEKNUM];

/**
 * default constructor
 */
public FitnessClass() {

}

/**
 * constructor to set instance variables from a String
 * @param line
 */
public FitnessClass(String line) {
	String[] s=line.split("\\s+");//change String to string array,split by whitespace
	this.setId(s[0]);
	this.setClassName(s[1]);
	this.setTutorName(s[2]);
	this.setStartTime(s[3]);
}

/**
 * method to return the average attendance for class
 * @return
 */
public double avgAttendance() {
	int sum=0;
	double avg=0;
	for(int e:attendance) {  //iterate the attendances array and add the values
		sum+=e;
	}
	avg=(double)sum/WEEKNUM;
	return avg;
}

/**
 * method to return a String formatted approximately for the attendance report
 * @return
 */
public String attendanceReport() {
	return "  "+getId()+"\t"+getClassName()+"\t"+getTutorName()+"\t"+toString()+"\t\t"+String.format("%.2f", avgAttendance())+"\r\n";
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public String getTutorName() {
	return tutorName;
}

public void setTutorName(String tutorName) {
	this.tutorName = tutorName;
}

public String getStartTime() {
	return startTime;
}

public void setStartTime(String startTime) {
	this.startTime = startTime;
}

public int[] getAttendance() {
	return attendance;
}

public void setAttendance(int[] attendance) {
	this.attendance = attendance;
}

/**
 * method to compare two fitness class objects on average attendance     
 */
public int compareTo(FitnessClass other) { 

	if(this.avgAttendance()==other.avgAttendance())
		{
		return 0;
		}
	else if(this.avgAttendance()<other.avgAttendance()) {
		return 1;}
	else 
		return -1;
    }

/**
 * method to format the attendances list
 */
public String toString() {
	String line="";
	for(int i=0;i<5;i++) {
		line+=String.format("%2s", attendance[i])+" ";
	}
	return line;
}

}
