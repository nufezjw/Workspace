/**
 * CourseName:Programming
 * courseworkNumber:1
 * StudentID:2301457Z
 * StudentName:ZHOU,JIANWEN
 */
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class AssEx1 {
public static void main(String[] args) throws Exception {
	String cusName=JOptionPane.showInputDialog(null,"Please enter the customer's name: ","Name", JOptionPane.INFORMATION_MESSAGE).trim();//get the name of the customer through the InputDialog
	if(cusName==null||cusName.equals(""))    //If the name of the customer is empty, the program should terminate.   
    	 System.exit(0);
    else {
    	if(cusName!=null)
//Ask the user to input the valid balance.This should continue until the balance has been entered correctly
    		while(true) { 
    			try {
    				String balance=JOptionPane.showInputDialog(null,"Please enter the initial balance:","Balance", JOptionPane.INFORMATION_MESSAGE);
    				if(balance!=null) {
    				double	iniBalance=Double.parseDouble(balance);
    				CustomerAccount customer=new CustomerAccount(cusName,iniBalance);//create a CustomerAccount object to get the name and initial balance from the input dialog
    				LWMGUI gui=new LWMGUI(customer);
    				gui.setVisible(true);    }           
    				break;
    			}catch(NumberFormatException e) { //deal with the NumberFormatException(the input is not a number)
    				JOptionPane.showMessageDialog(null, "Please input the valid number!","Warning", JOptionPane.ERROR_MESSAGE);
    				continue;
    				}   
    			}
			}
		}
	}
