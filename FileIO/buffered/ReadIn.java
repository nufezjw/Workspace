/*
 * ��ȡ����¼��

 System.out:��Ӧ���Ǳ�׼����豸������̨
 System.in:��Ӧ���Ǳ�׼�����豸������
 
 
 ����
 ͨ������¼������
��¼��һ�����ݺ󣬾ͽ��������ݽ��д�ӡ
���¼���������over,��ôֹͣ¼��

ͨ���ղż���¼��һ�����ݲ���ӡ���д��������ʵ���Ƕ�һ�����ݵ�ԭ��
Ҳ����readLine()����
�ܲ���ֱ��ʹ��readLine()��������ɼ���¼���һ�����ݵĶ�ȡ�أ�
readLine()������BufferedReader���еķ���
������¼���read()�������ֽ���InputStream�ķ���
��ô�ܲ��ܽ��ֽ���ת��Ϊ�ַ�����  InputStreamReader()����  �ֽ���תΪ�ַ���  ����BufferdReader�����readLine()����

InputStreamReader();
 */
package buffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;


public class ReadIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 
		 * һ��һ�еĶ�ȡ���ݵķ�ʽ
		 */
//  InputStream in = System.in;   //�Ӽ��̶�ȡ����
//  int ch=0;
//  StringBuilder sb=new StringBuilder();
//  while(true) {
//	  ch=in.read();
//	  if(ch=='\r')
//		  continue;
//	  if(ch=='\n')
//	  {
//		  String s=sb.toString();
//	      if(s.equals("over"))
//	    	  break;
//	      else
//	      System.out.println(s.toUpperCase());
//	      sb.delete(0, s.length()); //ɾ��sb�е�����
//       }else
//	      sb.append((char)ch);
//
//}
		/**
		 * ���ֽ���ת��Ϊ�ַ�������readLine()��������ȡһ������
		 */
		/*��ȡ����¼�����*/
		InputStream in=System.in;
		int ch=0;
		//���ֽ���ת��Ϊ�ַ�������ʹ��ת����InputStreamReader()
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader bf=new BufferedReader(isr);
		
		//�ȼ���   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in)
		String line=null;
		while((line=bf.readLine())!=null) {
			System.out.println(line.toUpperCase());
		}
		bf.close(); //�ǵùر���
		
  }
	}
