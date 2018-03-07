import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



import java.util.*;
import java.io.*;

/**
 * Defines a GUI that displays details of a FitnessProgram object
 * and contains buttons enabling access to the required functionality.
 */
public class SportsCentreGUI extends JFrame implements ActionListener {
	
	/** GUI JButtons */
	private JButton closeButton, attendanceButton;
	private JButton addButton, deleteButton;

	/** GUI JTextFields */
	private JTextField idIn, classIn, tutorIn;

	/** Display of class timetable */
	private JTextArea display;

	/** Display of attendance information */
	private ReportFrame report;
	
	/** FitnessProgram object*/
	private FitnessProgram fitobject;

	/** Names of input text files */
	private final String classesInFile = "ClassesIn.txt";
	private final String classesOutFile = "ClassesOut.txt";
	private final String attendancesFile = "AttendancesIn.txt";
	private String classId,className,tutorName; //variable to store the value received from the text field
	private boolean operation;
	
	/**
	 * Constructor for AssEx3GUI class
	 */
	public SportsCentreGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Boyd-Orr Sports Centre");
		setSize(700, 300);
		display = new JTextArea();
		display.setFont(new Font("Courier", Font.PLAIN, 14));
		add(display, BorderLayout.CENTER);
		layoutTop();
		layoutBottom();
		initLadiesDay();
		initAttendances();
		updateDisplay();
	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 */
	public void initLadiesDay() {	
		FileReader fr1=null;
		try {
			fitobject=new FitnessProgram();
			fr1=new FileReader("C:\\Users\\Jerry\\eclipse-workspace\\SetupAE3.zip_expanded\\SetupAE3\\ClassesIn.txt");
			Scanner in=new Scanner(fr1);
			String line=null;
			while(in.hasNext()) {
				line=in.nextLine();
				fitobject.orderedList(line);}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//close the FileReader fr1
		try {
			if(fr1!=null)
				fr1.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * Initialises the attendances using data
	 * from the file AttendancesIn.txt
	 */
	public void initAttendances() {
		FileReader fr2=null;
		try {
			fr2 = new FileReader("C:\\Users\\Jerry\\eclipse-workspace\\SetupAE3.zip_expanded\\SetupAE3\\AttendancesIn.txt");
			Scanner in=new Scanner(fr2);
			String line=null;
			while(in.hasNext()) {
				line=in.nextLine();
				fitobject.popAttendList(line);
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//close the FileReader fr2
		try {				
			if(fr2!=null)
				fr2.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * Instantiates timetable display and adds it to GUI
	 */
	public void updateDisplay() {
		String str1=null;
		str1=String.format("%-25s%-25s%-25s%-25s%-25s%-25s%-25s\r\n", "9-10","10-11","11-12","12-13","13-14","14-15","15-16");
		display.append(str1);
		String str2=null;
		String str3=null;
		for(int i=0;i<7;i++) {
			if(fitobject.getFitnessClass(i)!=null) {
				str2=String.format("%-25s", fitobject.getFitnessClass(i).getClassName());
				display.append(str2);
			//	display.append("\t");
		}
			if(fitobject.getFitnessClass(i)==null){
				str3=String.format("%-25s","Available");
				display.append(str3);
			// 	display.append("\t");
		}
	}
		display.append("\r\n");
		for(int j=0;j<7;j++) {
			if(fitobject.getFitnessClass(j)!=null) {
				display.append(fitobject.getFitnessClass(j).getTutorName());
				display.append("\t");
			}
			if(fitobject.getFitnessClass(j)==null){
				display.append("");
				display.append("\t");
			}
		}	
	}

	/**
	 * adds buttons to top of GUI
	 */
	public void layoutTop() {
		JPanel top = new JPanel();
		closeButton = new JButton("Save and Exit");
		closeButton.addActionListener(this);
		top.add(closeButton);
		attendanceButton = new JButton("View Attendances");
		attendanceButton.addActionListener(this);
		top.add(attendanceButton);
		add(top, BorderLayout.NORTH);
	}

	/**
	 * adds labels, text fields and buttons to bottom of GUI
	 */
	public void layoutBottom() {
		// instantiate panel for bottom of display
		JPanel bottom = new JPanel(new GridLayout(3, 3));

		// add upper label, text field and button
		JLabel idLabel = new JLabel("Enter Class Id");
		bottom.add(idLabel);
		idIn = new JTextField();
		bottom.add(idIn);
		JPanel panel1 = new JPanel();
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		panel1.add(addButton);
		bottom.add(panel1);

		// add middle label, text field and button
		JLabel nmeLabel = new JLabel("Enter Class Name");
		bottom.add(nmeLabel);
		classIn = new JTextField();
		bottom.add(classIn);
		JPanel panel2 = new JPanel();
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel2.add(deleteButton);
		bottom.add(panel2);

		// add lower label text field and button
		JLabel tutLabel = new JLabel("Enter Tutor Name");
		bottom.add(tutLabel);
		tutorIn = new JTextField();
		bottom.add(tutorIn);

		add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Processes adding a class
	 */
	public void processAdding() {
		//get the value from the text field and delete the space
		operation=false;
		classId=idIn.getText().trim();  
		className=classIn.getText().trim();
		tutorName=tutorIn.getText().trim();
		for(int i=0;i<fitobject.MAXCLASS;i++) {  //compare the id with the existing id to make sure whether the id has existed
			if(fitobject.getFitnessClass(i)!=null&&fitobject.getFitnessClass(i).getId().equals(classId)) {
					JOptionPane.showMessageDialog(null, "The class has existed!","Warning", JOptionPane.ERROR_MESSAGE);
					operation=true;
			}	
		}
		if(operation==false) {
		int index=fitobject.returnFirstTime()-9;
		if(index<0) {
			JOptionPane.showMessageDialog(null, "The list is full!", "Warning", JOptionPane.ERROR_MESSAGE);
		}else if(classId!=null&&!classId.equals("")&&className!=null&&!className.equals("")&&tutorName!=null&&!tutorName.equals("")) {
			//initialise the instance variables of fitobject
			fitobject.insertObject();
			fitobject.getFitnessClass(index).setId(classId);
			fitobject.getFitnessClass(index).setClassName(className);
			fitobject.getFitnessClass(index).setTutorName(tutorName);
			fitobject.getFitnessClass(index).setStartTime(index+9+"");
			int[] attendances={0,0,0,0,0};
			fitobject.getFitnessClass(index).setAttendance(attendances);
			display.setText("");
			updateDisplay();}
		else
			JOptionPane.showMessageDialog(null, "Please input the valid information!", "Warning", JOptionPane.ERROR_MESSAGE);}
		updateTextfield();
	}

	/**
	 * Processes deleting a class
	 */
	public void processDeletion() {
		operation=false;
		classId=idIn.getText().trim();
		for(int i=0;i<fitobject.MAXCLASS;i++) {
			if(fitobject.getFitnessClass(i)!=null&&fitobject.getFitnessClass(i).getId().equals(classId)) 
				operation=true;
		}
		//check that the user input the valid information
		if(classId==null||classId.equals("")||operation!=true) {
			JOptionPane.showMessageDialog(null, "Please input the correct ClassID!", "Warning", JOptionPane.ERROR_MESSAGE);
		}
		for(int i=0;i<fitobject.MAXCLASS;i++) {
			if(fitobject.getFitnessClass(i)!=null&&fitobject.getFitnessClass(i).getId().equals(classId)) {
				fitobject.deleObject(i);
				display.setText("");
				updateDisplay();
			}
		}
		updateTextfield();
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() {
		report=new ReportFrame(fitobject);  //initialize the object
		report.buidReport(); //use the buildreport() method to display the report
		report.setVisible(true);
	}

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() {
		PrintWriter pw = null;
		try {
			pw=new PrintWriter("C:\\Users\\Jerry\\eclipse-workspace\\SetupAE3.zip_expanded\\SetupAE3\\ClassesOut.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i=0;i<fitobject.MAXCLASS;i++) {
			if(fitobject.getFitnessClass(i)!=null) {
			String line=fitobject.getFitnessClass(i).getId()+" "+fitobject.getFitnessClass(i).getClassName()+" "+fitobject.getFitnessClass(i).getTutorName()+" "+fitobject.getFitnessClass(i).getStartTime();
			pw.println(line);
			}
		}
		try {				//close the PrintWriter
			if(pw!=null)
				pw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * Method to clear the text field
	 */
	public void updateTextfield() {
		idIn.setText("");
		classIn.setText("");
		tutorIn.setText("");
	}
	
	/**
	 * Process button clicks.
	 * @param ae the ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==attendanceButton) {
			displayReport();
		}
		if(ae.getSource()==addButton) {
			processAdding();
		}
		if(ae.getSource()==deleteButton) {
			processDeletion();
		}
		if(ae.getSource()==closeButton) {
			processSaveAndClose();
		}
	}	
}
