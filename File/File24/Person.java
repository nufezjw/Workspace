package File24;

import java.io.Serializable;

public class Person implements Serializable /*��ǽӿ� */{
/**
	 * 
	 */
private static final long serialVersionUID = 9527;//���к�   ��ʾ���еİ汾

//transient�ؼ���   �Ǿ�̬���ݲ��뱻���л�����ʹ������ؼ���
public transient String name;
private static int age;//���ᱻд��Ӳ���� ��Ϊstatic�����ڷ����� ���ڶ���  ObjectOutputStreamд��ķ�˲��Ǿ�̬������
public Person(String name, int age) {
	// TODO Auto-generated constructor stub
	this.name=name;
	this.age=age;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
