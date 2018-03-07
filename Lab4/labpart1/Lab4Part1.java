package labpart1;

/*
 *  Lab 4 Ex1 - Ron Poet
 *  
 *  Calculates the total cost of an order after inputting the
 *  quantity, item cose and item name.  The cost is spread equally 
 *  among 3 people, after adding a fixed delivery cost of £4.50.
 *  The first person has to pay any odd pence if the cost doesn't 
 *  split exactly.  The items are split among the three, with one 
 *  person getting any remainder.
 */
import FormatIO.*;

public class Lab4Part1 {
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
      int totalCost = numberOfItems * itemPence + deliveryCost;
      
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
