package imooctest;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
private Map<String,student> Student;

public MapTest() {
	this.Student=new HashMap<String,student>();
}

/*
 * *输入学生ID，判断是否被占用，如果没有被占用，则输入学生姓名，添加到student中*/
public void testStudent() {
	int i=0;
	Scanner input=new Scanner(System.in);
	while(i<3) {
		
	    System.out.println("请输入学生id:");
	    String studentId=input.next();
	    student s1=Student.get(studentId);//如果studentId存在，则返回value值，也就是一个student 对象，如果不存在，则返回空值
	    if(s1==null) {
	    	System.out.println("请输入学生姓名：");
            String inputName=input.next();
	    	
	    	student newStudent=new student(studentId,inputName);
	    	Student.put(studentId, newStudent);
	    	System.out.println("成功添加学生："+newStudent.getName());
	    	i++;
	    	
	    	
	    }else 
	     System.out.println("此id已经被占用");
	     continue;	
	}
}
/**输出所输入的学生信息*/
public void testKeyset() {
	Set<String> keySet=Student.keySet();//通过keySet（）方法获得key 的set集合
	for(String a:keySet) {    //遍历keySet 取得每一个键，并通过get方法获得每个键对应的value
		student s=Student.get(a);
		System.out.println("添加的学生id："+s.getID()+" "+"添加的学生姓名："+s.getName());
	}
	
}


/**测试Map的删除功能*/
public void testRemove() {
while(true) {
	System.out.println("请输入要删除学生的id:");
	Scanner input=new Scanner(System.in);
	String idRemove=input.next();
    if(Student.get(idRemove)==null) {
    	System.out.println("输入的学生id不存在，重新输入");
    	continue;
    }else {

    	Student.remove(Student.get(idRemove).getID());
    	break;
    }}
}
	/**通过entrySet()来遍历Map中的所有键值对*/
	public void testEntrySet() {
		Set<Entry<String,student>> entrySet=Student.entrySet();
		for(Entry<String,student> a:entrySet){
			System.out.println("取得id为："+a.getKey());
			System.out.println("取得姓名为："+a.getValue().getName());
		
	}	
	}
	/**利用put()方法，修改学生信息*/
	public void testModify() {
		System.out.println("请输入要修改学生的ID:");
		while(true) {
		
		Scanner input=new Scanner(System.in);
		String id=input.next();
		student tobedelete=Student.get(id);
		if(tobedelete==null) {
			System.out.println("该学生不存在");
		     continue;}
		else {
			/*输出要修改的学生的姓名*/
		System.out.println("要修改的学生姓名为："+tobedelete.getName());
		/*提示输入改好的名字*/
		System.out.println("请输入新的学生姓名：");
		String newName=input.next();
        student newStudent=new student(id,newName);
		Student.put(id, newStudent);
		System.out.println("成功修改");
		break;
		}
		}}

	
	/**Map 如何判断某个映射中是否包含某个key值或value值*/
	public void testContiansKey() {
		System.out.println("请输入学生id:");
		Scanner console=new Scanner(System.in);
		String id=console.next();
		System.out.println("输入的id为"+id+"map中是否包含这个id"+Student.containsKey(id));
		if(Student.containsKey(id)) {
			System.out.println("这个学生的姓名为："+Student.get(id).getName());
		}
	}
	public void testContainsValue() {
		System.out.println("请输入学生名字:");
		Scanner console=new Scanner(System.in);
		String name=console.next();
//		student student1=new student(null, name);
		if(Student.containsValue(new student(null,name)))
		System.out.println("输入的学生名字为"+name);
		else
	    System.out.println("输入的学生姓名不存在");
	}
	@Override
	public String toString() {
		return "MapTest [Student=" + Student + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MapTest mt=new MapTest();
	mt.testStudent();
	mt.testKeyset();
//	mt.testRemove();
//	mt.testEntrySet();
//    mt.testModify();
//    mt.testEntrySet();
   // mt.testContiansKey();
    mt.testContainsValue();
	}

}
