/**
1.源：键盘录入
  目的：控制台
  
2.需求：想把键盘录入的数据存储到一个文件中
  源：键盘
  目的：文件

流操作的基本规律：
最痛苦的就是流对象很多，不知道该用哪个

通过两个明确来完成
1.明确源和目的
  源：输入流。InputStream Reader
 目的：输出流 OutputStream Writer
2.操作的数据是否为纯文本
是：字符流
不是：字节流
3.当体系明确后，再明确要使用哪个具体的对象
通过设备来进行区分：
源设备：内存，硬盘，键盘
目的设备：内存，硬盘，控制台

*****************************************
2.需求：将键盘录入的数据保存到一个文件中
       这个需求中有源和目的都存在
    那么分别分析
    源：InputStream Reader
    是不是纯文本 ？是！Reader
  
   设备：键盘  对应的对象是System.in
  不是选择Reader吗？System.in对应的不是字节流吗？
  为了操作键盘的文本数据方便，我们使用转换流将字节流转换成字符流
  InputStreamReader
  
  InputSteamReader isr=new InputStreamReader(System.in);
  需要提高效率吗？需要  BufferedReader
  BufferedReader bufr=new BufferedReader(isr);
  
  目的：OutputStream Writer
  是否是纯文本？是！Writer
  FileWriter fw=new FileWriter("c.txt");
  需要提高效率吗？需要！ BufferedWriter
  BufferedWriter bw=new BufferedWriter(fw);
  
  扩展部分：********
  想要将录入的数据按照制定的编码表（utf-8)，将数据存到文件中
  
  FileWriter是使用默认的编码表 GBK
  
  但是存储时，需要加入指定的编码表utf-8,而指定的编码表只有转换流可以指定
  所以要使用转换流 OutputStreamWriter
  OutputStreamWriter opsw=new OutputStreamWriter("d.txt","utf-8");
  需要高效吗？需要 
  BufferedWriter bufw=new BufferdWriter(osw);
  
  
  
 */
package IOstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.setIn(new FileInputStream("PersonDemo.java"));      //改变输入流   改为从文件夹
System.setOut(new PrintStream("zzz.txt"));            //改变输出流
BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\11123.txt")));
String line=null;
while((line=bufr.readLine())!=null) {
	if(line.equals("over"))
		break;
	bufw.newLine();
	bufw.write(line);
	bufw.flush();     //务必记得刷新
}
bufw.close();
bufr.close();
	
	}
}
