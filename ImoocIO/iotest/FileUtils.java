package iotest;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.synth.SynthSeparatorUI;

//�г�File��һЩ���ò���������ˡ������Ȳ���

public class FileUtils {
	/**
	 * �г��ƶ�Ŀ¼�£���������Ŀ¼���������ļ�
	 * @param dir
	 * @throws IOException
	 */
    public static void listDirectory(File dir)throws IOException{
    	if(!dir.exists()) {//�ж�Ŀ¼dir�Ƿ����
    		throw new IllegalArgumentException("Ŀ¼��"+dir+"�����ڡ�");
    	}
        if(!dir.isDirectory()) {//�ж�dir�Ƿ���Ŀ¼   isDirectory()
    	    throw new IllegalArgumentException(dir+"����Ŀ¼");
    }
//    String[] filenames=  dir.list(); //dir.list()���ص���һ��String���� ֱ�����ӵ����ƣ�����������Ŀ¼�µ��ļ�
//     for(String string:filenames) {  //���б�������
//  	  System.out.println(dir+"\\"+string);//����dir��Ϊ���ڴ�ӡ���ʱ����ļ��ĸ�Ŀ¼
//
// 	  }
        
        /**
         * ���Ҫ������Ŀ¼�µ����ݾ���Ҫ����ɶ�File�������ݹ����
         */
      File[] files=dir.listFiles();//���ص���ֱ����Ŀ¼���ļ����ĳ���
      if(files!=null&&files.length>0) {
    	  for(File file:files) {
    		  if(file.isDirectory()) { //�ݹ����
    			  listDirectory(file);
    		  }
    		  else
    			  System.out.println(file);
      }
      
   
    	 
      }
    }
    
    
}
