package pockergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class player  {
private String id;
private String name;
public List<pocker> allopocker;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<pocker> getAllopocker() {
	return allopocker;
}
public void setAllopocker(List<pocker> allopocker) {
	this.allopocker = allopocker;
}
public player() {
	
}
public player(String id,String name) {
	this.id=id;
	this.name=name;
	this.allopocker=new ArrayList<pocker>();
}

}
