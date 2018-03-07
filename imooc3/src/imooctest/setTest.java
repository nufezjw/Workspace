package imooctest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class setTest {
	public Set<courses> courseSelect;
	public student s1;
	
	
	public setTest() {
		this.courseSelect=new HashSet<courses>();	
	}
	
	/**创建学生对象并且选课*/ 
	public void createNewstudentAddcourse() {
		 s1=new student("2302","Tim");
		System.out.println("欢迎学生"+s1.getName()+"选课"+"\n");
		Scanner console=new Scanner(System.in) ;
			for(int i=0;i<3;i++) {
			System.out.println("请输入所要选的课程ID：");
				String in=console.next();
				for(courses c:courseSelect) {
					if(in.equals(c.getID())) {
						s1.courses.add(c);
						
					}
					
				}}
	}
	
	
	/**
	 * 测试Set的contains方法,学生选完课以后，判断 某门课程是否在学生的选课内容里，这门课程是由我们输入的
	 */
	public void testSetcontians() {
		System.out.println("请输入课程名称:");
		Scanner console=new Scanner(System.in);
		String coursename=console.next();
		courses newCourse=new courses(null,coursename);
	
		System.out.println("判断输入的课程是否在学生的选课列表中"+s1.courses.contains(newCourse));
		
		
	}
	
	/**
	 * 增加课程
	 */
	public void addCourse() {
		courses c1=new courses("1","线性代数");
		courseSelect.add(c1);
		courses c2=new courses("2","离散数学");
		courseSelect.add(c2);
		courses c3=new courses("3","概率论");
		courseSelect.add(c3);
		courses[] course= {new courses("4","math"),new courses("5","art")};
		courseSelect.addAll(Arrays.asList(course));
//		courses temp4=(courses)courseSelect.get(3);
//		courses temp5=(courses)courseSelect.get(4);
	//	System.out.println(temp4.getID()+" "+temp4.getName()+";"+temp5.getID()+" "+temp5.getName());
	}
	/**
	 * 循环输出list中的值
	 */
/*	public void testGet() {
		int size= courseSelect.size();
		for(int i = 0;i<size;i++) {
			courses temp=(courses)courseSelect.get(i);
			System.out.println(temp.getID()+temp.getName()+"\n");
		}
	}*/
		/**
		 * 以下会抛出IOINDEXOUTOFBOUNDSEXCEPTION*/
	//	courses temp=(courses)courseSelect.get(3);
		//System.out.println(temp.getID()+" "+temp.getName());
	public void testForeach() {
		for(courses a:courseSelect) {
			System.out.println(a.getID()+a.getName());
			
		}
	}
//	/**通过Iterator迭代器来遍历List*/
//	public void testIterator() {
//		Iterator it=courseSelect.iterator();
//		while(it.hasNext()) {
//             courses temp=(courses)it.next();
//         	System.out.println(temp.getID()+temp.getName()+"\n");}
//		}
//	public void testType() {
//		courseSelect.add("我不是课程，我是字符串");
//		
//	}
	/**通过foreach方法来进行遍历
	 */
/*	public void testForeach() {
	for(Object obj:courseSelect) {
		courses temp=(courses)obj;
		System.out.println(temp.getID()+temp.getName()+"\n");
	}
		
	}*/
	/**通过set()方法来修改list中的值*/
//	public void testModify() {
//		courseSelect.set(0, new courses("15","PE"));
//		
//	}
/**删除list中的元素 remove()方法
	public void testRemove() {
	//	courses cr2=(courses)courseSelect.get(1);
	//	System.out.println("you are going to be deleted"+cr2.getID()+" "+cr2.getName());
		courseSelect.remove(4);
	}
	*/
	/**删除list中集合的removeAll()方法
	 * 
	 * @param args
	 */
//	public void testRemoveAll() {
//		courses[] course1= {(courses)courseSelect.get(3),(courses)courseSelect.get(4)};
//		System.out.println("即将删除位置4.5的元素");
//		courseSelect.removeAll(Arrays.asList(course1));
//	}
	
	/**利用contains方法判断集合中是否包含某个元素*/
	
	
	public static void main(String[] args) {
		setTest t=new setTest();
		t.addCourse();
		//t.testGet();
//		t.testModify();
//		t.testIterator();
//		//t.testForeach();
//		t.testRemoveAll();
//		t.testIterator();
//		t.testType();
		t.testForeach();
//	student s1=new student("2302","Tim");
//	System.out.println("欢迎学生"+s1.getName()+"选课"+"\n");
//	Scanner input=new Scanner(System.in) ;
//		for(int i=0;i<3;i++) {
//		System.out.println("请输入所要选的课程ID：");
//		 	String in=input.next();
//			for(courses c:t.courseSelect) {
//				if(in.equals(c.getID())) {
//					s1.courses.add(c);
//					
//				}
//				
//			}}
	  t.createNewstudentAddcourse();
	  t.testSetcontians();
		}
		public void testForset(student s1) {
	      for(courses c:s1.courses) {
	        System.out.println("学生选了"+c.getID()+c.getName());
		
	}
		
	}
		/**通过方法找到List中对象的位置*/
}

