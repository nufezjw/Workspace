package fileclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * ���幦�ܣ���ȡһ��Ӧ�ó������еĴ��������������Σ�����ʹ�ô����ѵ���ע�����ʾ������Ҫ�����г���
 * 
 *˼·��
 *1.Ӧ���м�����
 *ÿ�γ�������ʱ������Ҫ����һ�Σ���������ԭ�еĻ����Ͻ��м���
 *2.����������һ��������ͻȻð��һ���뷨����������ʱ����м���������������������ڴ沢��������
 *�����ǳ����ѽ�����������Ҳ����ʧ����ô�ٴ������ó��򣬼������ֱ����³�ʼ����
 *��������Ҫ�������ͬһ��Ӧ�ó���ʹ�õ���ͬһ��������
 *�����Ҫ���������������ڱ䳤�����ڴ�洢��Ӳ���ļ���
 *
 *3.���ʹ�������������
 * ���ȣ���������ʱ��Ӧ���ȶ�ȡ������ڼ�¼��������Ϣ�������ļ�
 * ��ȡ��һ�μ��������������������ô������ж�
 * ��Σ��Ըô�����������������������Ĵ������´洢�������ļ���
 * 
 *4.�ļ��е���Ϣ����ν��д洢������
 *ֱ�Ӵ洢����ֵ���ԣ����ǲ���ȷ�����ݵĺ��壬�������ֱ�ú���Ҫ
  ����������ֺ�ֵ�Ķ�Ӧ�����Կ���ʹ�ü�ֵ��
  ������ӳ���ϵmap���ϸ㶨������Ҫ��ȡӲ���ϵ�����  map+io=Properties
 * @author Kevin
 *
 */

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		getCount();
}
	public static void getCount() throws IOException {
	
	//�������ļ���װ��File����
    File confile=new File("count.txt");
    if(!confile.exists()) {
    	confile.createNewFile();
    }
    FileInputStream fis=new FileInputStream(confile);
    Properties ppt=new Properties();
    ppt.load(fis);
    //�Ӽ�����ͨ������ȡ����
   String value;
   value=ppt.getProperty("time");
   //�������������¼��ȡ���Ĵ���
   int count=0;
    if(value!=null) {
    	count=Integer.parseInt(value);	
    	if(count>5)
    		throw new RuntimeException("ʹ�ô����ѵ�����Ǯ");
    }
    count++;
    //���ı��Ĵ�������д�뼯����
    ppt.setProperty("time", count+"");
    FileWriter fw=new FileWriter(confile);
    ppt.store(fw,"");}
}


