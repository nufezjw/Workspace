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
 * 序列化(Serialization)将对象的状态信息转换为可以存储或传输的形式的过程
 * 对象持久化   写入到硬盘 下次需要调用的时候不需要new了，直接从硬盘读入就行
 * @author Kevin
 *
 */
public static void writeObj() throws IOException, IOException {	
ObjectOutputStream oop=new ObjectOutputStream(new FileOutputStream("obj.object")); //object文件的存储的后缀为object
oop.writeObject(new Person("xiaoming",18));//对象序列化，被序列化的对象必须实现implements Serializable接口
}

//ObjectInputStream 只能读ObjectOutputStream写入的
//obj.readObject()
public static void ReadObj() throws IOException, ClassNotFoundException {
	ObjectInputStream ois=new ObjectInputStream(new FileInputStream("obj.object"));
	//Object obj=ois.readObject();   
	//这种方式没法读到文件，因为对象在堆中存储的时候，都需要一个.class文件，
	//即字节码文件，而obj.object中存储着字节码文件信息，但是内存中没有Person.class文件
	Person p=(Person)ois.readObject();//进行强转  转为Person类
	System.out.println(p.getName()+":"+p.getAge());
	ois.close();
}
}
