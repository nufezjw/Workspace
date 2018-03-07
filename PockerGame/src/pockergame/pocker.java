package pockergame;

import java.util.Comparator;

public class pocker {
@Override
	public String toString() {
		return  pockerflower+pockerpoint;
	}
private String pockerflower;
private String pockerpoint;
public pocker() {
	
}
public pocker(String pockerflower,String pockerpoint) {
	this.pockerflower=pockerflower;
	this.pockerpoint=pockerpoint;
}
public String getPockerflower() {
	return pockerflower;
}
public void setPockerflower(String pockerflower) {
	this.pockerflower = pockerflower;
}
public String getPockerpoint() {
	return pockerpoint;
}
public void setPockerpoint(String pockerpoint) {
	this.pockerpoint = pockerpoint;
}





}
