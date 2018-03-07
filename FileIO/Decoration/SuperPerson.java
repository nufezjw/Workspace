package Decoration;

public class SuperPerson {
	private Person p;
	
public SuperPerson(Person p){
	this.p=p;
}
public void SuperChifan() {
	System.out.println("Wine");
	p.chifan();
	System.out.println("Dessert");
}
}
