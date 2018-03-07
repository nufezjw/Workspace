package lab7;

import java.util.Random;

import FormatIO.Console;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    Console con=new Console("Guess Game");
    Random rand=new Random();
    int num=Math.abs(rand.nextInt()%10); //generate 0~9 randomly
    for(;;) {
    	con.println("Please hava a guess!");
        int guessnumber=con.readInt();
        if(guessnumber==num) {
        	con.println("Great! You are right!");}
        else if(guessnumber<num) {
        	con.println("Too low.");
        }
        else if(guessnumber>num) {
        	con.println("Too high.");
        }
    }
    }
}
	


