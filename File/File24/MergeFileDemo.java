package File24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import javax.sound.midi.Sequence;

public class MergeFileDemo {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir=new File("G:\\partfiles");
	    MergeFileDemo.MergeFile_2(dir);
	}
	
	public static void MergeFile(File dir) throws IOException {
		ArrayList<FileInputStream> al=new ArrayList<FileInputStream>();
		for(int i=1;i<=5;i++) {
			al.add(new FileInputStream(new File(dir,i+".part")));
			
		}
		Enumeration<FileInputStream> en=Collections.enumeration(al);
		SequenceInputStream sis=new SequenceInputStream(en);
		FileOutputStream fos=new FileOutputStream(new File(dir,"1.pdf"));
		int len=0;
		byte[] bf=new byte[1024];
		while((len=sis.read(bf))!=-1) {
			fos.write(bf, 0, len);
			
		}
		fos.close();
		
		sis.close();
		
	}
	public static void MergeFile_2(File dir) throws IOException {
		File[] files=dir.listFiles(new Suffixfilter(".properties"));//利用文件过滤器来过滤初dir中后缀名为.properties的文件
		if(files.length!=1)
			throw new RuntimeException("配置文件数量不对，存在异常信息");
		//记录配置文件对象
		File configurefile=files[0];
		
		//获取配置文件信息  
		FileInputStream fis=new FileInputStream(configurefile);
		Properties ppt=new Properties();
		ppt.load(fis);
        int count=Integer.parseInt(ppt.getProperty("partcount"));	//获取配置文件中的信息 partcount
        String name=ppt.getProperty("FileName");//获取配置文件中的信息 FileName
        
        //获取碎片数量，检验是否符合配置文件中的数量，如果不符合，没有必要拿流对其进行关联
        File[] partfiles=dir.listFiles(new Suffixfilter(".part"));
        if(partfiles.length!=(count-1))
            throw new RuntimeException("碎片文件数量不对，无法进行相应的合并");
        
        ArrayList<FileInputStream> al=new  ArrayList<FileInputStream>();
        for(int i=0;i<partfiles.length;i++)
        	al.add(new FileInputStream(partfiles[i]));
        Enumeration<FileInputStream> en=Collections.enumeration(al);
        SequenceInputStream sis=new SequenceInputStream(en);
        FileOutputStream fos=new FileOutputStream("G:\\2.pdf");
        int len=0;
        byte[] bf=new byte[1024];
        while((len=sis.read(bf))!=-1) {
        	fos.write(bf,0,len);
        	
        }
        fos.close();
        fis.close();
        	
        
        	
	}

}
