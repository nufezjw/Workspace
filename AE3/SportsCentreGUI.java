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

	/** Names of input text files */
	private final String classesInFile = "ClassesIn.txt";
	private final String classesOutFile = "ClassesOut.txt";
	private final String attendancesFile = "AttendancesIn.txt";
	
	
	private FitnessProgram programObject;
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
	
		programObject=new FitnessProgram();
		initLadiesDay();
		initAttendances();
		updateDisplay();//display the main GUI
		
	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 */
	public void initLadiesDay() {
		FileReader fr=null;
		try {
			fr=new FileReader("ClassesIn.txt");
		//	programObject=new FitnessProgram();
			Scanner input=new Scanner(fr);
			String line=null;
			while(input.hasNext()) {
				line=input.nextLine();
				programObject.buildList(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * Initialises the attendances using data
	 * from the file AttendancesIn.txt
	 */
	public void initAttendances() {
		FileReader fr=null;
		try {
			fr=new FileReader("AttendancesIn.txt");
			Scanner input=new Scanner(fr);
			String line=null;
			while(input.hasNext()) {
				line=input.nextLine();
				programObject.popAttendance(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * Instantiates timetable display and adds it to GUI
	 */
	public void updateDisplay() {
		String line="9-10"+"\t"+"10-11"+"\t"+"11-12"+"\t"+"12-13"+"\t"+"13-14"+"\t"+"14-15"+"\t"+"15-16"+"\r\n";
		display.append(line);
		for(int i=0;i<programObject.MAXNUMBER;i++) {
			if(programObject.returnObjectx(i)!=null) {
				display.append(programObject.returnObjectx(i).getClassname());
				display.append("\t");
			}else {
				display.append("Available");
				display.append("\t");
			}
		}
		display.append("\r\n");//change to a new line
		for(int i=0;i<programObject.MAXNUMBER;i++) {
			if(programObject.returnObjectx(i)!=null) {
				display.append(programObject.returnObjectx(i).getTutorname());
				display.append("\t");
			}else{
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
		//get the information about the class 
		String classid=idIn.getText();
		String classname=classIn.getText();
		String tutorname=tutorIn.getText();
		int startime=programObject.returnOpentime();
		int[] attendance= {0,0,0,0,0};
		
		for(int i=0;i<programObject.MAXNUMBER;i++) {
			if(programObject.returnObjectx(i)!=null&&programObject.returnObjectx(i).getClassid().equals(classid)) {
				JOptionPane.showMessageDialog(null, "CLASS HAS EXISTED!", "WARNING", JOptionPane.ERROR_MESSAGE);	
			}
		}
		if(classid.equals("")||classname.equals("")||tutorname.equals("")) {
			JOptionPane.showMessageDialog(null, "PLEASE INPUT VALID DATA!", "WARNING", JOptionPane.ERROR_MESSAGE);
		}else if(startime!=0) {
			programObject.insertObject(classid, classname, tutorname, startime, attendance);
		}else
			JOptionPane.showMessageDialog(null, "THE LIST IS FULL!", "WARNING", JOptionPane.ERROR_MESSAGE);
		display.setText("");
		updateDisplay();
	}

	/**
	 * Processes deleting a class
	 */
	public void processDeletion() {
	    String classid=idIn.getText();
	    if(classid.equals("")) {
	    	JOptionPane.showMessageDialog(null, "PLEASE INPUT VALID DATA!", "WARNING", JOptionPane.ERROR_MESSAGE);
	    }
	    programObject.deleteObject(classid);
		display.setText("");
		updateDisplay();
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() {
		new ReportFrame(programObject);
	}

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() {
		String outline=null;
		FileWriter fw=null;
		try {
			fw=new FileWriter("ClassesOut.txt");
			for(int i=0;i<programObject.MAXNUMBER;i++) {
				if(programObject.returnObjectx(i)!=null) {
					String classid=programObject.returnObjectx(i).getClassid();
					String classname=programObject.returnObjectx(i).getClassname();
					String tutorname=programObject.returnObjectx(i).getTutorname();
					int startime=programObject.returnObjectx(i).getStartime();
					outline=classid+" "+classname+" "+tutorname+" "+startime+"\r\n";
					fw.write(outline);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fw!=null) {
					fw.close();
				}
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		System.exit(0);
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
