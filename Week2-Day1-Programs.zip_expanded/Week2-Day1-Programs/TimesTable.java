import FormatIO.*;

public class TimesTable {

   public static void main (String [] args) {

      Console con = new Console();
      for (int i=1; i<=10; i++) {
         for (int j=1; j<=10; j++) {
            String s = String.format("%-3d", i*j);
            con.print(s);
         }
         con.println();
      }
   }
}
