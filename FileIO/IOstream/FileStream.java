/*
 字符流:
 FileReader()
 FileWriter()
 BufferedReader()
 BufferedWriter()
 字节流：
 InputStream()
 OutputStream()
 需求：想要操作图片数据，这时就要用到字节流
 
 注意字节和字符之间怎么转换
 字符到字节 ：
'abcderf'.getBytes()

 字节到字符 ：
 byte[] byBuffer=new byte[1024]
 String s=new String(byBuffer) 
 s=s.copyValueOf(s.toCharArray(),0,byBuffer.length());
 
 */
package IOstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
/**
 * 读取字节流数据 方法一
 * @throws IOException
 */
	public static void filereader_1() throws IOException {
		FileInputStream fis=new FileInputStream("fops.txt");
		int ch=0;
		while((ch=fis.read())!=-1) {
			System.out.println((char)ch);
		}
		fis.close();
	}
	/**
	 * 读取字节流数据 方法二
	 * @throws IOException
	 */
	public static void filereader_2() throws IOException{
		FileInputStream fis=new FileInputStream("fops.txt");
		byte[] byBuffer=new byte[1024];
		int ch=0;
		while((ch=fis.read(byBuffer))!=-1) {
			System.out.println(new String(byBuffer,0,byBuffer.length));
		}
	}
	
	/**
	 * 读取字节流数据 方法三
	 * @throws IOException
	 */
	public static void filereader_3() throws IOException{
		FileInputStream fis=new FileInputStream("fops.txt");
		int ch=fis.available();//返回的是文件中的字节数
		byte[] byBuffer=new byte[ch];//定义一个大小刚刚好的缓冲区,不用再数了  慎用  要是数据很大  可能出现内存溢出现象
		fis.read(byBuffer);
		System.out.println(new String(byBuffer));
		fis.close();
		}
	
    public static void filewriter() throws IOException {
    	FileOutputStream ops=new FileOutputStream("fops.txt");
    	ops.write("woshifops.txt".getBytes());
    	ops.close();//FileOutputStream没有刷新功能，但是我们要记得关闭流，释放资源
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   FileStream.filereader_3();
	}

}
