package fileclass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterDemo {
/*
 * PrintWriter���ַ���ӡ��
 * ���캯��������
 * 1.�ַ���·��
 * 2.File����
 * 3.�ֽ������
 * 4.�ַ������
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
//PrintWriter out=new PrintWriter(System.out,true);
		//new PrintWriter(OutputStream,true)�Զ�ˢ�»�����������������������Чprintln  printf format
PrintWriter out=new PrintWriter(new FileWriter("out.txt"),true);//���ļ������װ��һ���ַ������
String line=null;
while((line=bfr.readLine())!=null) {
	if(line.equals("over"))
		break;
	out.println(line.toUpperCase());
//	out.flush();
}
out.close();
bfr.close();

	}

}
