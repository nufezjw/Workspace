package GUI;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Referee {
private String id,firstName,lastName;
private String Qualificaton;
private int preallocated;
private String hometown;
private Boolean travelNorth;
private Boolean travelCenter;
private Boolean travelSourth;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getQualificaton() {
	return Qualificaton;
}
public void setQualificaton(String qualificaton) {
	Qualificaton = qualificaton;
}
public int getPreallocated() {
	return preallocated;
}
public void setPreallocated(int preallocated) {
	this.preallocated = preallocated;
}
public String getHometown() {
	return hometown;
}
public void setHometown(String hometown) {
	this.hometown = hometown;
}
public Boolean getTravelNorth() {
	return travelNorth;
}
public void setTravelNorth(Boolean travelNorth) {
	this.travelNorth = travelNorth;
}
public Boolean getTravelCenter() {
	return travelCenter;
}
public void setTravelCenter(Boolean travelCenter) {
	this.travelCenter = travelCenter;
}
public Boolean getTravelSourth() {
	return travelSourth;
}
public void setTravelSourth(Boolean travelSourth) {
	this.travelSourth = travelSourth;
}

/*构造方法*/


public Referee() {
	try {
		FileReader reader=new FileReader("RefereesIn.txt");
		Scanner in=new Scanner(reader);
	   while(in.hasNext()) {
	 	String refereeLine=in.nextLine();
	 	String[] refereesArray=refereeLine.split(" ");
	    }
	   reader.close();
		}
	    catch(IOException x) {
	    	System.out.println("File Problem");
	    }
	 
	}  
	
}

