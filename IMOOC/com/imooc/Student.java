package com.imooc;

import java.util.HashSet;
import java.util.Set;

public class Student {
private String ID;
private String Name;
private Set courses;
public Student(String ID,String Name) {
	this.ID=ID;
	this.Name=Name;
	this.courses=new HashSet();
}
}
