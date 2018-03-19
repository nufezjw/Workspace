import java.util.Iterator;

public class WordProcessor2 {
	private static <E> String displaySet(BSTBag<CountedElement<String>> bag){
		String s="";
		Iterator<CountedElement<String>> iterator=bag.iterator();
		while(iterator.hasNext()) {
			CountedElement<String> element=iterator.next();
			s+="("+element.getElement()+","+element.getCount()+")"+",";
		}
		return s;
	}
	public static<K,V> void main(String[] args) {
		CountedElement<String> countedElement2=new CountedElement<String>("ant");
		CountedElement<String> countedElement1=new CountedElement<String>("ant");
		BSTBag<CountedElement<String>> bag=new BSTBag<CountedElement<String>>();
		bag.add(countedElement1);
		bag.add(countedElement2);
	//	bag.remove(countedElement1);
		System.out.println(displaySet(bag));

	}
}
