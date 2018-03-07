import FormatIO.*;

public class BankProject 
{
	public static void main(String [] arg)
	{
		//define obj and var
		Console conBank = new Console("Bank Account Example");
		boolean repeater = true;
		
		int monthsRent = 0;
		
		double initalBalance = 0;
		double initalBalanceTwo = 0;
		double currentBalance = 0;
		double currentBalanceTwo = 0;
		double withdrawAmount = 0;
		double depositAmount = 0;
		double rentalAmount = 0;
		double totalRent = 0;
		double transferAmount = 0;
		
		String tempBankInfo = "";
		String userAnswer = "";
		String userAnswerBalance = "";
		String userName = "";
		String userAnswerBack = "";
		String userAnswerEnd = "";
		String accountNumber = "";
		String accountNumberTwo = "";
		
		//start program
		
		conBank.println("Welcome to the Bank of Deb. We are glad you chose to open an account with us.");
		conBank.println("To set up your account please do the following:");
		
		//get user name
		conBank.println("Please enter your name:");
		userName = conBank.readLine();
		
		//get account number and balance one. If entered incorrectly loop through and try again. 
		do 
		{
			conBank.println("Please enter your account number: ");
			accountNumber = conBank.readLine();
			conBank.println("Thank you for that information.");
			conBank.println("If your account number is " + accountNumber + " please type 'yes'. Otherwise, type 'no'");
			userAnswer = conBank.readLine();
		}
		while(userAnswer.toLowerCase().equals("no"));
		
		//Get initial balance
		do
		{
			conBank.println("Please enter your initial balance: ");
			initalBalance = conBank.readDouble();
			currentBalance = initalBalance; 
			conBank.println("If your initial balance is �" + currentBalance + " please type 'yes'. Otherwise, type 'no'.");
			userAnswerBalance = conBank.readLine();
			System.out.print(currentBalance);
		}
		while(userAnswerBalance.toLowerCase().equals("no"));
		
		conBank.println("Great thank you for your information");
		
		//get second account. If entered incorrectly loop through and try again.
		do 
		{
			conBank.println("Please enter your second account number: ");
			accountNumberTwo = conBank.readLine();
			conBank.println("Thank you for that information.");
			conBank.println("If your account number is " + accountNumberTwo + " please type 'yes'. Otherwise, type 'no'");
			userAnswer = conBank.readLine();
		}
		while(userAnswer.toLowerCase().equals("no"));
		
		//print thank you
		conBank.println("Great thank you for your information");
		
			
		//initial balance of second account
		do
		{
		conBank.println("Please enter your initial balance: ");
		initalBalanceTwo = conBank.readDouble();
		currentBalanceTwo = initalBalanceTwo; 
		conBank.println("If your initial balance is �" + currentBalanceTwo + " please type 'yes'. Otherwise, type 'no'.");
		userAnswerBalance = conBank.readLine();
		System.out.print(currentBalance);
		}
		while(userAnswerBalance.toLowerCase().equals("no"));
		
		conBank.println("Thank you for that information. You will now be redirected to make a transaction.");
		
		//print user account to file
		String bankFile = "account-" + accountNumber + ".txt";
		String accountLine = accountNumber + " " + initalBalance;
		FileOut bankFileOut = new FileOut(bankFile);
		bankFileOut.println(accountLine);
		
		//bank two account file
		String bankFileTwo = "account-" + accountNumberTwo + ".txt";
		String accountLineTwo = accountNumberTwo + " " + initalBalanceTwo;
		FileOut bankFileOutTwo = new FileOut(bankFileTwo);
		bankFileOutTwo.println(accountLineTwo);
		
		//loop through transaction actions until the user wishes to not make a transaction	
		while(repeater)
		{
			
		//ask for account number loop through if account number is wrong
			conBank.println("Please enter your account number");
			tempBankInfo = conBank.readLine();
			
		//when right account number ask if withdrawl or deposit
		conBank.println("Welcome Back " + userName + ". Please tell me if you would like to withdraw, deposit, transfer money or pay rent.");
		conBank.println("To withdraw press 'w', deposit press 'd', transfer press 't', and pay rent 'r' ");
		userAnswerBack = conBank.readLine();
		
		if (userAnswerBack.toLowerCase().equals("w"))
		{
			if (accountNumber.equals(tempBankInfo))
			{
				conBank.println("How much would you like to withdraw?");
				withdrawAmount = conBank.readDouble();
				System.out.print(currentBalance);
				conBank.println("Transaction" + currentBalance + "-" + withdrawAmount);
				currentBalance = currentBalance - withdrawAmount;
				conBank.println("Your current balance is " + currentBalance);
			}
			if (accountNumberTwo.equals(tempBankInfo))
			{
				conBank.println("How much would you like to withdraw?");
				withdrawAmount = conBank.readDouble();
				System.out.print(currentBalanceTwo);
				conBank.println("Transaction" + currentBalanceTwo + "-" + withdrawAmount);
				currentBalanceTwo = currentBalanceTwo - withdrawAmount;
				conBank.println("Your current balance is " + currentBalanceTwo);
			}
				
		}
		
		else if (userAnswerBack.toLowerCase().equals("d"))
		{
			if (accountNumber.equals(tempBankInfo))
			{
				conBank.println("How much would you like to deposit?");
				depositAmount = conBank.readDouble();
				System.out.println(currentBalance);
				conBank.println("Transaction:" + currentBalance + "+" + depositAmount);
				currentBalance = currentBalance + depositAmount;
				conBank.println("Your current balance is " + currentBalance);
			}
			if (accountNumberTwo.equals(tempBankInfo))
			{
				conBank.println("How much would you like to deposit?");
				depositAmount = conBank.readDouble();
				System.out.println(currentBalanceTwo);
				conBank.println("Transaction:" + currentBalanceTwo + "+" + depositAmount);
				currentBalanceTwo = currentBalanceTwo + depositAmount;
				conBank.println("Your current balance is " + currentBalanceTwo);
				
			}
		}
		
		else if (userAnswerBack.toLowerCase().equals("r"))
		{
			if (tempBankInfo.equals(accountNumber))
			{
				conBank.println("How many months of rent would you like to pay?");
				monthsRent = conBank.readInt();
				conBank.println("How much is your rent?");
				rentalAmount = conBank.readDouble();
				totalRent = rentalAmount * monthsRent;
				conBank.println("Your total rent to be paid is � " + totalRent);
				conBank.println("Transaction:" + currentBalance + "-" + totalRent);
				currentBalance = currentBalance - totalRent;
				conBank.println("Your current balance is " + currentBalance);
				
			}
			if (tempBankInfo.equals(accountNumberTwo))
			{
				conBank.println("How many months of rent would you like to pay?");
				monthsRent = conBank.readInt();
				conBank.println("How much is your rent?");
				rentalAmount = conBank.readDouble();
				totalRent = rentalAmount * monthsRent;
				conBank.println("Your total rent to be paid is � " + totalRent);
				conBank.println("Transaction:" + currentBalanceTwo + "-" + totalRent);
				currentBalanceTwo = currentBalanceTwo - totalRent;
				conBank.println("Your current balance is " + currentBalanceTwo);
			}
			
		}
		else if (userAnswerBack.toLowerCase().equals("t"))
		{
			if (tempBankInfo.equals(accountNumber))
			{
				conBank.println("How much money would you like to transfer?");
				transferAmount = conBank.readDouble();
				conBank.println("The amount to be transfered is � " + transferAmount);
				conBank.println("Transaction:" + currentBalance + "-" + transferAmount);
				currentBalance = currentBalance - transferAmount;
				currentBalanceTwo = currentBalanceTwo + transferAmount;
				conBank.println("Your current balance of " + accountNumber + " is " + currentBalance);
				conBank.println("The current balance of " + accountNumberTwo + " is " + currentBalanceTwo);
				
			}

			if (tempBankInfo.equals(accountNumberTwo))
			{
				conBank.println("How much money would you like to transfer?");
				transferAmount = conBank.readDouble();
				conBank.println("The amount to be transfered is � " + transferAmount);
				conBank.println("Transaction:" + currentBalanceTwo + "-" + transferAmount);
				currentBalanceTwo = currentBalanceTwo - transferAmount;
				currentBalance = currentBalance + transferAmount;
				conBank.println("The current balance of " + accountNumberTwo + " is " + currentBalanceTwo);
				conBank.println("Your current balance of " + accountNumber + " is " + currentBalance);
				
			}
		}
		
		//ask if they want another transaction. If so, loop through. If not end program 
		
		conBank.println("If you would like to do another transaction, please press yes. Otherwise type no.");
		userAnswerEnd = conBank.readLine();
		if (userAnswerEnd.toLowerCase().equals("no")) 
		{
			repeater = false;
		}
		}
		conBank.println("Thank you for your service.");
		
		//end program by creating a file
		bankFile = "account-" + accountNumber + ".txt";
		accountLine = accountNumber + " " + currentBalance;
		bankFileOut = new FileOut(bankFile);
		bankFileOut.println("Account file <" + bankFile+ "> written" + accountNumber + " " + currentBalance);
		
		bankFileOut.close();
		 		
		
	}
}