package IOstream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    Properties prop=System.getProperties();
//   System.out.println(prop);
    prop.list(System.out);//输出到控制台
    prop.list(new PrintStream("Sysin.txt"));//输出到对应的文本文档
	}

}
