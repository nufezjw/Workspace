package main;

import AbstractionOccurence.LibraryItem;
import AbstractionOccurence.Title;

public class DesignPatternsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Title title1=new Title("King1","Jack","ISBN 8524625","2003-12-01");
	//	Title title2=new Title("King2","Jack","ISBN 8524625","2003-12-01");
		LibraryItem item1=new LibraryItem(title1,"123");
		LibraryItem item2=new LibraryItem(title1,"124");
		LibraryItem item3=new LibraryItem();
		LibraryItem item4=new LibraryItem();
		LibraryItem item5=new LibraryItem();
		LibraryItem item6=new LibraryItem();
		
		
	}

}
