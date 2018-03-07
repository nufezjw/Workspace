import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;

/**
 * Class to define window in which attendance report is displayed.
 */
public class ReportFrame extends JFrame {
	JTextArea report;
	FitnessProgram programObject;
	FitnessClass[] orderedlist;
	//constructor with a FitnessProgram parameter used t initialise the FitnessProgram instance variable and add the JTextArea component to the window 
	public ReportFrame(FitnessProgram fitness) {
		this.programObject=fitness;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,300);
		setTitle("Attendance Report");
		report=new JTextArea();
		this.programObject=fitness;
		this.add(report);
		buildreport();
		this.setVisible(true);
	}
	
	//method to build the report for display on the JTextArea
	public void buildreport() {
		report.append("ID"+"\t"+"Class"+"\t"+"Tutor"+"\t"+"Attendance"+"\t"+"Average Attendance");
		report.append("\r\n");
		report.append("============================================================================");
		report.append("\r\n");
		orderedlist=programObject.returnList();
		for(int i=0;i<programObject.getActualnumber();i++) {
			report.append(orderedlist[i].returnString());
		}
		report.append("\t\t\t\t"+"Overall average:"+programObject.returnOverall());	
	}
}
