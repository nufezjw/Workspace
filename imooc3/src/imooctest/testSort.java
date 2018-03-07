package imooctest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class testSort {
	/**1.	通过collectons.sort()方法，对Integer泛型的list进行排序
	2.	对String泛型的list进行排序
	3.	对于其他类型泛型的list进行排序，以student为例*/
public void testSort() {
	List<Integer> integer=new ArrayList<Integer>();
	Random random=new Random();
	int k;
	for(int i=0;i<10;i++) {
		do {
			 k=random.nextInt(100);//随机添加值小于100的随机数
			
			
		}while(integer.contains(k));
		integer.add(k);
		System.out.println("成功添加整数："+k);
	}
	System.out.println("排序前的这10个数为：");
	for(Integer a:integer) {
		System.out.println(a);
	}
	Collections.sort(integer);//利用Collections.sort()函数对于list进行排序
	System.out.println("排序后为：");
	for(Integer a:integer) {
		System.out.println(a);
	}
}
/**为List<String>中加入10个随机的字符串。并且进行排序*/

public void testSort2() {
	List<String> list=new ArrayList<String>();
	String s="abcdefghijknlmopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	StringBuffer buf=new StringBuffer();
	Random random=new Random();

   for(int i=0;i<10;i++) {
	do{  
			int stringlength=(int) (Math.random()*9+1);//随机生成字符串的长度
			buf=new StringBuffer();//如果存在一样的字符串，则清空之前的                 很重要很重要 重新开始添加
			for(int j=0;j<stringlength;j++) {
				int index=random.nextInt(s.length());
				buf.append(s.charAt(index));
			}}while(list.contains(buf.toString()));
			 
			list.add(buf.toString());    
		  System.out.println("随机生成的字符串为："+buf.toString());}
System.out.println("排序前是：-----------------------------------");
for(String a:list) {
	System.out.println(a);
}
Collections.sort(list);
System.out.println("排序后是：-----------------------------------");
for(String a:list) {
	System.out.println(a);
}

}

/**对于其他泛型进行排序操作*/
public void testSort3() {
	List<student> Student=new ArrayList<student>();
	Random random=new Random();
	/*随机输入3个小于1000的正整数ID*/
//	for(int i=0;i<3;i++) {
//	do {
//	String id=random.nextInt(1000);
//	
//	}             
	Student.add(new student((random.nextInt(1000)+""),"James"));
	Student.add(new student((random.nextInt(1000)+""),"Kevin"));
	Student.add(new student((random.nextInt(1000)+""),"Tim"));
	for(student a : Student) {
		System.out.println("排序前学生序列中有如下的："+a.getID()+a.getName());
	}
	System.out.println("排序后-------------------");
	Collections.sort(Student);
	for(student a : Student) {
	System.out.println("排序前学生序列中有如下的："+a.getID()+a.getName());
}
	System.out.println("----------------按照姓名排序后-------------------");
	Collections.sort(Student,new StudentComparator());//按照学生姓名进行排序，new StudentComparator是指明他们比较的方式
	for(student a : Student) {
	System.out.println("排序前学生序列中有如下的："+a.getID()+a.getName());}}
	 
	  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
    testSort t=new testSort();
//    t.testSort2();
    t.testSort3();
	}

}
