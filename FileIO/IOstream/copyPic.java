/*
 复制一个图片
 1.用字节读取流对象和图片关联
 2.用字节写入流对象创建一个图片文件，用于存储获取的图片
 3.通过循环读写，完成数据的存储
 4.关闭资源
 */
package IOstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class copyPic {

	public static void main(String[] args){
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try {
			fos=new FileOutputStream("D:\\2.jpg");
			fis=new FileInputStream("D:\\1.jpg");
			int ch=0;
			byte[] by=new byte[1024];
			while((ch=fis.read(by))!=-1) {
				fos.write(by,0,ch);
			}
		} catch (Exception e) {
			throw new RuntimeException("复制失败");
		}finally 
		{
		  try {
			if(fis!=null)
				fis.close();
		} catch ( Exception e) {
			throw new RuntimeException("图片读取失败");
		}
		  try {
				if(fos!=null)
					fos.close();
			} catch ( Exception e) {
				throw new RuntimeException("图片写入失败");
			}
		}

	}

}
