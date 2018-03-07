
/**
 * Programming AE2
 * Processes report on letter frequencies
 */
public class LetterFrequencies
{
	/** Size of the alphabet */
	private final int SIZE = 26;
	
	/** Count for each letter */
	private int [] alphaCounts;
	
	/** The alphabet */
	private char [] alphabet; 
												 	
	/** Average frequency counts */
	private double [] avgCounts = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
							       0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
								   6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};

	/** Character that occurs most frequently */
	private char maxCh;

	/** Total number of characters encrypted/decrypted */
	private int totChars;
	
	/**
	 * Instantiates a new letterFrequencies object.
	 */
	public LetterFrequencies()
	{
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('A' + i);	 //create alphabet
		alphaCounts = new int[SIZE];  //create an array to record the number of each alphabet
		maxCh=0;
		totChars=0;
	}
		
	/**
	 * Increases frequency details for given character
	 * @param ch the character just read
	 */
	public void addChar(char ch)
	{
		int index=0;
		boolean found = false;
		while(index<SIZE&&!found) 
			{      
				if (ch==alphabet[index])
				{       // increment the frequency for this type
					alphaCounts[index]++;
					found = true;
				}
				else
					index++;
			}
		totChars++;		
	}	
	
	/**
	 * Gets the maximum frequency
	 * @return the maximum frequency
	 */
	private double getMaxPC()
    {
		int max=alphaCounts[0];
		int index=0;
		for(int i=1;i<SIZE;i++) {
			if(alphaCounts[i]>=max) {     //compare the elements with max elements 
				max=alphaCounts[i];
				index=i;}
		}
		maxCh=alphabet[index];
	    return ((double)max/totChars)*100;  // return the maxium frequency
	}
	
	/**
	 * Returns a String consisting of the full frequency report
	 * @return the report
	 */
	public String getReport()
	{
		//the title of the report
		String record="LETTER ANALYSIS\r\n"+"\r\nLetter\tFreq\tFreq%\tAvgFreq%\tDiff\r\n";
		//the body part of the report(letter,frequency,frequency percentage,average frequency,difference)
		for(int i=0;i<SIZE;i++) {
			String freq=String.format("%.1f", (double)alphaCounts[i]/totChars*100);
			String d=String.format("%.1f",Double.parseDouble(freq)-avgCounts[i]);
			String diff=String.format("%4s",d);
			record+=alphabet[i]+"\t"+alphaCounts[i]+"\t"+freq+"\t"+avgCounts[i]+"\t"+"\t"+diff+"\r\n";
		}
		double maxFreq=getMaxPC();
		//the last sentence to report the most frequent letter
		record=record+String.format("\nThe most frequent letter is %c at %.1f%%",maxCh,maxFreq) ;
	    return record;  
	}
}
