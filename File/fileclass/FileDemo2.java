package fileclass;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2 implements FilenameFilter {
	
private String type;	

public FileDemo2(String type) {
	this.type=type;
}


public static void listDemo() {
	File f=new File("C:\\");
	FileDemo2 fd=new FileDemo2(".doc");
	String[] names=f.list(fd);//调用list()方法的file对象必须是封装了一个目录，该目录还必须存在。
	for(String name:names) {
		System.out.println(name);
	}
}
	
	public static void listRootsDemo() {
		File[] files=File.listRoots();
	    for(File f:files) {
	    	System.out.println(f);
	    }}
	    
	 public static void main(String[] args) {
			FileDemo2.listDemo();
		    
	 }


	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(type);
	}
	}

