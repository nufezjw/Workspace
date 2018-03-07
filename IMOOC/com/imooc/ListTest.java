package com.imooc;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
public List courseToselect;
public ListTest() {
	this.courseToselect=new ArrayList();
}
/**
 * 添加课程
 */
public void Testadd() {
	Course cr1=new Course("1","数据结构");
	courseToselect.add(cr1);
	Course temp=(Course) courseToselect.get(0);
	System.out.println("the courses have been added"+temp.getCourseID()+temp.getCourseName());
	
}
public static void main(String[] args) {
	ListTest t=new ListTest();
	t.Testadd();
	
}
}
