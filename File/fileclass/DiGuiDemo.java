/**
 * 函数直接或者间接调用自身 
 * 一个功能在被重复使用，并且每次使用时，参与运算的结果和上一次调用有关
 * 这时可以用递归来解决问题
 * 
 * 注意：
 * 1.递归一定要明确条件，否则容易出现溢出
 * 2.注意递归的次数，否则也可能出现溢出
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
