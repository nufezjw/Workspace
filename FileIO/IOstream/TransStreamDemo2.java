/**
1.Դ������¼��
  Ŀ�ģ�����̨
  
2.������Ѽ���¼������ݴ洢��һ���ļ���
  Դ������
  Ŀ�ģ��ļ�

�������Ļ������ɣ�
��ʹ��ľ���������ܶ࣬��֪�������ĸ�

ͨ��������ȷ�����
1.��ȷԴ��Ŀ��
  Դ����������InputStream Reader
 Ŀ�ģ������ OutputStream Writer
2.�����������Ƿ�Ϊ���ı�
�ǣ��ַ���
���ǣ��ֽ���
3.����ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
ͨ���豸���������֣�
Դ�豸���ڴ棬Ӳ�̣�����
Ŀ���豸���ڴ棬Ӳ�̣�����̨

*****************************************
2.���󣺽�����¼������ݱ��浽һ���ļ���
       �����������Դ��Ŀ�Ķ�����
    ��ô�ֱ����
    Դ��InputStream Reader
    �ǲ��Ǵ��ı� ���ǣ�Reader
  
   �豸������  ��Ӧ�Ķ�����System.in
  ����ѡ��Reader��System.in��Ӧ�Ĳ����ֽ�����
  Ϊ�˲������̵��ı����ݷ��㣬����ʹ��ת�������ֽ���ת�����ַ���
  InputStreamReader
  
  InputSteamReader isr=new InputStreamReader(System.in);
  ��Ҫ���Ч������Ҫ  BufferedReader
  BufferedReader bufr=new BufferedReader(isr);
  
  Ŀ�ģ�OutputStream Writer
  �Ƿ��Ǵ��ı����ǣ�Writer
  FileWriter fw=new FileWriter("c.txt");
  ��Ҫ���Ч������Ҫ�� BufferedWriter
  BufferedWriter bw=new BufferedWriter(fw);
  
  ��չ���֣�********
  ��Ҫ��¼������ݰ����ƶ��ı����utf-8)�������ݴ浽�ļ���
  
  FileWriter��ʹ��Ĭ�ϵı���� GBK
  
  ���Ǵ洢ʱ����Ҫ����ָ���ı����utf-8,��ָ���ı����ֻ��ת��������ָ��
  ����Ҫʹ��ת���� OutputStreamWriter
  OutputStreamWriter opsw=new OutputStreamWriter("d.txt","utf-8");
  ��Ҫ��Ч����Ҫ 
  BufferedWriter bufw=new BufferdWriter(osw);
  
  
  
 */
package IOstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.setIn(new FileInputStream("PersonDemo.java"));      //�ı�������   ��Ϊ���ļ���
System.setOut(new PrintStream("zzz.txt"));            //�ı������
BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\11123.txt")));
String line=null;
while((line=bufr.readLine())!=null) {
	if(line.equals("over"))
		break;
	bufw.newLine();
	bufw.write(line);
	bufw.flush();     //��ؼǵ�ˢ��
}
bufw.close();
bufr.close();
	
	}
}
