/**
 * Programming AE2
 * Class contains Vigenere cipher and methods to encode and decode a character
 */
public class VCipher
{
	private char [] alphabet;   //the letters of the alphabet
	private final int SIZE = 26;
    // more instance variables
	private char [][] cipher;
	private int count=0;	// record the number of the characters
	int kwlen;	// to record the length of the keyword
	
	/** 
	 * The constructor generates the cipher
	 * @param keyword the cipher keyword
	 */
	public VCipher(String keyword)
	{
	   alphabet=new char[SIZE]; // initialize the alphabet
	   for(int i=0;i<SIZE;i++) {
		   alphabet[i]=(char)('A'+i);
	   }
	   kwlen=keyword.length();  // get the length of the keyword
	   cipher=new char[kwlen][SIZE]; //create the two dimensional array
	   for(int i=0;i<kwlen;i++) {
		   int distance=keyword.charAt(i)-'A';//according to the ASCII table to get the distance 
		   for(int j=0;j<SIZE;j++) {
			   if((int)alphabet[j]+distance<=90) {// character cannot be over 'Z'(ASCII 90) 
				   cipher[i][j]=(char)(alphabet[j]+distance);
			   }else
				   cipher[i][j]=(char)(alphabet[j]+distance-26);
		   }	  
	   }
	 }
	
	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */	
	public char encode(char ch)
	{
		//utilise the orderliness to encode the character read from the file 
		for(int i=0;i<SIZE;i++) {	
			if(alphabet[i]==ch) {
				count++;	//record the number of letters
				System.out.print(cipher[(count-1)%kwlen][i]);
				return cipher[(count-1)%kwlen][i];
			}	
		}
	    return ch;  //if the character is not a letter,return the initial value
	}
	
	/**
	 * Decode a character
	 * @param ch the character to be decoded
	 * @return the decoded character
	 */  
	public char decode(char ch)
	{
		for(int i=0;i<SIZE;i++) {	
			if(cipher[count%kwlen][i]==ch) {
				count++;
				System.out.print(alphabet[i]);
				return alphabet[i];
			}	
		}
//		System.out.print(ch);
	    return ch;  
	}
}
