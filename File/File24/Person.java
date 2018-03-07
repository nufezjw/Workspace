package File24;

import java.io.Serializable;

public class Person implements Serializable /*标记接口 */{
/**
	 * 
	 */
private static final long serialVersionUID = 9527;//序列号   表示序列的版本

//transient关键字   非静态数据不想被序列化可以使用这个关键字
public transient String name;
private static int age;//不会被写到硬盘上 因为static数据在方法区 不在堆中  ObjectOutputStream写入的非瞬间非静态的数据
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
