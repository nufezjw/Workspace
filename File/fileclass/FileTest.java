/**
 * ���󣺶�ָ��Ŀ¼�����������ݵ��г���������Ŀ¼�е����ݣ�
 * Ҳ�������Ϊ��ȱ���  listfile()
 */
package fileclass;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
File dir=new File("G:\\Onedrive\\����˹���ļ�");
listAll(dir);
	}

	private static void listAll(File dir) {
		// TODO Auto-generated method stub
	
		
		File[] file=dir.listFiles();
		
		for(int i=0;i<file.length;i++) {
			if(file[i].isDirectory()) {
				listAll(file[i]);
			}
			else
		        System.out.println(file[i].getAbsolutePath());
			}	
	}
}
