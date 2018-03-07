/**
 * 需求：对指定目录进行所有内容的列出（包含子目录中的内容）
 * 也可以理解为深度遍历  listfile()
 */
package fileclass;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
File dir=new File("G:\\Onedrive\\格拉斯哥文件");
listAll(dir);
	}

	private static void listAll(File dir) {
		// TODO Auto-generated method stub
	
		
		File[] file=dir.listFiles();
		
		for(int i=0;i<file.length;i++) {
			if(file[i].isDirectory()) {
				listAll(file[i]);
			}
			else
		        System.out.println(file[i].getAbsolutePath());
			}	
	}
}
