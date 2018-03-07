import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * Maintains a list of Fitness Class objects
 * The list is initialised in order of start time
 * The methods allow objects to be added and deleted from the list
 * In addition an array can be returned in order of average attendance
 */
public class FitnessProgram {
   public final int MAXNUMBER=7;//class constant representing the maximum number
   private static FitnessClass[] fitnessArray;//array of FitnessClass objects
   private int actualnumber;//current actual number of (non-null) objects in the list
   
   //default constructor to instantiate the array
   public FitnessProgram() {
	   fitnessArray=new FitnessClass[MAXNUMBER];
   }
   
   //method to build the list ordered on start time from data in a file
   public void buildList(String line) {
	   String[] array=line.split(" ");
	   int index=Integer.parseInt(array[3])-9; //get the start time
	   fitnessArray[index]=new FitnessClass(line);
   }
   
   //method to populate the attendance lists for a given Fitness Class in the array
   public void popAttendance(String line) {
	   String[] newline=line.split("\\s+");
	   int week1=Integer.parseInt(newline[1]);
	   int week2=Integer.parseInt(newline[2]);
	   int week3=Integer.parseInt(newline[3]);
	   int week4=Integer.parseInt(newline[4]);
	   int week5=Integer.parseInt(newline[5]);
	   int[] attendances=new int[] {week1,week2,week3,week4,week5};
	   FitnessClass newclass=new FitnessClass();
	   newclass=returnObjectID(newline[0]);
	   newclass.setAttendance(attendances); 
   }
   
   //method to return the FitnessClass object at index x
   public FitnessClass returnObjectx(int x) {
	   return fitnessArray[x];
   }
   
   //method to return the FitnessClass starting at a particular time(or null if no such class exists)
   public FitnessClass returnObjectime(int time) {
	   for(int i=0;i<MAXNUMBER;i++) {
		   if(fitnessArray[i]!=null&&fitnessArray[i].getStartime()==time) {
			   return fitnessArray[i];
		   }
	   }
	return null;   
   }
   
   //method to return the first start time that is available for a class
   public int returnOpentime() {
	   int opentime=0;
	   for(int i=0;i<MAXNUMBER;i++) {
		   if(fitnessArray[i]==null) {
			   opentime=i+9;
			   return opentime;
		   }
	   }
	return 0;
   }
   
   //method to return the FitnessClass with the FitnessClassID
   public FitnessClass returnObjectID(String id) {
	   for(int i=0;i<MAXNUMBER;i++) {
		   if(fitnessArray[i]!=null&&fitnessArray[i].getClassid().equals(id)) {
			   return fitnessArray[i];
		   }
	   }
	return null;
   }
   
   //method to insert a FitnessClass object to the list
   public void insertObject(String id,String classname,String tutorname,int startime,int[] attendance) {
	   System.out.println(returnOpentime());
	   int index=returnOpentime()-9;
	   fitnessArray[index]=new FitnessClass();
	   fitnessArray[index].setClassid(id);
	   fitnessArray[index].setClassname(classname);
	   fitnessArray[index].setTutorname(tutorname);
	   fitnessArray[index].setStartime(startime);
	   fitnessArray[index].setAttendance(attendance);
   }
   
   //method to delete a FitnessClass object to the list
   public void deleteObject(String classid) {
	   boolean found=false;
	   for(int i=0;i<MAXNUMBER;i++) {
		   if(fitnessArray[i]!=null&&fitnessArray[i].getClassid().equals(classid)) {
			   fitnessArray[i]=null;
			   found=true;
		   }
	   }
	   if(found==false) {
	    	JOptionPane.showMessageDialog(null, "CLASS DOES NOT EXIST!", "WARNING", JOptionPane.ERROR_MESSAGE);
	    }
   }
   
   //method to return a list sorted in non-increasing order on the average attendance at each class
   //use the Arrays.sort method
   public FitnessClass[] returnList() {
	   int number=getActualnumber();
	   FitnessClass[] newfitnessArray=new FitnessClass[number]; //create a new list to contain the sorted average attendance
	   int i=0;
	   for(int j=0;j<MAXNUMBER;j++) {
		   if(fitnessArray[j]!=null) {
			   newfitnessArray[i]=fitnessArray[j];
			   i++;
		   }
	   }
	   Arrays.sort(newfitnessArray);
	   return newfitnessArray;	   
   }
   
   //method to return the overall average attendance
   public String returnOverall() {
	   float avg=0;
	   float sum=0;
	   for(int i=0;i<MAXNUMBER;i++) {
		   if(fitnessArray[i]!=null) {
			   sum=sum+fitnessArray[i].returnAverage();
		   }
	   }
	 //  System.out.println(getActualnumber());
	   avg=sum/getActualnumber();
	   return String.format("%.2f", avg);
   }
  
   public static FitnessClass[] getFitnessArray() {
	   return fitnessArray;
   }

   public static void setFitnessArray(FitnessClass[] fitnessArray) {
	   FitnessProgram.fitnessArray = fitnessArray;
   }

   //method to return the number of classes in the list
   public int getActualnumber() {
	   actualnumber=0;
	   for(int i=0;i<MAXNUMBER;i++) {
		   if(fitnessArray[i]!=null) {
			   actualnumber++;
		   }
	   }
	   return actualnumber;
   }

   public void setActualnumber(int actualnumber) {
	   this.actualnumber = actualnumber;
   }

//main method for testing
//   public static void main(String[] args) {
//	   FitnessProgram fitprogram=new FitnessProgram();
//	   FileReader fr1=null;
//	   FileReader fr2=null;
//	   try {
//		fr1=new FileReader("ClassesIn.txt");
//		fr2=new FileReader("AttendancesIn.txt");
//		Scanner input1=new Scanner(fr1);
//		String line1=null;
//		while(input1.hasNext()) {
//			line1=input1.nextLine();
//			fitprogram.buildList(line1);
//		}
//		Scanner input2=new Scanner(fr2);
//		String line2=null;
//		while(input2.hasNext()) {
//			line2=input2.nextLine();
//			fitprogram.popAttendance(line2);
//		}
//		for(int i=0;i<MAXNUMBER;i++) {
//			if(fitnessArray[i]!=null) {
//				System.out.println(fitnessArray[i].getClassid()+Arrays.toString(fitnessArray[i].getAttendance()));
//			}
//		}		
//	   } catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		   e.printStackTrace();
//	   }
//	   try {
//		  if(fr1!=null) {
//			  fr1.close();
//		  }
//	   }catch(Exception e) {
//		   e.printStackTrace();
//   }
//	   
//   }
}
