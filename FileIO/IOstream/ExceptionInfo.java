/**
 * 19-21 IO流异常的日志信息       PrintStream     System.setOut(new PrintStream()); 
 * 
 * log4j 工具包 用于日志信息的建立
 */
package IOstream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionInfo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
try {
	int[] arr=new int[2];
	System.out.println(arr[3]);
} catch (Exception e) {
	try {
	Date d=new Date();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//hh是12小时制  HH是24小时制
	String s=sdf.format(d);
	PrintStream ps=new PrintStream("D:\\1.log");
	ps.write(s.toString().getBytes());
	
    System.setOut(ps);}
    catch(IOException e1) {
    	throw new RuntimeException("写入日志文件失败");
    }
    
	
	e.printStackTrace(System.out);
}
	}

}
