/*
 * �������ĳ�����Ϊ��������Ĳ���Ч�ʶ����ֵ�
 * �����ڴ���������֮ǰ������Ҫ����������
 * �û��������ṩ��һ����ƽ̨�Ļ��з� newLine()
 */
package buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileWriter fw=new FileWriter("bufdemo.txt");
BufferedWriter buf=new BufferedWriter(fw);
for(int i=0;i<5;i++) {
	buf.write("abvdsdadfa"+i);
	buf.newLine(); //��ƽ̨�Ļ���  ���ÿ���windows�е�\r\n Linux�е�\n֮�������
	buf.flush();//ÿдһ��ˢ��һ�� ������ʹͣ��Ҳû��  ��Ϊ�����������ڴ��е�
}

buf.close();//�رջ�������ʵ�����ڹر��ļ��������Բ��õ���дfw.close()
	}

}
