/*52-IO流 文件切割  splitfileDemo
两种切割方式 1.按照文件大小 2.按照文件数量
1.	按照文件大小进行切割
有几个文件就需要几个输出流，一个文件关联一个流
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
	//用读取流关联源文件
	FileInputStream fis=new FileInputStream(file);
    //定义一个1M的缓冲区
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
 * 切割文件时，必须记录被切割的文件的名称，以及切割出来的文件的数量，以方便合并
 * 这个信息为了进行描述，使用键值对的方式，用到了properties对象
 */
public static void splitFile_2(File file) throws IOException {
	File dir=new File("G:\\partfiles")	;
	if(!dir.exists()) 
		dir.mkdirs();
	//用读取流关联源文件
		FileInputStream fis=new FileInputStream(file);
	    //定义一个1M的缓冲区
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

