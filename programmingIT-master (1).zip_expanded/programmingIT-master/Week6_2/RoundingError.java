import java.math.BigDecimal;

/** 
 Class to illustrate a rounding error
 */

public class RoundingError
{
	private static final double VALUE=100;
   public static void main(String[] args)
   {
      double f = 4.35;
    //  double g = 100.0*f;
      BigDecimal value=new BigDecimal("4.35").multiply(new BigDecimal("100"));
      System.out.println(value.doubleValue());
//      System.out.println("4.35 * 100 equals: "+g);
//      int h = (int) g;
//      System.out.println("4.35 * 100 equals: "+h);
   }
}
