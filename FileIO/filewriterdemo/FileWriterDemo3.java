package filewriterdemo;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw=null;
    //����һ��true�����������������е��ļ������������ļ���ĩβ������������ϰ  	
        try {
		fw=new FileWriter("demo.txt",true);
        fw.write("abcdef\r\nnihaohaha"); //windows����\r\n��ʾ����
        }
        catch(IOException e) {
        	System.out.println(e.toString());
        }finally {
        	try {
        	    if(fw!=null)   //����ļ���ʼ��ʧ�ܣ���fwΪ�գ�������쳣
                    fw.close();//�м�һ��Ҫ�ر�������
	        }catch(IOException e) {
		        System.out.println(e.toString());
	}
	}
	}
	}

