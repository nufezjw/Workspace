/*
 * 演示mp3的复制，通过缓冲区
 * BufferedOutputStream
 * BufferedInputStram
 */
package IOstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class cpMp3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	long start=System.currentTimeMillis();
	cpMp3.copy_1();
	long end=System.currentTimeMillis();
	System.out.println("the time of copying is :"+(end-start)+"millisecond");
	}
	
	public static void copy_1() throws IOException {
    BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\1.jpg"));
    BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\2.jpg"));
    int ch=0;
    while((ch=bis.read())!=-1) {
    	bos.write(ch);
    }
    bis.close();
    bos.close();
	}

}
