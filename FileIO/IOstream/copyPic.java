/*
 ����һ��ͼƬ
 1.���ֽڶ�ȡ�������ͼƬ����
 2.���ֽ�д�������󴴽�һ��ͼƬ�ļ������ڴ洢��ȡ��ͼƬ
 3.ͨ��ѭ����д��������ݵĴ洢
 4.�ر���Դ
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
			throw new RuntimeException("����ʧ��");
		}finally 
		{
		  try {
			if(fis!=null)
				fis.close();
		} catch ( Exception e) {
			throw new RuntimeException("ͼƬ��ȡʧ��");
		}
		  try {
				if(fos!=null)
					fos.close();
			} catch ( Exception e) {
				throw new RuntimeException("ͼƬд��ʧ��");
			}
		}

	}

}
