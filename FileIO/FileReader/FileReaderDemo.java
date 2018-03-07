package FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         FileReader fr=new FileReader("demo.txt");
         
         //定义一个字符数组，用于存储读到的字符
         //read(char[]) 功能是将字符读入数组，返回的是读到的字符的个数
         char[] buf=new char[1024];
         int num=0;
         while((num=fr.read(buf))!=-1) {
        	 System.out.println(new String(buf,0,num));//将字符变成String,输出读到的字符，读到几个就输出几个
         }
         fr.close();//关闭文件流
	}

}
