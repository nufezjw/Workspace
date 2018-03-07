
public class CustomerAccount {
private String cusName;   
private double curBalance;


//the constructor to initialize the instance variables
public CustomerAccount(String cusName,double curBalance) {
	this.cusName=cusName;
	this.curBalance=curBalance;	
}

public String getCusName() {
	return cusName;
}

public void setCusName(String cusName) {
	this.cusName = cusName;
}

public double getCurBalance() {
	return curBalance;
}

public void setCurBalance(double curBalance) {
	this.curBalance = curBalance;
}

//the operation of sale,add the amount of sale to the current balance
public  String addCurBalance(double sale) {
	double curBalance=sale+getCurBalance();
	if(curBalance>=0) {	
		setCurBalance(curBalance);
		String outbalance=String.format("%.2f", getCurBalance());
		return outbalance;
	}else
		setCurBalance(Math.abs(curBalance));//if the value of balance is less than 0,get the absolute value
		String outbalance=String.format("%.2f",getCurBalance())+"CR";
		return outbalance;
}

//the operation of return,minus the amount of return with the current balance
public  String minCurBalance(double back) {
	double curBalance=getCurBalance()-back;
	if(curBalance>=0) {	
		setCurBalance(curBalance);
		String outbalance=String.format("%.2f", getCurBalance());
		return outbalance;
	}else
		setCurBalance(Math.abs(curBalance));//if the value of balance is less than 0,get the absolute value
		String outbalance=String.format("%.2f",getCurBalance())+"CR";
		return outbalance;
	
}
}
