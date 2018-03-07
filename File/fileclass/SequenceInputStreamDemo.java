package fileclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * 需求：将1.txt 2.txt 3.txt文件中的数据合并到一个文件中(4.txt)
		 * 
		 * 
		 */
		
//		Vector<FileInputStream> v=new Vector<FileInputStream>();
//		v.add(new FileInputStream("1.txt"));
//		v.add(new FileInputStream("2.txt"));
//		v.add(new FileInputStream("3.txt"));
//		Enumeration<FileInputStream> en=v.elements();
		ArrayList<FileInputStream> al=new ArrayList<FileInputStream>();
		for(int i=1;i<=3;i++) {
			al.add(new FileInputStream(i+".txt"));
		}
		
		Enumeration<FileInputStream> en=Collections.enumeration(al);
//		Iterator<FileInputStream> it=al.iterator();
//		Enumeration<FileInputStream> en=new Enumeration<FileInputStream>() {//匿名内部类
//
//			@Override
//			public boolean hasMoreElements() {
//				// TODO Auto-generated method stub
//				return it.hasNext();
//			}
//
//			@Override
//			public FileInputStream nextElement() {
//				// TODO Auto-generated method stub
//				return it.next();
//			}
		
//		};
		
		SequenceInputStream sis=new SequenceInputStream(en);
		FileOutputStream fos=new FileOutputStream("4.txt");
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=sis.read(buffer))!=-1) {
			fos.write(buffer,0,len);
			
		}
		fos.close();
		sis.close();

	}

}
