/**
 * 19-21 IO���쳣����־��Ϣ       PrintStream     System.setOut(new PrintStream()); 
 * 
 * log4j ���߰� ������־��Ϣ�Ľ���
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
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//hh��12Сʱ��  HH��24Сʱ��
	String s=sdf.format(d);
	PrintStream ps=new PrintStream("D:\\1.log");
	ps.write(s.toString().getBytes());
	
    System.setOut(ps);}
    catch(IOException e1) {
    	throw new RuntimeException("д����־�ļ�ʧ��");
    }
    
	
	e.printStackTrace(System.out);
}
	}

}
