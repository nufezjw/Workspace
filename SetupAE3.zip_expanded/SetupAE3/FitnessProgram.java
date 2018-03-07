import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Maintains a list of Fitness Class objects
 * The list is initialised in order of start time
 * The methods allow objects to be added and deleted from the list
 * In addition an array can be returned in order of average attendance
 */
public class FitnessProgram {
	final  int MAXCLASS=7; //constant to represent the maximum number of classes
	FitnessClass[] objects=new FitnessClass[MAXCLASS];  //create a list of FitnessClass objects
	public int currNumber;//current actual number of objects in the list
	

/**
 * a default constructor 
 */
public FitnessProgram() {

}

/**
 * method to build the list ordered on start time from data in a file
 * @param line
 */
public void orderedList(String line) {
	FitnessClass fitclass=new FitnessClass(line);
	String time=fitclass.getStartTime();
	int timer=Integer.parseInt(time);
	objects[timer-9]=new FitnessClass(line);
}

/**
 * method to return the number of classes in the list
 * @return
 */
public int returnNumber() {
	currNumber=0;
	for (FitnessClass fitnessClass : objects) {
		if(fitnessClass!=null)
			currNumber++;
	}
	return currNumber;	
}

/**
 * method to return the FitnessClass object at index X
 * @param i
 * @return
 */
public  FitnessClass getFitnessClass(int i) {
		return objects[i];	  
}

/**
 * method to populate the attendance lists for a given Fitness Class
 * @param line
 */
public void popAttendList(String line) {
	String[] s=line.split("\\s+");
	int[] attendance={Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5])};
	getFitnessClass2(s[0]).setAttendance(attendance);
}


/**
 * method to return a FitnessClass starting at a particular time(or null if no such class exists)
 * @param t
 * @return
 */
public FitnessClass getFitnessClass1(int t) {
	for(int i=0;i<7;i++) {
		if(objects[i]!=null&&Integer.parseInt(objects[i].getStartTime())==t) { //compare the start time
			return objects[i];}
	}
	return null;
}

/**
 * method to return a FitnessClass object with a given ID number in the array or null if not present
 * @param id
 * @return
 */
public FitnessClass getFitnessClass2(String id) {
	for(int i=0;i<MAXCLASS;i++) {
		if(objects[i]!=null&&objects[i].getId().equals(id)) {
			return objects[i];
		}
	}
	return null;
}

/**
 * method to return the first start time that is available for a class
 * @return
 */
public int returnFirstTime() {
	for(int i=0;i<MAXCLASS;i++) {
		if(objects[i]==null) {
			 return i+9;
		}		
	}
	return -1;
}

/**
 * method to delete a FitnessClass object from the list
 * @param i
 */
public void deleObject(int i) {
	objects[i]=null;
}

/**
 * method to insert a FitnessClass object to the list
 */
public void insertObject() {
		objects[returnFirstTime()-9]=new FitnessClass();
}

/**
 * method to return a list sorted in non-increasing order on the average attendance at each class use the Arrays.sort Method
 * @return
 */
public FitnessClass[] sortList() {
	FitnessClass[]  curfit=new FitnessClass[returnNumber()];
	int j=0;
	for(int i=0;i<MAXCLASS;i++) {
		if(objects[i]!=null) {
			curfit[j]=objects[i];
			j++;
		}
	}
	Arrays.sort(curfit); //sort the current list 
	return curfit; //return the sorted list
}

/**
 * method to return the overall average attendance
 * @return
 */
public double avgAttendance() {
	double sum=0;
	for(int i=0;i<MAXCLASS;i++) {
		if(getFitnessClass(i)!=null)
			sum+=getFitnessClass(i).avgAttendance();
	}
	return sum/currNumber;
}
}
