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
 * PrintWriter：字符打印流
 * 构造函数参数：
 * 1.字符串路径
 * 2.File对象
 * 3.字节输出流
 * 4.字符输出流
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
//PrintWriter out=new PrintWriter(System.out,true);
		//new PrintWriter(OutputStream,true)自动刷新缓冲区，仅仅对三个方法有效println  printf format
PrintWriter out=new PrintWriter(new FileWriter("out.txt"),true);//将文件对象包装成一个字符输出流
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
