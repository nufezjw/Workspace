package fileclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
 * PrintStream:
 * 1.�ṩ�˴�ӡ�������ԶԶ�����������ֵ���д�ӡ�����������ݵı�ʾ��ʽ
 * 2.�����׳�IOException
 *
 * ���캯���������������͵�ֵ��
 * 1.�ַ���·��
 * 2.File����
 * 3.�ֽ������
 */
		PrintStream out=new PrintStream("print.txt");
		out.print(97); //��97�ȱ���ַ�,Ȼ�󱣳�ԭ�������ݴ�ӡ��Ŀ�ĵ�
		out.write(610);//��ʾ���Ϊb����Ϊwrite()����ֻд���8λ
		out.close();
	}

}
