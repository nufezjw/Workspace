package iotest;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.synth.SynthSeparatorUI;

//列出File的一些常用操作比如过滤、遍历等操作

public class FileUtils {
	/**
	 * 列出制定目录下（包括其子目录）的所有文件
	 * @param dir
	 * @throws IOException
	 */
    public static void listDirectory(File dir)throws IOException{
    	if(!dir.exists()) {//判断目录dir是否存在
    		throw new IllegalArgumentException("目录："+dir+"不存在。");
    	}
        if(!dir.isDirectory()) {//判断dir是否是目录   isDirectory()
    	    throw new IllegalArgumentException(dir+"不是目录");
    }
//    String[] filenames=  dir.list(); //dir.list()返回的是一个String数组 直接是子的名称，并不包含子目录下的文件
//     for(String string:filenames) {  //进行遍历操作
//  	  System.out.println(dir+"\\"+string);//加上dir是为了在打印输出时输出文件的父目录
//
// 	  }
        
        /**
         * 如果要遍历子目录下的内容就需要构造成对File对象做递归操作
         */
      File[] files=dir.listFiles();//返回的是直接子目录（文件）的抽象
      if(files!=null&&files.length>0) {
    	  for(File file:files) {
    		  if(file.isDirectory()) { //递归操作
    			  listDirectory(file);
    		  }
    		  else
    			  System.out.println(file);
      }
      
   
    	 
      }
    }
    
    
}
