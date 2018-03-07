package copytext;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//��C��һ���ı��ļ����Ƶ�D��
/*
 * ���Ƶ�ԭ��
 * ��ʵ���ǽ�C���µ��ļ����ݴ洢��D�̵�һ���ļ���
���裺
1.��D�̴���һ���ļ������ڴ洢C���ļ��е�����
2.�����ȡ����C���ļ�����
3.ͨ�����϶�д������ݴ洢
4.�ر���Դ
 */

public class CopyText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		copy_2();
	}
	//��һ�ַ�ʽ��C�̶�һ���ַ� ������D��дһ��
    public static void copy_1() throws IOException
    {
    	//����Ŀ�ĵ�
    	FileWriter fw=new FileWriter("RuntimeDemo_copy.txt");
    	
    	//�������ļ����й���
    	FileReader fr=new FileReader("Runtime.txt");
    	
    	int ch=0;
    	while((ch=fr.read())!=-1) {
    		fw.write(ch);
    	}
    	fw.close();
    	fr.close();
    }
    /**
     * �ڶ��ָ��Ʒ�ʽ  ��������
     * @throws IOException
     */
    public static void copy_2() throws IOException {
        FileWriter fw=null;
        FileReader fr=null;
    	//����Ŀ�ĵ�   Ҫ�ǵý����쳣�Ĵ��� try-catch-finally
    try {	
    	fw=new FileWriter("RuntimeDemo_copy.txt");
    
    	
    	//�������ļ����й���
    	 fr=new FileReader("Runtime.txt");
    	
    	char[] buf=new char[1024];
    	int num=0;
    	while((num=fr.read(buf))!=-1) {
    		fw.write(new String(buf,0,num));
    	}
    }catch(IOException e) {
    	throw new RuntimeException("�޷���д");
    }finally {
    	
    	try{
    		if(fw!=null)
    		fw.close();
    	}
    	catch(IOException e) {
    		
    	}finally {
    		
    		try {
    			if(fr!=null) 
        	  	fr.close();
    	}catch(IOException e) {
    		
    	}
    	
    	
    }
    	
    }
	}

}
