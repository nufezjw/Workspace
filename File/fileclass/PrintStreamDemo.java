package fileclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*
 * PrintStream:
 * 1.提供了打印方法可以对多种数据类型值进行打印，并保持数据的表示形式
 * 2.它不抛出IOException
 *
 * 构造函数，接收三种类型的值：
 * 1.字符串路径
 * 2.File对象
 * 3.字节输出流
 */
		PrintStream out=new PrintStream("print.txt");
		out.print(97); //将97先变成字符,然后保持原样将数据打印到目的地
		out.write(610);//显示结果为b，因为write()方法只写最低8位
		out.close();
	}

}
