/**
 * Map
 *   |--Hashtable
 *      |--Properties
 * Properties���ϣ�
 * �ص㣺
 * 1.�ü����еļ���ֵ�����ַ�������
 * 2.�����е����ݿ��Ա��浽���У����ߴ����л�ȡ
 * 
 * ͨ���ü������ڲ����Լ�ֵ����ʽ���ڵ������ļ�
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
	
		Set<String> names=ppd.stringPropertyNames();//���ؼ��ļ���
		for(String name:names) {
			String value=ppd.getProperty(name);//��ȡֵ
			System.out.println(name+":"+value);
		}
		
	}
	/**
	 * ��ʾ���Ϻ��������ϵĹ���
	 * public void list(PrintStream out)�������б������ָ������������˷����Ե��Ժ����á� 
	 */
	public static void PropertiesDemo2() {
		Properties ppd=new Properties();
		ppd.setProperty("zhangsan","20");
		ppd.setProperty("lisi", "21");
		ppd.setProperty("wangwu", "23");
		ppd.list(System.out);        
	}  
	/*
	 * method_3��store(OutputStream stream,comment)
	 * ��Ҫ����Щ�����е��ַ�����ֵ��Ϣ�־û��洢���ļ��� ��Ҳ����д�뵽Ӳ�̣�
	 * ��Ҫ��������� 
	 * �������е����ݴ洢���ļ��У�ʹ��store����
	 */
	public static void method_3() throws IOException {
		Properties ppd=new Properties();
		ppd.setProperty("zhangsan","20");
		ppd.setProperty("lisi", "21");
		ppd.setProperty("wangwu", "23");
		FileOutputStream fops=new FileOutputStream("info.txt");
		ppd.store(fops, "Name+age");
		fops.close();//�ǵùر��� �ͷ���Դ
	}
	
	public static void menthod_4() throws IOException {
		FileInputStream fis=new FileInputStream("info.txt");
		Properties ppd=new Properties();
		ppd.load(fis);  //load()�������ļ��������
		ppd.list(System.out);
	}
	
	
	/*���±������load()��������ģ�����
	 * 
	 */
	public static void Myload() throws IOException {
		FileReader fis=new FileReader("info.txt");
		Properties ppd=new Properties();
		BufferedReader bfr=new BufferedReader(fis);
		String line=null;
		while((line=bfr.readLine())!=null) {
			if(line.startsWith("#"))  //�����������#��ͷ ������comments���� �����ע���
				continue;
			String[] arr=line.split("=");// �������ݷָ  �洢��������ȥ
			System.out.println(arr[0]+"::"+arr[1]);
		}
		
	}
	/*�����е������ļ��е���Ϣ�����޸�
	 * ��ȡ����ļ�
	 * ��������ļ��еļ�ֵ���ݴ洢��������
	 * ��ͨ�����϶����ݽ����޸�
	 * ��ͨ�������޸ĺ�����ݴ洢���ļ���
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
