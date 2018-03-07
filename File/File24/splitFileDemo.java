/*52-IO�� �ļ��и�  splitfileDemo
�����иʽ 1.�����ļ���С 2.�����ļ�����
1.	�����ļ���С�����и�
�м����ļ�����Ҫ�����������һ���ļ�����һ����
*/
package File24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class splitFileDemo {

private static final int SIZE = 1024*1024;
public static void main(String[] args) throws IOException {
File file=new File("G:\\1.pdf");
splitFile_2(file);
}

public static void splitFile(File file) throws IOException {
	//�ö�ȡ������Դ�ļ�
	FileInputStream fis=new FileInputStream(file);
    //����һ��1M�Ļ�����
    byte[] bf=new byte[SIZE];
		
	File dir=new File("G:\\partfiles")	;
	if(!dir.exists()) 
		dir.mkdirs();
   
	FileOutputStream fos=null;
	int len=0;
	int count=1;
	while((len=fis.read(bf))!=-1) {
		fos=new FileOutputStream(new File(dir,(count++)+".part"));
		fos.write(bf,0,len);
		fos.close();
	}
	fis.close();}


/*
 * �и��ļ�ʱ�������¼���и���ļ������ƣ��Լ��и�������ļ����������Է���ϲ�
 * �����ϢΪ�˽���������ʹ�ü�ֵ�Եķ�ʽ���õ���properties����
 */
public static void splitFile_2(File file) throws IOException {
	File dir=new File("G:\\partfiles")	;
	if(!dir.exists()) 
		dir.mkdirs();
	//�ö�ȡ������Դ�ļ�
		FileInputStream fis=new FileInputStream(file);
	    //����һ��1M�Ļ�����
	    byte[] bf=new byte[SIZE];
	    FileOutputStream fos=null;
		int len=0;
		int count=1;
		while((len=fis.read(bf))!=-1) {
			fos=new FileOutputStream(new File(dir,(count++)+".part"));
			fos.write(bf,0,len);
			fos.close();
		}
		Properties ppt=new Properties();
		
		ppt.setProperty("partcount", count+"");
		ppt.setProperty("FileName", file.getName());
		fos=new FileOutputStream(new File(dir,count+".properties"));
		ppt.store(fos, "save the information");
		fos.close();
	    
		fis.close();}
}

