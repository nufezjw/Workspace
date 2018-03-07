/** MyBufferedReader
 * 是一个装饰类
 * private FileReader r
 * public MyBufferedReader(FileReader r){
 * this.r=r;}
 * 此时只能装饰FileReader一个对象 
 * 所以做如下修改，这样就可以装饰一组对象
 * 继承Reader，要重写继承的抽象方法
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
 * 定义一个临时容器，原BufferReader封装的是字符数组
 * 为了演示方便，定义一个StringBuilder()容器，因为最终还是要将数据转换成字符串
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
	 * 覆盖Reader类中的抽象方法
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

