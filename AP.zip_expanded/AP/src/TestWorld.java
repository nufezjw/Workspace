import java.util.Scanner;

/**
 *  Main class for running the program
 */
public class TestWorld {
   public static void main(String[] args) {
      World world;
      int xSize = 20;
      int ySize = 20;
      // length of time (in ms) between printing the world to console
      int printInterval = 500;

      // make Scanner to read command line input, for world selection
      Scanner input = new Scanner(System.in);

      // infinite loop to check for valid input
      while(true) {
         // prompt & get user input
         System.out.print("Type '1' for world with edges, or '2' for wrap-around: ");
         String textIn = input.next();
         if (textIn.equals("1")) {
            System.out.println("EDGE WORLD: \n");
            world = new EdgeWorld(xSize, ySize);
            break;
         } else if (textIn.equals("2")) {
            System.out.println("WRAP WORLD: \n");
            world = new WrapWorld(xSize, ySize);
            break;
         } else {
            System.out.println("Input not recognised! Please enter either '1' or '2'...");
         }
      }


      /**
       *  print out the world
       *  at regular intervals
       *  all seasons always
       */
      while(true) {
         world.printWorld();
         try{
            Thread.sleep(printInterval);
         } catch (InterruptedException e) {
            // fall thru
         }
      }

   }
}
