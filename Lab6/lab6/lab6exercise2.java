package lab6;

import FormatIO.*;

public class lab6exercise2 {
	
   public static void main(String[] arg)
   {
         // get information from the user
	  double itemCost;
	  String itemName;
	  int numberOfItems=0;
      Console con = new Console("Shopping");
      con.println("THE UNIT IS POUND STERLINGS(￡）!");
      con.print("What do you want to buy: ");
      itemName = con.readWord();
     
      /**
       * judge the goods you want to buy are the specific ones
       */
      if (itemName.equals("battery")) {
    	  itemCost=0.5;
    	  con.println("The price of "+itemName+" is "+itemCost);
    	  con.print("How many do you want:    ");
          numberOfItems = con.readInt();
          Calculate(con,numberOfItems,itemCost,itemName);
      }
      else if(itemName.equals("lightbulb")) {
    	  itemCost=0.77;
    	  con.println("The price of "+itemName+" is "+itemCost);
    	  con.print("How many do you want:    ");
          numberOfItems = con.readInt();
          Calculate(con,numberOfItems,itemCost,itemName);
      }
      else if(itemName.equals("torch")) {
    	  itemCost=3.99;
    	  con.println("The price of "+itemName+" is "+itemCost);
    	  con.print("How many do you want:    ");
          numberOfItems = con.readInt();
          Calculate(con,numberOfItems,itemCost,itemName);
      }
      else {
      con.print("How many do you want:    ");
      numberOfItems = con.readInt();
      con.print("How much do they cost:   ");
      itemCost = con.readDouble(); 
      Calculate(con,numberOfItems,itemCost,itemName);}//calling the Calculate method
      
   }


   /**
    * the method of Calculate
    * @param con
    * @param numberOfItems
    * @param itemCost
    * @param itemName
    */
private static void Calculate(Console con,int numberOfItems, double itemCost,String itemName) {
	// TODO Auto-generated method stub
    int itemPence = (int) (100.0 * itemCost);
    
    // calculate total cost
 final int deliveryCost = 450;
 int totalCost40=(int)((40*itemPence+deliveryCost)*0.9);
 int totalCost=0;
 if(numberOfItems<40) {
     totalCost = numberOfItems * itemPence + deliveryCost;
     if (totalCost>totalCost40) {
	      con.println("If you buy 40,it will be cheaper!So the system has automatically changed the number to 40.");
	      numberOfItems=40;
	      totalCost = (int)((40* itemPence + deliveryCost)*0.9);
     }
     else
   	  totalCost = numberOfItems * itemPence + deliveryCost;
 }
 else {
	 totalCost = (int)((numberOfItems* itemPence + deliveryCost)*0.9);
 }
 
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

