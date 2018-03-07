package fileclass;
/**
 * File类
	用来将文件或者文件夹封装成对象
	方便对文件与文件夹进行操作
	File对象可以作为参数传递给流的构造函数
	了解File类中的常用方法

File 常见方法：
1.创建 boolean  File.createNewFile()   创建一个新的文件,创建成功，返回true  创建失败  返回false;若文件已经存在，返回false
2.删除 boolean  File.delete() 文件删除失败 返回false
      void  File.deleteOnExit() 文件在系统退出 后删除
3.判断
     boolean exists();文件是否存在
     isFile()
     isDirectory()
     isHidden();是否是隐藏的
     isAbsolute();是否是绝对路径
4.获取信息
     getName()          获取文件名
     getPath()          获取文件的相对路径
     getAbsolutePath()  获取文件的绝对路径
     getParent()      获取文件的父目录
long lastModified()   获取最后修改的时间
long length()         获取文件长度
     renameTo()       
 */


import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//     FileDemo.consMethod();
//		FileDemo.createFile();
//		File f=new File("D:\\ab.txt");
//		File f1=new File("D:\\avavad.txt");
//		System.out.println(f);
//		System.out.println("File:"+f.isFile());//返回false 在判断是否是文件或者目录前一定要判断该对象是否存在
//		f.createNewFile();
//		System.out.println(f.getParent());
//		System.out.println(f.renameTo(f1));
//		
		
	}
	public static void createFile() throws IOException {
		 File f=new File("xiaoming.txt");
	     f.deleteOnExit();//在系统退出的时候删除文件对象
		 System.out.println("Create:"+f.createNewFile());
		 System.out.println("Delete:"+f.delete());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void consMethod() {
		File f=new File("D:\\abc\\a.txt");
		File f1=new File("D:\\abc","b.txt");
		File f2=new File("D:\\abc");
		File f3=new File(f2,"c.txt");
		System.out.println("f:"+f);
		System.out.println("f1:"+f1);
		System.out.println("f2:"+f2);
		System.out.println("f3:"+f3);
//		File f4=new File("D:\\abc\\zzz\\a.txt");
		
		/*
		 * File.seperator方法是跨平台的分隔符 
		 */
		File f4=new File("D:"+File.separator+"abc"+File.separator+"zzz"+File.separator+"a.txt");
		System.out.println("f4:"+f4);
		
		
	}

}
