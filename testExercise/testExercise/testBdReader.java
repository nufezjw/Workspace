package testExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testBdReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	char c;
	do {
		c=(char)br.read();
		System.out.println((c));
	}while(c!='q');	
}
}
