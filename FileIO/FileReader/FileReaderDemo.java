package FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         FileReader fr=new FileReader("demo.txt");
         
         //����һ���ַ����飬���ڴ洢�������ַ�
         //read(char[]) �����ǽ��ַ��������飬���ص��Ƕ������ַ��ĸ���
         char[] buf=new char[1024];
         int num=0;
         while((num=fr.read(buf))!=-1) {
        	 System.out.println(new String(buf,0,num));//���ַ����String,����������ַ��������������������
         }
         fr.close();//�ر��ļ���
	}

}
