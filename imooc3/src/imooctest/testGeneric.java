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


/**����contains�����жϼ������Ƿ����ĳ��Ԫ��*/
public void tetContains() {
	Scanner in=new Scanner(System.in);
	System.out.println("������γ�����");
	String in1=in.next();
	courses newCourse=new courses();
	newCourse.setName(in1);
	
	System.out.println("�жϿγ�"+newCourse.getName()+"�Ƿ����б��У�"+course.contains(newCourse));
	
	/**�������Ŀγ����б��У�������ÿγ���list�е�λ��*/
	if(course.contains(newCourse)) {
		System.out.println("����Ŀγ�"+newCourse.getName()+"��list�е�λ��Ϊ"+course.indexOf(newCourse));
	}
	}
//	
//	/*�Ӽ�������һ���γ����ƣ��жϸÿγ��Ƿ��ڿγ��б�����*/
//	System.out.println("����γ����ƣ�");
//    Scanner input=new Scanner(System.in);
//    String coursename=input.next();
//    courses newCourse1=new courses();
//    newCourse1.setName(coursename);
//    System.out.println("�жϿγ�"+newCourse1.getName()+"�Ƿ����б��У�"+course.contains(newCourse1));}
//
    public void testForeach() {
	for(courses a:course) {
		System.out.println(a.getID()+a.getName());
		
	}
}
/**
 * ���Է��� ���ͼ��Ͽ�����ӷ��͵������͵Ķ���ʵ��
 * @param args
 */
public void addChildcourses() {
	Childcourses cc=new Childcourses();
	course.add(cc);
}

//
///**���Ͳ���ʹ�û�������*/
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
