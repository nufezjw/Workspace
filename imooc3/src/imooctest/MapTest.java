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
 * *����ѧ��ID���ж��Ƿ�ռ�ã����û�б�ռ�ã�������ѧ����������ӵ�student��*/
public void testStudent() {
	int i=0;
	Scanner input=new Scanner(System.in);
	while(i<3) {
		
	    System.out.println("������ѧ��id:");
	    String studentId=input.next();
	    student s1=Student.get(studentId);//���studentId���ڣ��򷵻�valueֵ��Ҳ����һ��student ������������ڣ��򷵻ؿ�ֵ
	    if(s1==null) {
	    	System.out.println("������ѧ��������");
            String inputName=input.next();
	    	
	    	student newStudent=new student(studentId,inputName);
	    	Student.put(studentId, newStudent);
	    	System.out.println("�ɹ����ѧ����"+newStudent.getName());
	    	i++;
	    	
	    	
	    }else 
	     System.out.println("��id�Ѿ���ռ��");
	     continue;	
	}
}
/**����������ѧ����Ϣ*/
public void testKeyset() {
	Set<String> keySet=Student.keySet();//ͨ��keySet�����������key ��set����
	for(String a:keySet) {    //����keySet ȡ��ÿһ��������ͨ��get�������ÿ������Ӧ��value
		student s=Student.get(a);
		System.out.println("��ӵ�ѧ��id��"+s.getID()+" "+"��ӵ�ѧ��������"+s.getName());
	}
	
}


/**����Map��ɾ������*/
public void testRemove() {
while(true) {
	System.out.println("������Ҫɾ��ѧ����id:");
	Scanner input=new Scanner(System.in);
	String idRemove=input.next();
    if(Student.get(idRemove)==null) {
    	System.out.println("�����ѧ��id�����ڣ���������");
    	continue;
    }else {

    	Student.remove(Student.get(idRemove).getID());
    	break;
    }}
}
	/**ͨ��entrySet()������Map�е����м�ֵ��*/
	public void testEntrySet() {
		Set<Entry<String,student>> entrySet=Student.entrySet();
		for(Entry<String,student> a:entrySet){
			System.out.println("ȡ��idΪ��"+a.getKey());
			System.out.println("ȡ������Ϊ��"+a.getValue().getName());
		
	}	
	}
	/**����put()�������޸�ѧ����Ϣ*/
	public void testModify() {
		System.out.println("������Ҫ�޸�ѧ����ID:");
		while(true) {
		
		Scanner input=new Scanner(System.in);
		String id=input.next();
		student tobedelete=Student.get(id);
		if(tobedelete==null) {
			System.out.println("��ѧ��������");
		     continue;}
		else {
			/*���Ҫ�޸ĵ�ѧ��������*/
		System.out.println("Ҫ�޸ĵ�ѧ������Ϊ��"+tobedelete.getName());
		/*��ʾ����ĺõ�����*/
		System.out.println("�������µ�ѧ��������");
		String newName=input.next();
        student newStudent=new student(id,newName);
		Student.put(id, newStudent);
		System.out.println("�ɹ��޸�");
		break;
		}
		}}

	
	/**Map ����ж�ĳ��ӳ�����Ƿ����ĳ��keyֵ��valueֵ*/
	public void testContiansKey() {
		System.out.println("������ѧ��id:");
		Scanner console=new Scanner(System.in);
		String id=console.next();
		System.out.println("�����idΪ"+id+"map���Ƿ�������id"+Student.containsKey(id));
		if(Student.containsKey(id)) {
			System.out.println("���ѧ��������Ϊ��"+Student.get(id).getName());
		}
	}
	public void testContainsValue() {
		System.out.println("������ѧ������:");
		Scanner console=new Scanner(System.in);
		String name=console.next();
//		student student1=new student(null, name);
		if(Student.containsValue(new student(null,name)))
		System.out.println("�����ѧ������Ϊ"+name);
		else
	    System.out.println("�����ѧ������������");
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
