package javaball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javaball.controller.JavaBallController;
import javaball.model.Referee;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;


public class JavaBallGUI extends JFrame implements ActionListener {
	/** JFrame and spacing dimensions in pixels */
	private static final int WIDTH = 1000, HEIGHT = 600, SPACING = 15;

	/** Predefined set of colours for uniform component colouring */
//	private final Color background = Color.GRAY,
	//		header = Color.BLUE;

	/** Reference to the JavaBallController */
	private final JavaBallController controller;

	/** Default strings within GUI */
	private final String defaultSearch = "Please Enter name or ID...";
	private final String defaultTableHeader = "Referees Table";

	/** Main/interactive GUI components */
	private JTextField fldSearch;
	private JLabel lblTableHeader;
	private JButton btnSearch, btnShowAll, btnAddRef, btnAllocRefs, btnChart,
			btnSaveExit;
	
	/** JTable to store the referee listing */
	private JTable refereesTable;

	/**
	 * Constructor for JavaBallGUI
	 * @param controller
	 */
	public JavaBallGUI(JavaBallController controller) {
		// Store reference to JavaBallController
		this.controller = controller;

		// Set JFrame properties
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("JavaBallSystem");
		setSize(WIDTH, HEIGHT);
		// Create and add GUI components to JFrame
		layoutHeader();
		layoutNavigation();
		layoutContent();
		
		// Make buttons and text field responsive to user input
		addActionListeners();
	}
 
	/**
	 * Creates and lays out the header components
	 */
	private void layoutHeader() {
		// Create JPanels
		JPanel headerPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		JPanel headerTextPanel = new JPanel();
		
		// Set JPanel layouts/properties
		headerPanel.setLayout(new BorderLayout(0,0));
		headerTextPanel.setLayout(new BoxLayout(headerTextPanel,
				BoxLayout.X_AXIS));
		/*headerPanel.setBackground(header);
		searchPanel.setBackground(header);
		headerTextPanel.setBackground(header);*/
		
		// Set searchPanel to use a FlowLayout
		FlowLayout flowLayout = (FlowLayout) searchPanel.getLayout();
		flowLayout.setVgap(SPACING *2);
		
		// Create search field and set its properties
		fldSearch = new JTextField();
		fldSearch.setText(defaultSearch);
		fldSearch.setColumns(16);
		
		// Create header labels
		JLabel lblHeader = new JLabel("JavaBall Referee Allocation System");
		//JLabel lblSubHeader = new JLabel("Referee Allocation System");
		
		// Set header labels properties
	//	lblHeader.setForeground(Color.WHITE);
	//	lblSubHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Dialog", Font.BOLD, 40));

		
		// Create search button
		btnSearch = new JButton("Search");
		
		
		// Add header to GUI frame
		getContentPane().add(headerPanel, BorderLayout.NORTH);
		
		// Add header components
		headerPanel.add(searchPanel, BorderLayout.EAST);
	
		headerPanel.add(headerTextPanel, BorderLayout.WEST);
		
		// Add search components
		searchPanel.add(fldSearch);
		searchPanel.add(btnSearch);
		
		// Add header title components
		headerTextPanel.add(lblHeader);

	}
	
