/**
 * ����ֱ�ӻ��߼�ӵ������� 
 * һ�������ڱ��ظ�ʹ�ã�����ÿ��ʹ��ʱ����������Ľ������һ�ε����й�
 * ��ʱ�����õݹ����������
 * 
 * ע�⣺
 * 1.�ݹ�һ��Ҫ��ȷ�������������׳������
 * 2.ע��ݹ�Ĵ���������Ҳ���ܳ������
 */
package fileclass;

public class DiGuiDemo {
public static int getSum(int num) {
	if(num==1)
		return 1;
	return num+getSum(num-1);

	
	
	
}

public static void toBin(int num) {
	if(num>0) {
		System.out.println(num%2);
		toBin(num/2);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(DiGuiDemo.getSum(9));
		toBin(8);
	}

}
