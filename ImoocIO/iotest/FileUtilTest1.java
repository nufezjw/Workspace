package iotest;

import java.io.File;
import java.io.IOException;

public class FileUtilTest1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
	
		/*列出该目录下的所有文件名，不包含子目录*/
    FileUtils.listDirectory(new File("C:\\Users\\Jerry\\eclipse-workspace\\ImoocIO"));     //静态方法直接通过类名调用
	}

}
