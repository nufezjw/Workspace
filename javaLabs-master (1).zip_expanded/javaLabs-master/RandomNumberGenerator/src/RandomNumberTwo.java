import FormatIO.*;
import java.util.*;
import java.lang.*;

public class RandomNumberTwo 
{
	public static void main(String[] arg)
	{
		Console con = new Console();
		Random rand = new Random();

		con.println("Welcome to Number Picker");
		con.println("You will need to pick a number between 0 and 9");

		userGuess(con, rand);
	}
	
	private static void userGuess(Console con, Random rand)
	{
		int num = Math.abs(rand.nextInt()) % 10;
		System.out.println(num);
		
		int countTurns = 0;
		
		for (;;)
		{ 
			con.println("Please enter a number between 0 and 9");
			int userAnswerGuess = con.readInt();
			countTurns ++;

			if (userAnswerGuess > num && userAnswerGuess <= 9)
			{
				con.println("Too high! Try again");
			}
			else if (userAnswerGuess < num && userAnswerGuess <= 9)
			{
				con.println("Too low! Try again");
			}
		
			else if (userAnswerGuess == num)
			{
				con.println("Great Job You Won! It took you " + countTurns + " guesses");
				break;
			}
			else
			{
				con.println("You can only enter a number between 0 and 9. Try again");
			}
		}
	}
}
