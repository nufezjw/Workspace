/*
 * װ�����ģʽ��
 ����Ҫ�����еĶ�����й�����ǿʱ��
 ��ô���Զ����࣬�����ж����룬�������еĹ��ܣ����ṩ��ǿ���ܡ�
 ��ô�Զ���ĸ����Ϊװ���� SuperPerson��Ϊװ����
 
 װ����ͨ����ͨ�����췽�����ֱ�װ�εĶ���
 �����ڱ�װ�εĶ���Ĺ��ܣ��ṩ��ǿ�Ĺ��ܣ���ʵBufferedReaderҲ��һ���ĵ���
 */
package Decoration;

public class Person {
	
	public void chifan() {
		System.out.println("�Է�");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Person p=new Person();
        // p.chifan();
         SuperPerson sp=new SuperPerson(p);
         sp.SuperChifan();
	}

}
