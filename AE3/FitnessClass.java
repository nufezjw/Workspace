/** Defines an object representing a single fitness class
 */
public class FitnessClass implements Comparable<FitnessClass> {
	public static final int WEEK=5;// a class constant representing the number of weeks
	// instance variables to represent the class ID and name, the tutor¡¯s name, the start time and the set of attendance records.
	private String classid,classname,tutorname;
	private int startime;
	private int[] attendance;
	
	//constructor
	public FitnessClass(){
		
	}
	
	/**
	 * constructor to set instance variables from a String containing data for the ID number, name, tutor name and start time
	 * @param line
	 */
	public FitnessClass(String line) {
		String[] array =line.split(" ");
		classid=array[0];
		classname=array[1];
		tutorname=array[2];
		startime=Integer.parseInt(array[3]);
		attendance=new int[WEEK];
		
	}

	//method to return the average attendance for the class
	public float returnAverage() {
		int sum=0;
		float avg=0;
		for(int i=0;i<WEEK;i++) {
			sum=sum+attendance[i];
		}
		avg=(float)sum/WEEK;
		return avg;
	}
	
	//method to return a String formatted appropriately for the attendance report 
	public String returnString() {
		String avg=String.format("%.2f",returnAverage());
		String line=getClassid()+"\t"+getClassname()+"\t"+getTutorname()+"\t"+returndata()+"\t"+avg+"\r\n";
		return line;
	}
	
	//method to return the attendance data
	public String returndata() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<WEEK;i++) {
			sb.append(attendance[i]+" ");
		}
		return sb.toString();
	}
	
	//method to compare two Fitness Class objects appropriately on average attendance.
	public int compareTo(FitnessClass other) { 
		if(this.returnAverage()<other.returnAverage()) {
			return 1;}
		else if(this.returnAverage()==other.returnAverage()) { 
			return 0;}
		else 
			return -1;
	    }

	//accessor and mutator(set and get)methods to enable all the instance variables to be accessed and given values
	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getTutorname() {
		return tutorname;
	}

	public void setTutorname(String tutorname) {
		this.tutorname = tutorname;
	}

	public int getStartime() {
		return startime;
	}

	public void setStartime(int startime) {
		this.startime = startime;
	}

	public int[] getAttendance() {
		return attendance;
	}

	public void setAttendance(int[] attendance) {
		this.attendance = attendance;
	}
	

}