	/**
	 * Creates and lays out the navigation components
	 */
	private void layoutNavigation() {
		// Create JPanels
		JPanel navPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		// Set JPanel layouts/properties
		navPanel.setLayout(new BorderLayout(0, 0));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	//	navPanel.setBackground(background);
	//.setBackground(background);
		
		
		
		// Create buttons
		btnAddRef = new JButton("Add Referee");
		btnAllocRefs = new JButton("Allocate Referees");
		btnChart = new JButton("Show Chart");
		
		btnSaveExit = new JButton("Exit");
		
		// Create spacing components
		Component navBtnSpacerTop = Box.createVerticalStrut(SPACING);
		Component navBtnSpacerSecond = Box.createVerticalStrut(SPACING);
		Component navBtnSpacerMiddle = Box.createVerticalStrut(SPACING);
		Component navBtnSpacerBottom = Box.createVerticalStrut(SPACING);
		Component navBtnGlueBottom = Box.createVerticalGlue();
		Component navSpacerLeft = Box.createHorizontalStrut(SPACING);
		Component navSpacerRight = Box.createHorizontalStrut(SPACING);
		Component navSpacerTop = Box.createVerticalStrut(SPACING);
		Component navSpacerBottom = Box.createVerticalStrut(SPACING);
		
		// Add navigation to GUI frame
		getContentPane().add(navPanel, BorderLayout.EAST);

		// Add navigation components
		navPanel.add(buttonPanel, BorderLayout.CENTER);
		navPanel.add(navSpacerLeft, BorderLayout.WEST);
		navPanel.add(navSpacerRight, BorderLayout.EAST);
		navPanel.add(navSpacerTop, BorderLayout.NORTH);
		navPanel.add(navSpacerBottom, BorderLayout.SOUTH);
		
		// Add button components

		buttonPanel.add(navBtnSpacerTop);
		buttonPanel.add(btnAddRef);
		buttonPanel.add(navBtnSpacerSecond);

		buttonPanel.add(navBtnSpacerMiddle);
		buttonPanel.add(btnAllocRefs);
		buttonPanel.add(navBtnSpacerBottom);
		buttonPanel.add(navBtnSpacerMiddle);
		buttonPanel.add(btnChart);
		buttonPanel.add(navBtnGlueBottom);
		buttonPanel.add(navBtnSpacerMiddle);
		buttonPanel.add(btnSaveExit);
	}
	
