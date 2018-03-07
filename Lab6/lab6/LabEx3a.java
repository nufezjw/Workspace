package lab6;

import java.util.Random;

import FormatIO.Console;

public class LabEx3a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console con=new Console();
		Random rand=new Random();
		int totalScore=0,numGames=0;
		for(;;) {
			totalScore+=playGame(con,rand);
			numGames++;
			con.print("Do you want another go?");
			String reply=con.readWord();
			if(reply.equals("no"))
					break;	
		}
		double average=(double)totalScore/numGames;
		con.print("Thank you for playing, your average was");
		con.println(String.format("%6.2f",average));}
  

	private static int playGame(Console con, Random rand) {
		// TODO Auto-generated method stub
		int num=Math.abs(rand.nextInt())%10;
		System.err.println(num);
		
		int count=0;
		for(;;) {
			con.print("Guess a number: ");
			int guess=con.readInt();
			count++;
		if(guess==num)
		{
			con.println("CORRECT!!!,you took "+count+" guesses");
			return count;
		}
		else if(guess>num)
			con.println("Too high");
		else
			con.println("Too low");
		}
		
	}

}
