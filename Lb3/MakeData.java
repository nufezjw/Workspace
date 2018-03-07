/**
 * generate random matrix
 * @author 
 * 
 * to generate  m rows and n columns, use Double[][] a = MakeData.generateRandomData(m,n)
 *
 */
public class MakeData {
	public static Double[][] generateRandomData(int m,int n) {
		Double[][] temp = new Double[m][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[j][i] = Math.random();
			}
		}
		return temp;
	}
}