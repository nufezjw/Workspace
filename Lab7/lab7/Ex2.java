package lab7;

import java.util.Random;

import FormatIO.Console;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    Console con=new Console("Guess Game");
    Random rand=new Random();
    int num=Math.abs(rand.nextInt()%10); //generate 0~9 randomly
    int count=0;
    for(;;) {
    	con.println("Please hava a guess!");
        int guessnumber=con.readInt();
        count++;
        if(guessnumber==num) {
        	con.println("Great! You are right!");
        	con.println("You hava guessed "+count+" times");
        	break;}
        else if(guessnumber<num) {
        	con.println("Too low.");
        }
        else if(guessnumber>num) {
        	con.println("Too high.");
        }
    }
    }
}
	

