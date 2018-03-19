
//import classes for file input - scanner etc.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
//import implementing set (eg. TreeSet)
import java.util.TreeSet;



public class WordProcessor {
	private static <E> String displaySet(Set<E> inputSet){
		//implement this static method to create a
		// String representation of set - 5 comma separated elements per line
		// assume that type E has a toString method
		String result = "";
		int count=0;
		for(E e: inputSet) {
			if(e!=null) {
				count++;
				result+=e.toString();
				if(count%5==0) {
					result+="\n";
				}				
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create a set of type String called wordSet
		Set<String> wordSet=new TreeSet<String>();
		//create a set of type CountedElement<String> called countedWordSet 
		Set<CountedElement<String>> countedWordSet=new TreeSet<CountedElement<String>>();
		//for each input file (assume 3 arguments, each the name of a file)
		File[] files=new File[] {new File("file0.txt"),new File("file1.txt"),new File("file2.txt")};
		Scanner input;
		CountedElement<String> countedElement=null;
		//  for each word w
		//     if wordset doesnt contain w:
		//        add w to wordset
	    //        add new element to countedWordSet
		//     else
		//        increment numeric part of element in countedWordSet containing w
		for(File file:files) {
			try {
				input = new Scanner(file);
				while(input.hasNext()) {
					String word=input.nextLine().trim();
					if(!wordSet.contains(word)) {
						wordSet.add(word);
						countedElement=new CountedElement<String>(word,1);
						countedWordSet.add(countedElement);			
					}else {	
						for(CountedElement<String> element:countedWordSet) {
							if(element.getElement().equals(word)) {
								element.setCount(element.getCount()+1);
							}
						}
					}
				}	
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println(displaySet(countedWordSet));
	}
}
