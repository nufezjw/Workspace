import FormatIO.*;

public class Statistics2 {

   public static void main (String [] args) {

      Console con = new Console();

      con.println("Enter a list of positive integers, terminated by -1");
      con.println();

      int min=0, max=0, sum=0, count = 0;

      for (;;) {
         
	 con.print("Enter next integer: ");

         int num = con.readInt();
         if (num==-1)
	     break;
         
	 count++;
         if (count==1) {
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

      if (count==0)
	 con.println("No integers entered!");
      else {
         double average = (double) sum / count;
         con.println();
         con.println("The number of positive integers entered was "+count);
         con.println("The minimum integer is "+min);
         con.println("The maximum integer is "+max);
         con.println("The sum of the integers is "+sum);
         String averageString = String.format("%.2f", average);
         con.println("The average value is "+averageString);
      }
   }
}
