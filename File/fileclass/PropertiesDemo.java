/**
 * Map
 *   |--Hashtable
 *      |--Properties
 * Properties集合：
 * 特点：
 * 1.该集合中的键和值都是字符串类型
 * 2.集合中的数据可以保存到流中，或者从流中获取
 * 
 * 通常该集合用于操作以键值对形式存在的配置文件
 * 
 * 
 */
package fileclass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		test();
	}
	public static void PropertiesDemo1() {
		Properties ppd=new Properties();
		ppd.setProperty("zhangsan","20");
		ppd.setProperty("lisi", "21");
		ppd.setProperty("wangwu", "23");
	
		Set<String> names=ppd.stringPropertyNames();//返回键的集合
		for(String name:names) {
			String value=ppd.getProperty(name);//获取值
			System.out.println(name+":"+value);
		}
		
	}
	/**
	 * 演示集合和流对象结合的功能
	 * public void list(PrintStream out)将属性列表输出到指定的输出流。此方法对调试很有用。 
	 */
	public static void PropertiesDemo2() {
		Properties ppd=new Properties();
		ppd.setProperty("zhangsan","20");
		ppd.setProperty("lisi", "21");
		ppd.setProperty("wangwu", "23");
		ppd.list(System.out);        
	}  
	/*
	 * method_3：store(OutputStream stream,comment)
	 * 想要将这些集合中的字符串键值信息持久化存储到文件中 （也就是写入到硬盘）
	 * 需要关联输出流 
	 * 将集合中的数据存储到文件中，使用store方法
	 */
	public static void method_3() throws IOException {
		Properties ppd=new Properties();
		ppd.setProperty("zhangsan","20");
		ppd.setProperty("lisi", "21");
		ppd.setProperty("wangwu", "23");
		FileOutputStream fops=new FileOutputStream("info.txt");
		ppd.store(fops, "Name+age");
		fops.close();//记得关闭流 释放资源
	}
	
	public static void menthod_4() throws IOException {
		FileInputStream fis=new FileInputStream("info.txt");
		Properties ppd=new Properties();
		ppd.load(fis);  //load()方法将文件导入进来
		ppd.list(System.out);
	}
	
	
	/*以下编码对于load()方法进行模拟操作
	 * 
	 */
	public static void Myload() throws IOException {
		FileReader fis=new FileReader("info.txt");
		Properties ppd=new Properties();
		BufferedReader bfr=new BufferedReader(fis);
		String line=null;
		while((line=bfr.readLine())!=null) {
			if(line.startsWith("#"))  //如果该行是以#开头 表明是comments内容 无需关注输出
				continue;
			String[] arr=line.split("=");// 将行内容分割开  存储到数组中去
			System.out.println(arr[0]+"::"+arr[1]);
		}
		
	}
	/*对已有的配置文件中的信息进行修改
	 * 读取这个文件
	 * 并将这个文件中的键值数据存储到集合中
	 * 再通过集合对数据进行修改
	 * 在通过流将修改后的数据存储到文件中
	 * 
	 */
	public static void test() throws IOException {
		File file=new File("info.txt");
		if(!file.exists())
			file.createNewFile();
		FileReader fr=new FileReader(file);
		Properties ppt=new Properties();
		ppt.load(fr);
		ppt.list(System.out);
		ppt.setProperty("wangwu", "100");
		FileWriter fw=new FileWriter(file);
		ppt.store(fw,"");
	}
}
