package lab5part1;

import FormatIO.Console;
import FormatIO.FileIn;
import FormatIO.FileOut;

public class part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * open two bank accounts
 */
		Console con=new Console("Lab5");
	
		/**
		 * open two bank accounts
		 * the account1
		 */
		con.print("Open New Bank Account");
		con.print("Please enter the account1 number:");//user is prompted 
		String accountNumber=con.readLine();
		con.print("Please enter the account1 initial balance:");
		Double initialDeposit=con.readDouble();
		
		String filename="account-"+accountNumber+".txt";
		String accountLine=accountNumber+" "+initialDeposit;
		FileOut fout=new FileOut(filename);
		fout.println(accountLine);
		fout.close();
		
		/**
		 * enter the account2
		 */
		con.print("Please enter the account2 number:");//user is prompted 
		accountNumber=con.readLine();
		con.print("Please enter the account2 initial balance:");
		initialDeposit=con.readDouble();
		
		filename="account-"+accountNumber+".txt";
		accountLine=accountNumber+" "+initialDeposit;
		fout=new FileOut(filename);
		fout.println(accountLine);
		fout.close();
		/**
		 * input the months and rental amount per month
		 */
		con.print("Please enter the rental amount per month:￡");
		double rent=con.readDouble();
		con.print("Please enter the months of rental to pay:");
		int month=con.readInt();
		double totalPay=rent*month;// the money needing to pay in total
		con.println(String.format("The total money need to pay:￡ %.2f",totalPay));
		con.print("Please enter the account you choose to pay:");
		accountNumber=con.readLine();
		
		filename="account-"+accountNumber+".txt";
		FileIn fin=new FileIn(filename);
		accountNumber=fin.readWord();
		initialDeposit=fin.readDouble();
		initialDeposit=initialDeposit-totalPay;
		fin.close();
		
	    filename="account-"+accountNumber+".txt";
		accountLine=accountNumber+" "+initialDeposit;
		fout=new FileOut(filename);
		fout.println(accountLine);
		fout.close();  //记住很重要
		
		/**
		 * Transfer some money from one of the bank to another
		 */
		con.print("Please enter the amount of money to transfer: ￡");
		Double transMoney=con.readDouble();
		con.print("Please enter the number of the bank where the money is being transferred from:");
		String transFrom=con.readWord();
	    con.print("Please enter the number of the bank where the money is being transferred to:");
	    String transTo=con.readWord();
	    
	    /**read the information from the transfrom bank
	     * 
	     */
	    filename="account-"+transFrom+".txt";
		fin=new FileIn(filename);
		accountNumber=fin.readWord();
		initialDeposit=fin.readDouble();
		initialDeposit=initialDeposit-transMoney;
		fin.close();
		
		filename="account-"+accountNumber+".txt";
		accountLine=accountNumber+" "+initialDeposit;
		fout=new FileOut(filename);
		fout.println(accountLine);
		fout.close();
		con.println("The balance of the bank is"+initialDeposit);
		
	    
	    /**read the information from the transTo bank
	     * 
	     */
	    filename="account-"+transTo+".txt";
		fin=new FileIn(filename);
		accountNumber=fin.readWord();
		initialDeposit=fin.readDouble();
		initialDeposit=initialDeposit+transMoney;
		fin.close();
		
		
		filename="account-"+transTo+".txt";
		accountLine=accountNumber+" "+initialDeposit;
		fout=new FileOut(filename);
		fout.println(accountLine);
		fout.close();
		con.print("The balance of the bank is"+initialDeposit);
		
		
		/**
		 * create a third bank account which will store currency in dollars
		 */
		con.print("Please enter the name of the third bank: ");
		accountNumber=con.readLine();
		con.print("Please enter the initial balance: ＄ ");
		initialDeposit=con.readDouble();
		filename="account-"+accountNumber+".txt";
		accountLine=accountNumber+" "+initialDeposit;
		fout=new FileOut(filename);
		fout.println(accountLine);
		fout.close();
		
		con.print("\nPlease enter the amount of money to transfer: ￡");
		transMoney=con.readDouble();
		con.print("Please enter the number of the bank where the money is being transferred from:");
		transFrom=con.readWord();
	    con.print("Please enter the number of the bank where the money is being transferred to(Pounds Sterling: ");
	    transTo=con.readWord();
	    
	    filename="account-"+transFrom+".txt";
	  	fin=new FileIn(filename);
	  	accountNumber=fin.readWord();
	  	initialDeposit=fin.readDouble();
	  	initialDeposit=initialDeposit-transMoney-transMoney*0.02;
	  	fin.close();
	  	con.print("The balance of "+transFrom+" is "+initialDeposit);
		
	  	filename="account-"+transTo+".txt";
		fin=new FileIn(filename);
		accountNumber=fin.readWord();
		initialDeposit=fin.readDouble();
		fin.close();
		initialDeposit=initialDeposit+transMoney*1.5;
		con.print("The balance of "+transTo+" is "+initialDeposit);
		
	}	
	   
		
		
		
		
		
	}


