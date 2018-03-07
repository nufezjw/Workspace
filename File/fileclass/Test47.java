/*
 * 获取指定目录下面，指定扩展名的文件(包含子目录中）
 * 这些文件的绝对路径写入到一个文本文件中
 * In a word,就是建立一个指定扩展名的文件的列表
 * 
 * 思路如下：
 * 1.必须进行深度遍历
 * 2.要在遍历的过程中进行过滤，将符合条件的内容都存储到容器中
 * 3.对容器中的内容进行遍历并将绝对路径写入到文件中
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
     File dir=new File("C:\\Users\\Jerry\\Desktop\\Java学习记录");
     //匿名内部类
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
	 * 对指定目录中的内容进行深度遍历，并按照指定过滤器，进行过滤
	 * 将过滤后的内容存储到制定容器List中
	 * @param dir
	 * @param filter
	 * @param list
	 */
    public static void getFiles(File dir,FilenameFilter filter,List<File> list)throws IOException {
    	File[] files=dir.listFiles();
    	for(File file:files) {
    		//进行递归处理
    		if(file.isDirectory())
    			getFiles(file, filter, list);
    		else {
    			//利用过滤器进行过滤操作
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
    		    throw new RuntimeException("写入失败了");
    		
    	    }finally {
    	    	if(bufw!=null)
    		   try {
				
				    bufw.close();	
			} catch (Exception e) {
				throw new RuntimeException("关闭失败");
			}
    	}
    	
    }
    }
