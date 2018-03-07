package File24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectStreamDemo {
	

	
public static void main(String[] args) throws IOException, ClassNotFoundException {
	//writeObj();
	ReadObj();
}
/**
 * ���л�(Serialization)�������״̬��Ϣת��Ϊ���Դ洢�������ʽ�Ĺ���
 * ����־û�   д�뵽Ӳ�� �´���Ҫ���õ�ʱ����Ҫnew�ˣ�ֱ�Ӵ�Ӳ�̶������
 * @author Kevin
 *
 */
public static void writeObj() throws IOException, IOException {	
ObjectOutputStream oop=new ObjectOutputStream(new FileOutputStream("obj.object")); //object�ļ��Ĵ洢�ĺ�׺Ϊobject
oop.writeObject(new Person("xiaoming",18));//�������л��������л��Ķ������ʵ��implements Serializable�ӿ�
}

//ObjectInputStream ֻ�ܶ�ObjectOutputStreamд���
//obj.readObject()
public static void ReadObj() throws IOException, ClassNotFoundException {
	ObjectInputStream ois=new ObjectInputStream(new FileInputStream("obj.object"));
	//Object obj=ois.readObject();   
	//���ַ�ʽû�������ļ�����Ϊ�����ڶ��д洢��ʱ�򣬶���Ҫһ��.class�ļ���
	//���ֽ����ļ�����obj.object�д洢���ֽ����ļ���Ϣ�������ڴ���û��Person.class�ļ�
	Person p=(Person)ois.readObject();//����ǿת  תΪPerson��
	System.out.println(p.getName()+":"+p.getAge());
	ois.close();
}
}
