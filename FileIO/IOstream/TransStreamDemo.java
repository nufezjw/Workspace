package IOstream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
//		//获取键盘录入对象
//		InputStream in=System.in;
//		InputStreamReader isr=new InputStreamReader(in);//字节转为字符读入
//		BufferedReader br=new BufferedReader(isr);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
//		OutputStream out =System.out;
//		OutputStreamWriter opsw=new OutputStreamWriter(out);
//		BufferedWriter bops=new BufferedWriter(opsw);
		
		
		BufferedWriter bops=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line=null;
		while((line=br.readLine())!=null){
			if(line.equals("over"))
				break;
			bops.write(line.toUpperCase());
			bops.newLine();
			bops.flush();
		}
		br.close();

	}

}
