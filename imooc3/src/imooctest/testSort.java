package imooctest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class testSort {
	/**1.	ͨ��collectons.sort()��������Integer���͵�list��������
	2.	��String���͵�list��������
	3.	�����������ͷ��͵�list����������studentΪ��*/
public void testSort() {
	List<Integer> integer=new ArrayList<Integer>();
	Random random=new Random();
	int k;
	for(int i=0;i<10;i++) {
		do {
			 k=random.nextInt(100);//������ֵС��100�������
			
			
		}while(integer.contains(k));
		integer.add(k);
		System.out.println("�ɹ����������"+k);
	}
	System.out.println("����ǰ����10����Ϊ��");
	for(Integer a:integer) {
		System.out.println(a);
	}
	Collections.sort(integer);//����Collections.sort()��������list��������
	System.out.println("�����Ϊ��");
	for(Integer a:integer) {
		System.out.println(a);
	}
}
/**ΪList<String>�м���10��������ַ��������ҽ�������*/

public void testSort2() {
	List<String> list=new ArrayList<String>();
	String s="abcdefghijknlmopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	StringBuffer buf=new StringBuffer();
	Random random=new Random();

   for(int i=0;i<10;i++) {
	do{  
			int stringlength=(int) (Math.random()*9+1);//��������ַ����ĳ���
			buf=new StringBuffer();//�������һ�����ַ����������֮ǰ��                 ����Ҫ����Ҫ ���¿�ʼ���
			for(int j=0;j<stringlength;j++) {
				int index=random.nextInt(s.length());
				buf.append(s.charAt(index));
			}}while(list.contains(buf.toString()));
			 
			list.add(buf.toString());    
		  System.out.println("������ɵ��ַ���Ϊ��"+buf.toString());}
System.out.println("����ǰ�ǣ�-----------------------------------");
for(String a:list) {
	System.out.println(a);
}
Collections.sort(list);
System.out.println("������ǣ�-----------------------------------");
for(String a:list) {
	System.out.println(a);
}

}

/**�����������ͽ����������*/
public void testSort3() {
	List<student> Student=new ArrayList<student>();
	Random random=new Random();
	/*�������3��С��1000��������ID*/
//	for(int i=0;i<3;i++) {
//	do {
//	String id=random.nextInt(1000);
//	
//	}             
	Student.add(new student((random.nextInt(1000)+""),"James"));
	Student.add(new student((random.nextInt(1000)+""),"Kevin"));
	Student.add(new student((random.nextInt(1000)+""),"Tim"));
	for(student a : Student) {
		System.out.println("����ǰѧ�������������µģ�"+a.getID()+a.getName());
	}
	System.out.println("�����-------------------");
	Collections.sort(Student);
	for(student a : Student) {
	System.out.println("����ǰѧ�������������µģ�"+a.getID()+a.getName());
}
	System.out.println("----------------�������������-------------------");
	Collections.sort(Student,new StudentComparator());//����ѧ��������������new StudentComparator��ָ�����ǱȽϵķ�ʽ
	for(student a : Student) {
	System.out.println("����ǰѧ�������������µģ�"+a.getID()+a.getName());}}
	 
	  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
    testSort t=new testSort();
//    t.testSort2();
    t.testSort3();
	}

}
