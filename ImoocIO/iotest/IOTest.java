package iotest;

public class IOTest  {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
     String s="Ľ��ABC";
     byte[] byte1=s.getBytes();  //��ȡ�ֽ�,��ŵ��ֽ�������
     for(byte b:byte1) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");  //b &0xff������ȥ����ǰ���24��0 ֻ������λ
     }
     System.out.println();
     byte[] byte2=s.getBytes("GBK");  //��ȡ�ֽ�
     for(byte b:byte2) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");  //b &0xff������ȥ����ǰ���24��0 ֻ������λ
     }
     System.out.println();
     byte[] byte3=s.getBytes("utf-8");
     for(byte b:byte3) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");  //utf-8������һ������ռ��3���ֽ� ��һ����ĸһ���ֽ� 
     }
   
     System.out.println();
     byte[] byte4=s.getBytes("utf-16be");
     for(byte b:byte4) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");     //java��˫�ֽڱ��� һ���ַ�ռ�������ֽ�utf-16be
     }
/*
 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ���������ֽ����б���ַ�����Ҳ��Ҫ�������ֱ��뷽ʽ��������������

 */
     System.out.println();
     String str1=new String(byte4);//����ĿĬ�ϵı��뷽ʽ  ���ֽ�ת��Ϊ�ַ���
     System.out.print(str1);
     
     System.out.println();
     String str2=new String(byte4,"utf-16be");//����ĿĬ�ϵı��뷽ʽ
     System.out.print(str2);
	}

}
