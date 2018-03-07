package copytext;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//将C盘一个文本文件复制到D盘
/*
 * 复制的原理：
 * 其实就是将C盘下的文件数据存储到D盘的一个文件中
步骤：
1.在D盘创建一个文件，用于存储C盘文件中的数据
2.定义读取流和C盘文件关联
3.通过不断读写完成数据存储
4.关闭资源
 */

public class CopyText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		copy_2();
	}
	//第一种方式从C盘读一个字符 ，就往D盘写一个
    public static void copy_1() throws IOException
    {
    	//创建目的地
    	FileWriter fw=new FileWriter("RuntimeDemo_copy.txt");
    	
    	//与已有文件进行关联
    	FileReader fr=new FileReader("Runtime.txt");
    	
    	int ch=0;
    	while((ch=fr.read())!=-1) {
    		fw.write(ch);
    	}
    	fw.close();
    	fr.close();
    }
    /**
     * 第二种复制方式  采用数组
     * @throws IOException
     */
    public static void copy_2() throws IOException {
        FileWriter fw=null;
        FileReader fr=null;
    	//创建目的地   要记得进行异常的处理 try-catch-finally
    try {	
    	fw=new FileWriter("RuntimeDemo_copy.txt");
    
    	
    	//与已有文件进行关联
    	 fr=new FileReader("Runtime.txt");
    	
    	char[] buf=new char[1024];
    	int num=0;
    	while((num=fr.read(buf))!=-1) {
    		fw.write(new String(buf,0,num));
    	}
    }catch(IOException e) {
    	throw new RuntimeException("无法读写");
    }finally {
    	
    	try{
    		if(fw!=null)
    		fw.close();
    	}
    	catch(IOException e) {
    		
    	}finally {
    		
    		try {
    			if(fr!=null) 
        	  	fr.close();
    	}catch(IOException e) {
    		
    	}
    	
    	
    }
    	
    }
	}

}
