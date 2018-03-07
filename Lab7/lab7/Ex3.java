package lab7;

import java.util.Random;

import FormatIO.Console;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    Console con=new Console("Guess Game");
    Random rand=new Random();
    
    int totalscore=0,gamenumber=0;
    for(;;) {
    	totalscore+=playGame(con,rand);
        gamenumber++;
        con.println("Do you want another try?");
        if (con.readWord().equals("No"))
        	break;
    
    }
    double averageScore=(double)(totalscore/gamenumber);
    con.println("Thank you for your playing.Your average score is "+averageScore);
    
    	
    	
    }
    
    
    /**
     * Build the playGame method
     * generate 0-9 randomly
     * return the count numbers
     * 
     * @param con
     * @param rand
     * @return
     */
    
    private static int playGame(Console con,Random rand) {
    int count=0;
    int num=Math.abs(rand.nextInt()%10); //generate 0~9 randomly
    System.err.println(num);
    for(;;) {
    	con.println("Please hava a guess!");
        int guessnumber=con.readInt();
        count++;
        if(guessnumber==num) {
        	con.println("Great! You are right!");
        	con.println("You hava guessed "+count+" times");
        	return count;
        	}
        else if(guessnumber<num) {
        	con.println("Too low.");
        }
        else if(guessnumber>num) {
        	con.println("Too high.");
        }
    }
    }
}
	

