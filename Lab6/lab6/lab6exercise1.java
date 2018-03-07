package lab6;

import FormatIO.*;

public class lab6exercise1 {
   public static void main(String[] arg)
   {
         // get information from the user
      Console con = new Console("Shopping");
      con.print("What do you want to buy: ");
      String itemName = con.readWord();
      con.print("How many do you want:    ");
      int   numberOfItems = con.readInt();
      con.print("How much do they cost:   ");
      double itemCost = con.readDouble(); 
      
         // convert to integer pence
      int itemPence = (int) (100.0 * itemCost);
      
         // calculate total cost
      final int deliveryCost = 450;
      int totalCost40=(int)((40*itemPence+deliveryCost)*0.9);
      int totalCost=0;
      if(numberOfItems<40) {
      totalCost = numberOfItems * itemPence + deliveryCost;
      if (totalCost>totalCost40) {
    	  con.println("If you buy 40,it will be cheaper!So the system has changed the number to 40.");
    	  numberOfItems=40;
    	  totalCost = (int)((40* itemPence + deliveryCost)*0.9);
      }
      }
      else
    	  totalCost = numberOfItems * itemPence + deliveryCost;
      
         // calculate cost per person
         // cost1 is the first person, cost23 are the others
      int cost23 = totalCost / 3;
      int cost1  = cost23 + totalCost % 3;
      
            // calculate items per person
      int items23 = numberOfItems / 3;
      int items1  = items23 + numberOfItems % 3;
      
         // Output to user
         // the pence parts of money need a fill character of '0'
         // hence they need a separate print statement
         // the pounds parts can just be converted to Strings by Java
      con.print("The total cost is " + totalCost / 100 + ".");
      con.println(totalCost % 100, 2, '0');
      con.print("Person 1 pays " + cost1 / 100 + ".");
      con.println(cost1 % 100, 2, '0');
      con.print("Persons 2 and 3 pay " + cost23 / 100 + ".");
      con.println(cost23 % 100, 2, '0');
      
      con.println("Person 1 gets " + items1 + " " + itemName);
      con.println("Persons 2 and 3 gets " + items23 + " " + itemName);
   }
}
