package Decoration;
/*
 * LineNumberReader װ�� 
 * �������÷�����
 * getLineNuber()��ȡ�к�
 * setLineNumber()������ʼ�к�
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {

	public static void main(String[] args) throws IOException {
		 FileReader fr=null;
		 LineNumberReader lnr=null;
		 try {
         fr=new FileReader("Person.java");
         lnr=new LineNumberReader(fr);
         String line=null;
         lnr.setLineNumber(100);//������ʼ���к�Ϊ100
         while((line=lnr.readLine())!=null) {
        	 System.out.println(lnr.getLineNumber()+":"+line);
         }
		 }catch(IOException e) {
			System.out.println(e.toString());
		 }finally {
			 try {
			 if(lnr!=null) 
				 lnr.close();
			 }catch(IOException e) {
				 e.toString();
			 }
		    	 
		     }
			 
		 
         
	
	
	}}

