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
		courseSelect.addAll(Arrays.asList(course));//将数组转换成序列
		courses temp4=(courses)courseSelect.get(3); //List中获得的对象为object类
		courses temp5=(courses)courseSelect.get(4);
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
	
	/**通过Iterator迭代器来遍历List*/
	public void testIterator() {
		Iterator it=courseSelect.iterator();
		while(it.hasNext()) {
             courses temp=(courses)it.next();
         	System.out.println(temp.getID()+temp.getName()+"\n");}
		}
	public void testType() {
		courseSelect.add("我不是课程，我是字符串");
		
	}
	/**通过foreach方法来进行遍历
	 */
/*	public void testForeach() {
	for(Object obj:courseSelect) {
		courses temp=(courses)obj;
		System.out.println(temp.getID()+temp.getName()+"\n");
	}
		
	}*/
	/**通过set()方法来修改list中的值*/
	public void testModify() {
		courseSelect.set(0, new courses("15","PE"));
		
	}
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
	public void testRemoveAll() {
		courses[] course1= {(courses)courseSelect.get(3),(courses)courseSelect.get(4)};
		System.out.println("即将删除位置4.5的元素");
		courseSelect.removeAll(Arrays.asList(course1));
	}
	

	
	
	
	
	/**main 方法*/
	
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
