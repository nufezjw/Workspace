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
	
	/**����ѧ��������ѡ��*/ 
	public void createNewstudentAddcourse() {
		 s1=new student("2302","Tim");
		System.out.println("��ӭѧ��"+s1.getName()+"ѡ��"+"\n");
		Scanner console=new Scanner(System.in) ;
			for(int i=0;i<3;i++) {
			System.out.println("��������Ҫѡ�Ŀγ�ID��");
				String in=console.next();
				for(courses c:courseSelect) {
					if(in.equals(c.getID())) {
						s1.courses.add(c);
						
					}
					
				}}
	}
	
	
	/**
	 * ����Set��contains����,ѧ��ѡ����Ժ��ж� ĳ�ſγ��Ƿ���ѧ����ѡ����������ſγ��������������
	 */
	public void testSetcontians() {
		System.out.println("������γ�����:");
		Scanner console=new Scanner(System.in);
		String coursename=console.next();
		courses newCourse=new courses(null,coursename);
	
		System.out.println("�ж�����Ŀγ��Ƿ���ѧ����ѡ���б���"+s1.courses.contains(newCourse));
		
		
	}
	
	/**
	 * ���ӿγ�
	 */
	public void addCourse() {
		courses c1=new courses("1","���Դ���");
		courseSelect.add(c1);
		courses c2=new courses("2","��ɢ��ѧ");
		courseSelect.add(c2);
		courses c3=new courses("3","������");
		courseSelect.add(c3);
		courses[] course= {new courses("4","math"),new courses("5","art")};
		courseSelect.addAll(Arrays.asList(course));
//		courses temp4=(courses)courseSelect.get(3);
//		courses temp5=(courses)courseSelect.get(4);
	//	System.out.println(temp4.getID()+" "+temp4.getName()+";"+temp5.getID()+" "+temp5.getName());
	}
	/**
	 * ѭ�����list�е�ֵ
	 */
/*	public void testGet() {
		int size= courseSelect.size();
		for(int i = 0;i<size;i++) {
			courses temp=(courses)courseSelect.get(i);
			System.out.println(temp.getID()+temp.getName()+"\n");
		}
	}*/
		/**
		 * ���»��׳�IOINDEXOUTOFBOUNDSEXCEPTION*/
	//	courses temp=(courses)courseSelect.get(3);
		//System.out.println(temp.getID()+" "+temp.getName());
	public void testForeach() {
		for(courses a:courseSelect) {
			System.out.println(a.getID()+a.getName());
			
		}
	}
//	/**ͨ��Iterator������������List*/
//	public void testIterator() {
//		Iterator it=courseSelect.iterator();
//		while(it.hasNext()) {
//             courses temp=(courses)it.next();
//         	System.out.println(temp.getID()+temp.getName()+"\n");}
//		}
//	public void testType() {
//		courseSelect.add("�Ҳ��ǿγ̣������ַ���");
//		
//	}
	/**ͨ��foreach���������б���
	 */
/*	public void testForeach() {
	for(Object obj:courseSelect) {
		courses temp=(courses)obj;
		System.out.println(temp.getID()+temp.getName()+"\n");
	}
		
	}*/
	/**ͨ��set()�������޸�list�е�ֵ*/
//	public void testModify() {
//		courseSelect.set(0, new courses("15","PE"));
//		
//	}
/**ɾ��list�е�Ԫ�� remove()����
	public void testRemove() {
	//	courses cr2=(courses)courseSelect.get(1);
	//	System.out.println("you are going to be deleted"+cr2.getID()+" "+cr2.getName());
		courseSelect.remove(4);
	}
	*/
	/**ɾ��list�м��ϵ�removeAll()����
	 * 
	 * @param args
	 */
//	public void testRemoveAll() {
//		courses[] course1= {(courses)courseSelect.get(3),(courses)courseSelect.get(4)};
//		System.out.println("����ɾ��λ��4.5��Ԫ��");
//		courseSelect.removeAll(Arrays.asList(course1));
//	}
	
	/**����contains�����жϼ������Ƿ����ĳ��Ԫ��*/
	
	
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
//	System.out.println("��ӭѧ��"+s1.getName()+"ѡ��"+"\n");
//	Scanner input=new Scanner(System.in) ;
//		for(int i=0;i<3;i++) {
//		System.out.println("��������Ҫѡ�Ŀγ�ID��");
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
	        System.out.println("ѧ��ѡ��"+c.getID()+c.getName());
		
	}
		
	}
		/**ͨ�������ҵ�List�ж����λ��*/
}

