/*
 �ַ���:
 FileReader()
 FileWriter()
 BufferedReader()
 BufferedWriter()
 �ֽ�����
 InputStream()
 OutputStream()
 ������Ҫ����ͼƬ���ݣ���ʱ��Ҫ�õ��ֽ���
 
 ע���ֽں��ַ�֮����ôת��
 �ַ����ֽ� ��
'abcderf'.getBytes()

 �ֽڵ��ַ� ��
 byte[] byBuffer=new byte[1024]
 String s=new String(byBuffer) 
 s=s.copyValueOf(s.toCharArray(),0,byBuffer.length());
 
 */
package IOstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
/**
 * ��ȡ�ֽ������� ����һ
 * @throws IOException
 */
	public static void filereader_1() throws IOException {
		FileInputStream fis=new FileInputStream("fops.txt");
		int ch=0;
		while((ch=fis.read())!=-1) {
			System.out.println((char)ch);
		}
		fis.close();
	}
	/**
	 * ��ȡ�ֽ������� ������
	 * @throws IOException
	 */
	public static void filereader_2() throws IOException{
		FileInputStream fis=new FileInputStream("fops.txt");
		byte[] byBuffer=new byte[1024];
		int ch=0;
		while((ch=fis.read(byBuffer))!=-1) {
			System.out.println(new String(byBuffer,0,byBuffer.length));
		}
	}
	
	/**
	 * ��ȡ�ֽ������� ������
	 * @throws IOException
	 */
	public static void filereader_3() throws IOException{
		FileInputStream fis=new FileInputStream("fops.txt");
		int ch=fis.available();//���ص����ļ��е��ֽ���
		byte[] byBuffer=new byte[ch];//����һ����С�ոպõĻ�����,����������  ����  Ҫ�����ݺܴ�  ���ܳ����ڴ��������
		fis.read(byBuffer);
		System.out.println(new String(byBuffer));
		fis.close();
		}
	
    public static void filewriter() throws IOException {
    	FileOutputStream ops=new FileOutputStream("fops.txt");
    	ops.write("woshifops.txt".getBytes());
    	ops.close();//FileOutputStreamû��ˢ�¹��ܣ���������Ҫ�ǵùر������ͷ���Դ
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   FileStream.filereader_3();
	}

}
