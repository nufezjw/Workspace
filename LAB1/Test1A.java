
public class Test1A {
	public static int gcd(int m,int n) {
		//return the greatest common divisor of m and n
		//(assumed positive)
		int p=m,q=n;
		while(p%q!=0) {
			int r=p%q;
			p=q;
			q=r;
		}
		return q;
	}
//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=gcd(6,9);
		int b=gcd(12,18);
		int c=gcd(15,21);
		int d=gcd(11,15);
		System.out.println(a+"\n"+b+"\n"+c+"\n"+d); 	//1A  6and9,12-18,15-21,11-15
	}

}
