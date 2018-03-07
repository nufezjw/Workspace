package filewriterdemo;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw=null;
    //传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾处进行数据练习  	
        try {
		fw=new FileWriter("demo.txt",true);
        fw.write("abcdef\r\nnihaohaha"); //windows中用\r\n表示换行
        }
        catch(IOException e) {
        	System.out.println(e.toString());
        }finally {
        	try {
        	    if(fw!=null)   //如果文件初始化失败，则fw为空，会出现异常
                    fw.close();//切记一定要关闭数据流
	        }catch(IOException e) {
		        System.out.println(e.toString());
	}
	}
	}
	}

