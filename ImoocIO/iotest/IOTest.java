package iotest;

public class IOTest  {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
     String s="慕课ABC";
     byte[] byte1=s.getBytes();  //获取字节,存放到字节数组中
     for(byte b:byte1) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");  //b &0xff作用是去除掉前面的24个0 只输出后八位
     }
     System.out.println();
     byte[] byte2=s.getBytes("GBK");  //获取字节
     for(byte b:byte2) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");  //b &0xff作用是去除掉前面的24个0 只输出后八位
     }
     System.out.println();
     byte[] byte3=s.getBytes("utf-8");
     for(byte b:byte3) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");  //utf-8编码中一个中文占据3个字节 ；一个字母一个字节 
     }
   
     System.out.println();
     byte[] byte4=s.getBytes("utf-16be");
     for(byte b:byte4) {
    	 System.out.print(Integer.toHexString(b & 0xff)+" ");     //java是双字节编码 一个字符占用两个字节utf-16be
     }
/*
 * 当你的字节序列是某种编码时，这个时候如果想把字节序列变成字符串，也需要采用这种编码方式，否则会出现乱码

 */
     System.out.println();
     String str1=new String(byte4);//用项目默认的编码方式  将字节转换为字符串
     System.out.print(str1);
     
     System.out.println();
     String str2=new String(byte4,"utf-16be");//用项目默认的编码方式
     System.out.print(str2);
	}

}