	/**
	 * Creates and lays out the content (referee table) components
	 */
	private void layoutContent() {
		// Create JPanels
		JPanel contentPanel = new JPanel();
		JPanel tableHeaderPanel = new JPanel();
		JPanel tableResetPanel = new JPanel();
		
		// Set JPanel layouts/properties
		contentPanel.setLayout(new BorderLayout(0, 0));
		tableHeaderPanel.setLayout(new BorderLayout(0, 0));
		tableResetPanel.setLayout(new BoxLayout(tableResetPanel,
				BoxLayout.X_AXIS));
		
		// Create table header label and set its properties
		lblTableHeader = new JLabel(defaultTableHeader);
		lblTableHeader.setFont(new Font("Dialog",Font.BOLD,20));
		lblTableHeader.setVerticalAlignment(SwingConstants.BOTTOM);
		
		// Create reset button and set its properties
		btnShowAll = new JButton("Reset");
		
		btnShowAll.setFont(new Font("Dialog", Font.BOLD, 20));

		btnShowAll.setEnabled(false);
		
		// Create spacing components
		Component tableHeaderSpacerLeft = Box.createHorizontalStrut(SPACING);
		Component tableHeaderSpacerBottom = Box.createVerticalStrut(SPACING);
		Component tableHeaderSpacerTop = Box.createVerticalStrut(SPACING);
		Component tableSpacerLeft = Box.createHorizontalStrut(SPACING);
		Component tableSpacerRight = Box.createHorizontalStrut(SPACING);
		Component tableSpacerBottom = Box.createVerticalStrut(SPACING);
		// One pixel offset to align show all button with table border
		Component tableHeaderSpacerRight = Box
				.createHorizontalStrut(SPACING + 1);
		
		// Create table to display referee listing and set its properties
		refereesTable = controller.getTable();
		refereesTable.setBackground(UIManager.getColor("menu"));
		refereesTable.setAutoCreateRowSorter(true);
		refereesTable.setBorder(null);
		refereesTable.setShowVerticalLines(false);
		refereesTable.setRowSelectionAllowed(false);
		refereesTable.setFont(new Font("Dialog", Font.PLAIN, 14));
		refereesTable.setForeground(Color.BLUE);

		// Create and apply table layout
		DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
		leftRender.setHorizontalAlignment(JLabel.LEFT);
		refereesTable.getColumnModel().getColumn(4).setCellRenderer(leftRender);
		refereesTable.setSize(contentPanel.getWidth(),
				contentPanel.getHeight());
		
		// Create wrapper JScrollPanel to host the table
		JScrollPane tablePane = new JScrollPane(refereesTable);
		
		// Add content to GUI frame
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		// Add table components
		contentPanel.add(tablePane, BorderLayout.CENTER); // Table added
		contentPanel.add(tableHeaderPanel, BorderLayout.NORTH);
		contentPanel.add(tableSpacerLeft, BorderLayout.WEST);
		contentPanel.add(tableSpacerRight, BorderLayout.EAST);
		contentPanel.add(tableSpacerBottom, BorderLayout.SOUTH);
		
		// Add table header components
		tableHeaderPanel.add(lblTableHeader, BorderLayout.CENTER);
		tableHeaderPanel.add(tableResetPanel, BorderLayout.EAST);
		tableHeaderPanel.add(tableHeaderSpacerLeft, BorderLayout.WEST);
		tableHeaderPanel.add(tableHeaderSpacerBottom, BorderLayout.SOUTH);
		tableHeaderPanel.add(tableHeaderSpacerTop, BorderLayout.NORTH);

		// Add table reset components
		tableResetPanel.add(btnShowAll);
		tableResetPanel.add(tableHeaderSpacerRight);
	}
	
	
	/**
	 * Adds ActionListeners to make the GUI responsive to user interaction
	 */
	private void addActionListeners() {
		// add listeners to JButtons
		btnSearch.addActionListener(this);
		btnShowAll.addActionListener(this);
		btnAddRef.addActionListener(this);
	
		btnAllocRefs.addActionListener(this);
		btnChart.addActionListener(this);
		btnSaveExit.addActionListener(this);

		// Clear the search text field if mouse cursor enters the field
		fldSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (fldSearch.getText().equals(defaultSearch)) {
					fldSearch.setText("");
				}
			}
		});
	}

	/**
	 * Starts appropriate responses upon user interaction
	 * @param ae the action event
	 */
	public void actionPerformed(ActionEvent ae) {
		// Check which button has been pressed
		if (ae.getSource() == btnAddRef)
			// Open referee adding frame upon add button
			addReferee();
		
		else if (ae.getSource() == btnAllocRefs)
			// Open allocation frame upon allocation button
			allocateReferees();
		else if (ae.getSource() == btnChart)
			// Open chart frame upon chart button
			controller.openChart();
		else if (ae.getSource() == btnSearch)
			 // Search for desired referee upon search button
			searchReferee();
		else if (ae.getSource() == btnShowAll)
			// Update referee table upon show all button
			controller.updateTable();
		else if (ae.getSource() == btnSaveExit)
			// Exit programme upon save and exit button
			controller.saveExit();
	}
	
	/** Opens a referee adding frame */
	private void addReferee() {
		RefereeFrame addRef = new RefereeFrame(controller);
		addRef.setTitle("Add Referee");
		addRef.setVisible(true);
	}
	
	/** Opens an allocation frame */
	private void allocateReferees() {
		AllocationFrame allocateRef = new AllocationFrame(controller);
		allocateRef.setVisible(true);
	}
	
	/**
	 * Initiate the search for a referee given the search field input and open a
	 * referee frame with the referee's details
	 */
	private void searchReferee() {
		// Retrieve user input in search field
		String refInfo = fldSearch.getText().toLowerCase().trim();
		
		// Retrieve referee upon provided search query
		Referee ref = controller.getReferee(refInfo);
		
		// Check if referee is existent
		if (ref != null) {
			// Open referee frame with a given referee
			RefereeFrame editRef = new RefereeFrame(controller, ref);
			editRef.setVisible(true);
			editRef.setTitle("Edit Referee");
			
			// Reset the search field to default text
			fldSearch.setText(defaultSearch);
		} else {
			// Otherwise show error that referee could not be found and reset
			// the search field to default text
			JOptionPane.showMessageDialog(null, "Referee not found.");
			fldSearch.setText(defaultSearch);
		}
	}

	/**
	 * Sets the table header to a given String and activates the show all button
	 * @param label the table header to be displayed
	 */
	public void setTableHeader(String label) {
		btnShowAll.setEnabled(true);
		lblTableHeader.setText(label);
	}

	/**
	 * Resets the table header to its default state (default text and enable
	 * disable show all button)
	 */
	public void resetTableHeader() {
		lblTableHeader.setText(defaultTableHeader);
		btnShowAll.setEnabled(false);
	}
}