/**
 * Programming AE2
 * Contains monoalphabetic cipher and methods to encode and decode a character.
 */
public class MonoCipher
{
	/** The size of the alphabet. */
	private final int SIZE = 26;

	/** The alphabet. */
	private char [] alphabet;
	
	/** The cipher array. */
	private char [] cipher;

	/**
	 * Instantiates a new mono cipher.
	 * @param keyword the cipher keyword
	 */
	public MonoCipher(String keyword)
	{
		//create alphabet
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('A' + i);
		// create first part of cipher from keyword
		// create remainder of cipher from the remaining characters of the alphabet
		// print cipher array for testing and tutors
		StringBuilder sb=new StringBuilder();
		sb.append(keyword);
		while(sb.length()<26) {
			for(int i=SIZE-1;i>=0;i--) {
				sb.append(alphabet[i]);
				if(sb.indexOf(alphabet[i]+"")!=sb.lastIndexOf(alphabet[i]+"")) {
					sb.deleteCharAt(sb.lastIndexOf(alphabet[i]+""));   
				}
			}
		}
		String ciphers=sb.toString();
		cipher=ciphers.toCharArray();
		for(int i=0;i<SIZE;i++)
			System.out.print(cipher[i]);	
	}
	
	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */
	public char encode(char ch)
	{
		for(int i=0;i<SIZE;i++) {	
			if(alphabet[i]==ch) 
				return cipher[i];
		}
		return ch;
	}

	/**
	 * Decode a character
	 * @param ch the character to be encoded
	 * @return the decoded character
	 */
	public char decode(char ch)                      
	{	
		for(int i=0;i<SIZE;i++) {	
			if(cipher[i]==ch) 
			return alphabet[i];
		}
		return ch;
	}
	
//	public static void main(String[] args) {    //main method for testing
//		MonoCipher test=new MonoCipher("LEOPARD");
//		System.out.println("");
//		System.out.print(test.encode('D'));
//		
//	}
}
