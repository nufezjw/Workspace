
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/** 
 * Programming AE2
 * Class to display cipher GUI and listen for events
 */
public class CipherGUI extends JFrame implements ActionListener
{
	//instance variables which are the components
	private JPanel top, bottom, middle;
	private JButton monoButton, vigenereButton;
	private JTextField keyField, messageField;
	private JLabel keyLabel, messageLabel;

	//application instance variables
	//including the 'core' part of the text file filename
	//some way of indicating whether encoding or decoding is to be done
	private MonoCipher mcipher;
	private VCipher vcipher;
	private LetterFrequencies frequency; 
	String filename; //string to record the filename
	PrintWriter writer1=null;//writer1 is used for the first output file
	PrintWriter writer2=null;//writer2 is used for the second output file(frequency report)
	private char c;//record the character read from the file
	
	/**
	 * The constructor adds all the components to the frame
	 */
	public CipherGUI()
	{
		this.setSize(400,150);
		this.setLocation(100,100);
		this.setTitle("Cipher GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.layoutComponents();
	}

	/**
	 * Helper method to add components to the frame
	 */
	public void layoutComponents()
	{
		//top panel is yellow and contains a text field of 10 characters
		top = new JPanel();
		top.setBackground(Color.yellow);
		keyLabel = new JLabel("Keyword : ");
		top.add(keyLabel);
		keyField = new JTextField(10);
		top.add(keyField);
		this.add(top,BorderLayout.NORTH);
		
		//middle panel is yellow and contains a text field of 10 characters
		middle = new JPanel();
		middle.setBackground(Color.yellow);
		messageLabel = new JLabel("Message file : ");
		middle.add(messageLabel);
		messageField = new JTextField(10);
		middle.add(messageField);
		this.add(middle,BorderLayout.CENTER);
		
		//bottom panel is green and contains 2 buttons	
		bottom = new JPanel();
		bottom.setBackground(Color.green);
		//create mono button and add it to the top panel
		monoButton = new JButton("Process Mono Cipher");
		monoButton.addActionListener(this);
		bottom.add(monoButton);
		//create vigenere button and add it to the top panel
		vigenereButton = new JButton("Process Vigenere Cipher");
		vigenereButton.addActionListener(this);
		bottom.add(vigenereButton);
		//add the top panel
		this.add(bottom,BorderLayout.SOUTH);
	}
	
	/**
	 * Listen for and react to button press events
	 * (use helper methods below)
	 * @param e the event
	 */
	public void actionPerformed(ActionEvent e)
	{
	    if(e.getSource()==monoButton) {
	    	//parameter is used to identify the kind of encoding, false means MonoCipher
	    	processFile(false);
	    }
	    if(e.getSource()==vigenereButton) {
	    	processFile(true);//true means VCipher
	    }
	}
	
	/** 
	 * Obtains cipher keyword
	 * If the keyword is invalid, a message is produced
	 * @return whether a valid keyword was entered
	 */
	private boolean getKeyword()
	{
	    String keyword=keyField.getText(); 		
	    if(keyword==null||keyword.isEmpty()) {//keyword cannot be null or empty
	    	return false;}
	    for(int i=0;i<keyword.length();i++) {
	    	char e=keyword.charAt(i);
	/*That is, it should be non-empty, and should contain only 
	 * upper-case letters of the alphabet with no repeated character.
	 */
	    if(!Character.isAlphabetic(e)||keyword.indexOf(e)!=keyword.lastIndexOf(e)||!Character.isUpperCase(e)){
	    		return false;
	    	}
	    }
	    mcipher=new MonoCipher(keyword);//instantiate the object
	    vcipher=new VCipher(keyword);
	    return true;	
	    }		
	/** 
	 * Obtains filename from GUI
	 * The details of the filename and the type of coding are extracted
	 * If the filename is invalid, a message is produced 
	 * The details obtained from the filename must be remembered
	 * @return whether a valid filename was entered
	 */
	private boolean processFileName()
	{
		filename=messageField.getText();   //obtain filename from text field
		//the filename cannot be empty and it must end with 'P' or 'C'
		if(filename==null||filename.isEmpty()||(!filename.endsWith("P")&&!filename.endsWith("C"))) {
			return false;
		}
		return true;
	}
		
	/** 
	 * Reads the input text file character by character
	 * Each character is encoded or decoded as appropriate
	 * and written to the output text file
	 * @param vigenere whether the encoding is Vigenere (true) or Mono (false)
	 * @return whether the I/O operations were successful
	 */	
	private boolean processFile(boolean vigenere)
	{
		FileReader fr=null;
		frequency=new LetterFrequencies();
	    try {
	    	try {
	    		if(!getKeyword()||!processFileName()) {
	    			JOptionPane.showMessageDialog(null, "Please input valid information!");
	    			updateTextfield();
	    		}
	    		else if(getKeyword()&&processFileName()) {	    				
	    			fr=new FileReader(messageField.getText()+".txt"); 
	    			if(filename.endsWith("P")) {
	    				//create the file for outputting the contents(create the output filename)
						writer1=new PrintWriter(filename.substring(0, filename.length()-1)+"C.txt"); } 
	    			if(filename.endsWith("C")) {
	    				writer1=new PrintWriter(filename.substring(0, filename.length()-1)+"D.txt");
	    			}	
	    			boolean done=false;
	    				while(!done) {
	    					int next=fr.read();
	    					if(next==-1)
	    						done=true;
	    					else {
	    						c=(char)next;
	    						process(vigenere,filename.charAt(filename.length()-1));
	    						}	
	    				}
	    	    writer2=new PrintWriter(filename.substring(0, filename.length()-1)+"F.txt");
	    		writer2.print(frequency.getReport());//output the frequency report
	    		return true;
	    		}	
	    	}finally {
	    		//close the object
	    		if(fr!=null)
	    			fr.close();
	    		if(writer1!=null)
	    			writer1.close();
	    		if(writer2!=null)
	    			writer2.close();
	    		}    	
	    }catch(IOException e) {
	    	JOptionPane.showMessageDialog(null, "File cannot be found!", "Error",JOptionPane.WARNING_MESSAGE);
	    	messageField.setText("");
	    	System.out.println("Error opening the file!");
	    	return false;
	    	}
		return true;
	}
	
	/**
	 * Method 'process' is used to indicate whether encoding or decoding is to be done and which kind 
	 * of encryption is to be used 
	 * @param vigenere
	 * @param end
	 */
	private void process(boolean vigenere,char end) {
		if(vigenere==false&&end=='P') {
			char cipherchar=mcipher.encode(c);
			writer1.print(cipherchar); 
			frequency.addChar(cipherchar);
		}
		else if(vigenere==false&&end=='C') {
			char cipherchar=mcipher.decode(c);
			writer1.print(cipherchar); 
			frequency.addChar(cipherchar);
		}
		else if(vigenere==true&&end=='P') {
			char cipherchar=vcipher.encode(c);
			writer1.print(cipherchar); 
			frequency.addChar(cipherchar);
		}
		else if(vigenere==true&&end=='C') {
			char cipherchar=vcipher.decode(c);
			writer1.print(cipherchar); 
			frequency.addChar(cipherchar);
		}
	}

	/**
	 * the method to clear the text field
	 */
	private void updateTextfield() {
		keyField.setText("");
		messageField.setText("");
	}
}
