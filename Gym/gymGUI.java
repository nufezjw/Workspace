import java.sql.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class gymGUI extends JFrame implements ActionListener{
	//Components are used for the GUI 
	private JComboBox courseListCombo;           
	private JLabel memberlabel,titlelabel,welcomelabel;
	private JTextField membertext;
	private JButton viewButton,bookButton,allCourseButton;
	private JPanel panel1,panel2,panel3;
	private JTable table1,table2;
	private JScrollPane scrollpane1,scrollpane2;
	private dataBaseInteraction interaction;

	//the constructor
	public gymGUI(dataBaseInteraction interaction) {
		this.interaction=interaction;
		interaction.getConnection();  //Connect to the DataBase 
		//	this.interaction=interaction;
		setTitle("Gym");
		// add the event for the close of the window, when the window is closed, then the connection to database should be closed too.	
		addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			interaction.closeConnection();
			 }  
		});   
		setSize(600, 400);
		setLocation(100,100);

		//use ArrayList to store the values got from the database
		ArrayList<String> list=new ArrayList<String>();
		try {
			ResultSet rs1=interaction.executeMethod("select CourseName from gym.course");

			while(rs1.next()) {
				list.add(rs1.getString("CourseName"));
			}
			String[] courseList = (String[])list.toArray(new String[0]) ;
			courseListCombo=new JComboBox(courseList);  // give the values to the drop-down menu	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//instantiate the objects 
		memberlabel=new JLabel("MemberID");
		titlelabel=new JLabel("Gym Management System");
		titlelabel.setFont(new Font("Times New Roman",Font.BOLD,32));
		welcomelabel=new JLabel("Welcome!");
		welcomelabel.setFont(new Font("Times New Roman",Font.BOLD,40));
		membertext=new JTextField(10);
		viewButton=new JButton("View");
		bookButton=new JButton("Book");
		allCourseButton=new JButton("View all courses");
		allCourseButton.addActionListener(this);
		viewButton.addActionListener(this);
		bookButton.addActionListener(this);
		
		//add the components to the panel1
		panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(courseListCombo);
		panel1.add(viewButton);
		panel1.add(memberlabel);
		panel1.add(membertext);
		panel1.add(bookButton);
		panel1.add(allCourseButton);
		
		panel2=new JPanel();
		panel2.add(welcomelabel);
		panel3=new JPanel();
		panel3.add(titlelabel);		
		//add the panels to the frame
		this.add(panel1,BorderLayout.SOUTH);
		this.add(panel2,BorderLayout.CENTER);
		this.add(panel3,BorderLayout.NORTH);
		this.setVisible(true);		
	}

	/* Method tablepaint1 is used to display  all courses and 
	 * the instructor taking them, the capacity of the course, and the number of
	 *	members currently booked on the course
	 * 
	 */
	public void tablepaint1() {
		String[] col= {"CourseName", "InstructorName", "MaxPlaces", "Current number"};
		DefaultTableModel mm=new DefaultTableModel(col,0)//define a module for table and set the columns not editable
		{
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		try {
			ResultSet rs=interaction.executeMethod("SELECT Course.CourseName,Instructor.Name,Course.MaxPlaces,COUNT(MemberCourse.MembershipNumber)  \r\n" + 
					"FROM gym.Course INNER JOIN gym.Instructor ON (Course.InstructorNumber=Instructor.InstructorNumber)\r\n" + 
					"LEFT JOIN gym.MemberCourse ON (Course.ID=MemberCourse.ID) GROUP BY Course.CourseName,Instructor.Name,Course.MaxPlaces;\r\n" + 
					"\r\n" + "");
		while(rs.next()) {
			String coursename=rs.getString("CourseName");
			String membername=rs.getString("Name");
			String maxplaces=rs.getString("MaxPlaces");
			String bookednumber=rs.getString("Count");
		//	String name=rs.getString("CourseName");
		//	String instructornumber=rs.getString("InstructorNumber");
			String []str_row= {coursename,membername,maxplaces,bookednumber};
			mm.addRow(str_row);
		}}catch(SQLException e) {
				e.printStackTrace();
		}
		table1=new JTable(mm);
		TableColumn c1= table1.getColumnModel().getColumn(3);
		c1.setPreferredWidth(130);
		scrollpane1=new JScrollPane(table1);
		panel2.add(scrollpane1);
		}	
	
	/*the table to show  all members booked on a course 
	 * i.e. member full name and ID and the name of the course for
		each course in your database*/		
	public void tablepaint2() {
		String courseChosen=courseListCombo.getSelectedItem().toString();
		String[] col1= {"MemberName", "CourseID","CourseName"};
		DefaultTableModel mm1=new DefaultTableModel(col1,0)//define a module for table and set the columns not editable
		{
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		try {
			ResultSet rs=interaction.executeMethod("SELECT Member.Name,Course.ID,Course.CourseName FROM gym.Course INNER JOIN gym.MemberCourse \r\n" + 
					"ON Course.ID=MemberCourse.ID INNER JOIN gym.Member ON MemberCourse.MembershipNumber=Member.MembershipNumber WHERE Course.CourseName='"+courseChosen+"'\r\n" + 
					"");
		while(rs.next()) {
			String membername=rs.getString("Name");
			String courseID=rs.getString("ID");
			String courseName=rs.getString("CourseName");	
			String[] str_row= {membername,courseID,courseName};
			mm1.addRow(str_row);
		}
	}catch(SQLException e1){
		e1.printStackTrace();
		}
		table2=new JTable(mm1);
		scrollpane2=new JScrollPane(table2);
		panel2.add(scrollpane2);
	}
	
	//Method to check the current number is less than the max Capacity
	public boolean checkCapacity(String chosenCourse) {
	int maxplaces=0;
	int currentNumber=0; 
	try {
		ResultSet rs=interaction.executeMethod("SELECT Course.CourseName,Instructor.Name,Course.MaxPlaces,COUNT(MemberCourse.MembershipNumber)  \r\n" + 
				"FROM gym.Course INNER JOIN gym.Instructor ON (Course.InstructorNumber=Instructor.InstructorNumber)\r\n" + 
				"LEFT JOIN gym.MemberCourse ON (Course.ID=MemberCourse.ID) WHERE Course.CourseName='"+chosenCourse+"' GROUP BY Course.CourseName,Instructor.Name,Course.MaxPlaces;");
	while(rs.next()) {
		maxplaces=Integer.parseInt(rs.getString("MaxPlaces"));
		currentNumber=Integer.parseInt(rs.getString("count"));
	}
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	if(currentNumber<maxplaces) {
		return true;
	}else
		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		String id=null;
		if(e.getSource()==allCourseButton) {
			panel2.removeAll();
			tablepaint1();
		//	this.add("Center", scrollpane1);
			this.setVisible(true);
		//	scrollpane.revalidate();	
		}
		if(e.getSource()==viewButton) {
			panel2.removeAll();
			tablepaint2();
		//	this.add("Center", scrollpane2);
			this.setVisible(true);
		//	scrollpane.revalidate();	
		}
		if(e.getSource()==bookButton) {
			String courseChosen=courseListCombo.getSelectedItem().toString();
			String memberID=membertext.getText();
			//store the membershipNumbers to ArrayList list
			ArrayList<String> list=new ArrayList<String>();
			ArrayList<String> list1=new ArrayList<String>();
			try {
				ResultSet rs=interaction.executeMethod("select MembershipNumber from gym.Member");
				while(rs.next()) {
					list.add(rs.getString("MembershipNumber"));}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			/*check whether the memberID input by the administrator exists
			 * if the memberId does not exist, a MessageDialog should be displayed to inform the user
			 */
			if(!list.contains(memberID)) {
				JOptionPane.showMessageDialog(null, "The member ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
				membertext.setText("");
			}
			//if the memeberID exists, then execute the method to insert the memebershipNumber and courseID into the table MemberCourse
			if(memberID!=null&&memberID!=""&&list.contains(memberID)) {
			try{
			ResultSet rs1=interaction.executeMethod("SELECT Course.ID FROM gym.Course WHERE Course.CourseName='"+courseChosen+"'");
			while(rs1.next()){
			id=rs1.getString("ID");}
			ResultSet rs2=interaction.executeMethod("SELECT MembershipNumber FROM gym.MemberCourse WHERE ID='"+id+"'");
			while(rs2.next()) {
				list1.add(rs2.getString("MembershipNumber"));
			}
			if(list1.contains(memberID)) {
				JOptionPane.showMessageDialog(null, "The member has booked the course!", "Error", JOptionPane.ERROR_MESSAGE);
				membertext.setText("");}
			else if(checkCapacity(courseChosen)) {
				interaction.executeMethod1("INSERT INTO gym.MemberCourse VALUES("+memberID+","+id+")");
				JOptionPane.showMessageDialog(null, "Book successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);}
			else 
				JOptionPane.showMessageDialog(null, "The course is full!", "Information", JOptionPane.INFORMATION_MESSAGE);
			
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			}
			}		
		}
		
	}
	

