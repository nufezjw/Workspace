
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LWMGUI extends JFrame implements ActionListener{
private JTextField nameField,quantityField,priceField,tranField,balField;
private JLabel nameLabel,quantityLabel,priceLabel,purLabel,tranLabel,balLabel;
private JButton saButton,reButton;
private final float SECHARGE=0.2f;
//CustomerAccount customerObject;
CustomerAccount customerObject;

//constructor
public LWMGUI(CustomerAccount customer) {	
	customerObject=customer;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Lilybank Wine Merchant��"+customerObject.getCusName());
	setSize(600,200);
	setLocation(100,100);
	setLayout(new GridLayout(4,1));
	layoutComponents();	
}

//layoutComponents Method,the layout will be divided into four parts from top to bottom through panels
private void layoutComponents() {
	//First part of the GUI(top)
	JPanel panel1=new JPanel();
	nameLabel=new JLabel("Name��"); 
	quantityLabel=new JLabel("Quantity:");
	priceLabel=new JLabel("Price:��");
	nameField=new JTextField(10);
	quantityField=new JTextField(8);
	priceField=new JTextField(8);
	panel1.add(nameLabel);
	panel1.add(nameField);
	panel1.add(quantityLabel);
	panel1.add(quantityField);
	panel1.add(priceLabel);
	panel1.add(priceField);
	this.add(panel1);
	
	//second part of the GUI
	JPanel panel2=new JPanel();
	saButton=new JButton("Process Sale");
	reButton=new JButton("Process Return");
	panel2.add(saButton);
	panel2.add(reButton);
	this.add(panel2);
	
	saButton.addActionListener(this);
	reButton.addActionListener(this);
	
	
	//Third part of the GUI
	JPanel panel3=new JPanel();
	panel3.setLayout(new FlowLayout(FlowLayout.LEFT)); //set the way of alignment
	purLabel=new JLabel("");
	panel3.add(purLabel);
	this.add(panel3);
	
	
	//Bottom part of the GUI
	JPanel panel4=new JPanel();
	tranLabel=new JLabel("Amount of Transaction:");
	tranField=new JTextField(8);
	tranField.setEditable(false);
	balLabel=new JLabel("Current balance:");
	balField=new JTextField(8);
	if(customerObject.getCurBalance()>=0) {
	balField.setText(String.format("%.2f",customerObject.getCurBalance())+"");
	}else
		balField.setText(String.format("%.2f",Math.abs(customerObject.getCurBalance()))+"CR");
	balField.setEditable(false);
	
	panel4.add(tranLabel);
	panel4.add(tranField);
	panel4.add(balLabel);
	panel4.add(balField);
	this.add(panel4);
}

//a single method to create a wineObject(get the information about wine from the three text fields              
public Wine getWineInfo() {
	String wineName=nameField.getText();
	String squantity=quantityField.getText();
	String swinePrice=priceField.getText();
	if(wineName!=null&&squantity!=null&&swinePrice!=null) {
		try {
			int quantity=Integer.parseInt(squantity);//translate the String quantity to int
			double winePrice=Double.parseDouble(swinePrice);//translate the String price to double
			if(!wineName.equals("")&&quantity>=0&&winePrice>0) {//ensure the valid information
				Wine wineObject=new Wine(wineName,quantity,winePrice);
				return wineObject;}
			else
				JOptionPane.showMessageDialog(null, "Please input the valid information!","Warning",JOptionPane.ERROR_MESSAGE);
				resetTextField();
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please input the valid information!","Warning",JOptionPane.ERROR_MESSAGE);
			resetTextField();
		}
	}return null;}
				
//the method to process the sale
public  double sellMethod(Wine wineObject) {
	double sellTransaction=wineObject.getQuantity()*wineObject.getWinePrice();
	return sellTransaction;	
}

public  double returnMethod(Wine wineObject) {
	double reTransaction=wineObject.getQuantity()*wineObject.getWinePrice()*(1-SECHARGE);//number of bottles *cost of one bottle*(1-service charge )
	return reTransaction;	
}

//method to clear the text field
public void resetTextField() {
	nameField.setText("");
	quantityField.setText("");
	priceField.setText("");
}

//actionPerformed Method to deal with events
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==saButton&&getWineInfo()!=null) {	//to make sure wineObject exists
		purLabel.setText("Wine purchased: "+getWineInfo().getWineName());
		double sale=sellMethod(getWineInfo());
		String fmsale=String.format("%.2f",sale);
		tranField.setText(fmsale);
		resetTextField();
		String balance=customerObject.addCurBalance(sale);
		balField.setText(balance);
	}
	if(e.getSource()==reButton&&getWineInfo()!=null) {
		//resetTextField();
		purLabel.setText("Wine returned: "+getWineInfo().getWineName());
		double back=returnMethod(getWineInfo());
		String fmback=String.format("%.2f", back);//try to format the number(remain two decimal fraction)
	//	DecimalFormat df=new DecimalFormat("#.##");   //another way to deal with the format
		tranField.setText(fmback);
		resetTextField();		
		String balance=customerObject.minCurBalance(back);
		balField.setText(balance);
			
	}
}
}
