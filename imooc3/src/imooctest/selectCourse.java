package imooctest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class selectCourse {
	public List courseSelect;
	
	public selectCourse() {
		this.courseSelect=new ArrayList();
		
		
	}
	
	public void addCourse() {
		courses c1=new courses("1","the structure of data");
		courseSelect.add(c1);
		courses c2=new courses("2","C language");
		courseSelect.add(c2);
		courses c3=new courses("3","the structure of data");
		courseSelect.add(c3);
		courses[] course= {new courses("4","math"),new courses("5","art")};
		courseSelect.addAll(Arrays.asList(course));//������ת��������
		courses temp4=(courses)courseSelect.get(3); //List�л�õĶ���Ϊobject��
		courses temp5=(courses)courseSelect.get(4);
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
	
	/**ͨ��Iterator������������List*/
	public void testIterator() {
		Iterator it=courseSelect.iterator();
		while(it.hasNext()) {
             courses temp=(courses)it.next();
         	System.out.println(temp.getID()+temp.getName()+"\n");}
		}
	public void testType() {
		courseSelect.add("�Ҳ��ǿγ̣������ַ���");
		
	}
	/**ͨ��foreach���������б���
	 */
/*	public void testForeach() {
	for(Object obj:courseSelect) {
		courses temp=(courses)obj;
		System.out.println(temp.getID()+temp.getName()+"\n");
	}
		
	}*/
	/**ͨ��set()�������޸�list�е�ֵ*/
	public void testModify() {
		courseSelect.set(0, new courses("15","PE"));
		
	}
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
	public void testRemoveAll() {
		courses[] course1= {(courses)courseSelect.get(3),(courses)courseSelect.get(4)};
		System.out.println("����ɾ��λ��4.5��Ԫ��");
		courseSelect.removeAll(Arrays.asList(course1));
	}
	

	
	
	
	
	/**main ����*/
	
	public static void main(String[] args) {
		selectCourse t=new selectCourse();
		t.addCourse();
		//t.testGet();
		t.testModify();
//		t.testIterator();
//		//t.testForeach();
//		t.testRemoveAll();
//		t.testIterator();
		t.testType();
		t.testIterator();
	}
}
