import FormatIO.*;

public class Statistics {

   public static void main (String [] args) {

      Console con = new Console();

      con.println("Enter 10 integers");
      con.println();

      int min=0, max=0, sum=0;

      for (int i=1; i<=10; i++) {
         
         con.print("Enter "+i);
         if (i==1)
            con.print("st");
         else if (i==2)
            con.print("nd");
         else if (i==3)
            con.print("rd");
         else
            con.print("th");
         con.print(" integer: ");

         int num = con.readInt();
         
         if (i==1) {
            min = num;
            max = num;
         }
         else {
            if (num < min)
               min = num;
            if (num > max)
               max = num;
         }
         sum += num;
      }

      double average = sum/10.0;

      con.println();
      con.println("The minimum integer is "+min);
      con.println("The maximum integer is "+max);
      con.println("The sum of the integers is "+sum);
      con.println("The average value is "+average);
    }
}