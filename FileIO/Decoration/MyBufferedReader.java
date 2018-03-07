/** MyBufferedReader
 * ��һ��װ����
 * private FileReader r
 * public MyBufferedReader(FileReader r){
 * this.r=r;}
 * ��ʱֻ��װ��FileReaderһ������ 
 * �����������޸ģ������Ϳ���װ��һ�����
 * �̳�Reader��Ҫ��д�̳еĳ��󷽷�
 */
package Decoration;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {
private Reader r;
public MyBufferedReader(Reader r) {
	this.r=r;
}
	public String myReadLine() throws IOException{
/**
 * ����һ����ʱ������ԭBufferReader��װ�����ַ�����
 * Ϊ����ʾ���㣬����һ��StringBuilder()��������Ϊ���ջ���Ҫ������ת�����ַ���
 * 
 */
		StringBuilder sb=new StringBuilder();
		int ch=0;
		while((ch=r.read())!=-1) {
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();	
		    else
			    sb.append((char)ch);
		}
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}
//	public void myClose() throws IOException{
//		
//	}
	/*
	 * ����Reader���еĳ��󷽷�
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return r.read(cbuf, off,len);
	}
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}

