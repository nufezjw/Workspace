/*
 * 读取键盘录入

 System.out:对应的是标准输出设备，控制台
 System.in:对应的是标准输入设备：键盘
 
 
 需求：
 通过键盘录入数据
当录入一行数据后，就将该行数据进行打印
如果录入的数据是over,那么停止录入

通过刚才键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理
也就是readLine()方法
能不能直接使用readLine()方法来完成键盘录入的一行数据的读取呢？
readLine()方法是BufferedReader类中的方法
而键盘录入的read()方法是字节流InputStream的方法
那么能不能将字节流转换为字符流呢  InputStreamReader()方法  字节流转为字符流  利用BufferdReader里面的readLine()方法

InputStreamReader();
 */
package buffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;


public class ReadIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 
		 * 一行一行的读取数据的方式
		 */
//  InputStream in = System.in;   //从键盘读取数据
//  int ch=0;
//  StringBuilder sb=new StringBuilder();
//  while(true) {
//	  ch=in.read();
//	  if(ch=='\r')
//		  continue;
//	  if(ch=='\n')
//	  {
//		  String s=sb.toString();
//	      if(s.equals("over"))
//	    	  break;
//	      else
//	      System.out.println(s.toUpperCase());
//	      sb.delete(0, s.length()); //删除sb中的内容
//       }else
//	      sb.append((char)ch);
//
//}
		/**
		 * 将字节流转换为字符流利用readLine()方法来读取一行数据
		 */
		/*获取键盘录入对象*/
		InputStream in=System.in;
		int ch=0;
		//将字节流转换为字符流对象，使用转换流InputStreamReader()
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader bf=new BufferedReader(isr);
		
		//等价于   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in)
		String line=null;
		while((line=bf.readLine())!=null) {
			System.out.println(line.toUpperCase());
		}
		bf.close(); //记得关闭流
		
  }
	}
