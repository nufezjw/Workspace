import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;

import com.sun.javafx.binding.StringFormatter;

/**
 * Class to define window in which attendance report is displayed.
 */
public class ReportFrame extends JFrame {
FitnessProgram fitObject;
JTextArea jtextobject;
public ReportFrame(FitnessProgram fitobject) {
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
	setTitle("Attendance Report");
	setSize(600,220);
	this.fitObject=fitobject;
	jtextobject=new JTextArea();
	this.add(jtextobject);
}
/**
 * method to build the report for display on the JTextArea
 */
public void buidReport() {
	jtextobject.append("  ID\tClass\tTutor\tAttendance\t\tAverage Attendance\r\n");//the title of the report
	jtextobject.append("==============================================================================\r\n");
	FitnessClass[] fit=fitObject.sortList();
	for(int i=0;i<fitObject.returnNumber();i++) {
		if(fit[i]!=null) {
			jtextobject.append(fit[i].attendanceReport());}
	}
	jtextobject.append("\t\t\t\tOverall  average: "+String.format("%.2f",fitObject.avgAttendance()));//add the overall average attendance
	}
}
	