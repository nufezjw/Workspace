package imooctest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testGeneric {
private List<courses> course;
public testGeneric() {
	this.course=new ArrayList<courses>();
}
public void addcourses() {
	courses c1=new courses("12","Music");
	course.add(c1);
	courses c2=new courses("13","Kite");
	course.add(c2);
	courses c3=new courses("14","Piano");
	course.add(c3);
}


/**利用contains方法判断集合中是否包含某个元素*/
public void tetContains() {
	Scanner in=new Scanner(System.in);
	System.out.println("请输入课程名称");
	String in1=in.next();
	courses newCourse=new courses();
	newCourse.setName(in1);
	
	System.out.println("判断课程"+newCourse.getName()+"是否在列表中，"+course.contains(newCourse));
	
	/**如果输入的课程在列表中，则输出该课程在list中的位置*/
	if(course.contains(newCourse)) {
		System.out.println("输入的课程"+newCourse.getName()+"在list中的位置为"+course.indexOf(newCourse));
	}
	}
//	
//	/*从键盘输入一个课程名称，判断该课程是否在课程列表里面*/
//	System.out.println("输入课程名称：");
//    Scanner input=new Scanner(System.in);
//    String coursename=input.next();
//    courses newCourse1=new courses();
//    newCourse1.setName(coursename);
//    System.out.println("判断课程"+newCourse1.getName()+"是否在列表中，"+course.contains(newCourse1));}
//
    public void testForeach() {
	for(courses a:course) {
		System.out.println(a.getID()+a.getName());
		
	}
}
/**
 * 测试泛型 泛型集合可以添加泛型的子类型的对象实例
 * @param args
 */
public void addChildcourses() {
	Childcourses cc=new Childcourses();
	course.add(cc);
}

//
///**泛型不能使用基本类型*/
//public void testBasicType() {
//	List<Integer> list=new ArrayList<Integer>();
//	list.add(1);
//	System.out.println(list.get(0));
//}



public static void main(String[] args) {
	testGeneric g1=new testGeneric();
	g1.addcourses();
	g1.testForeach();
	g1.tetContains();
}


}
