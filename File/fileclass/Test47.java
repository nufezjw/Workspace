/*
 * ��ȡָ��Ŀ¼���棬ָ����չ�����ļ�(������Ŀ¼�У�
 * ��Щ�ļ��ľ���·��д�뵽һ���ı��ļ���
 * In a word,���ǽ���һ��ָ����չ�����ļ����б�
 * 
 * ˼·���£�
 * 1.���������ȱ���
 * 2.Ҫ�ڱ����Ĺ����н��й��ˣ����������������ݶ��洢��������
 * 3.�������е����ݽ��б�����������·��д�뵽�ļ���
 */
package fileclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test47 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     File dir=new File("C:\\Users\\Jerry\\Desktop\\Javaѧϰ��¼");
     //�����ڲ���
     FilenameFilter filter=new FilenameFilter() {

		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			return name.endsWith(".docx");
		}
    	 
     };
     List<File> list=new ArrayList<File>();
    getFiles(dir,filter,list);
     File destFile=new File("123.txt");
     
     write2File(list,destFile);
	}

	/**
	 * ��ָ��Ŀ¼�е����ݽ�����ȱ�����������ָ�������������й���
	 * �����˺�����ݴ洢���ƶ�����List��
	 * @param dir
	 * @param filter
	 * @param list
	 */
    public static void getFiles(File dir,FilenameFilter filter,List<File> list)throws IOException {
    	File[] files=dir.listFiles();
    	for(File file:files) {
    		//���еݹ鴦��
    		if(file.isDirectory())
    			getFiles(file, filter, list);
    		else {
    			//���ù��������й��˲���
    			if(filter.accept(dir, file.getName()))
    				list.add(file);
    	}
    }
    }
    public static void write2File(List<File> list,File destFile) throws IOException {
    	BufferedWriter bufw=null;
    	try{
    		bufw=new BufferedWriter(new FileWriter(destFile));
    	    for(File file:list) {
    		    bufw.write(file.getAbsolutePath());
    		    bufw.newLine();
    		    bufw.flush();}
    	    }catch(IOException e) {
    		    throw new RuntimeException("д��ʧ����");
    		
    	    }finally {
    	    	if(bufw!=null)
    		   try {
				
				    bufw.close();	
			} catch (Exception e) {
				throw new RuntimeException("�ر�ʧ��");
			}
    	}
    	
    }
    }
