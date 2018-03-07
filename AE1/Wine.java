
public class Wine {
private int quantity;
private String wineName;
private double winePrice;


//Initialize instance variables
public Wine(String wineName,int quantity,double winePrice) {
this.setQuantity(quantity);
this.setWineName(wineName);
this.setWinePrice(winePrice);
}

public String getWineName() {
	return wineName;
}

public void setWineName(String wineName) {
	this.wineName = wineName;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getWinePrice() {
	return winePrice;
}

public void setWinePrice(double winePrice) {
	this.winePrice = winePrice;
}
}
