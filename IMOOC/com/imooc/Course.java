package com.imooc;

public class Course {
private String courseID;
private String courseName;
public String getCourseID() {
	return courseID;
}
public void setCourseID(String courseID) {
	this.courseID = courseID;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public Course(String courseID,String courseName) {
	this.courseID=courseID;
	this.courseName=courseName;
}
}
