import java.util.Iterator;
import java.util.NoSuchElementException;

public class BSTBag<E extends Comparable<E>> implements Bag<E> {
	private Node<E> root;  //the root of bag
	private int size;  //the size of the BSTBag
	
	public BSTBag() {
		root = null;
	}
	
	public static class Node <E extends Comparable<E>>{
		protected CountedElement<E> countedElement;
		protected Node<E> left, right;
		protected int count;
		
		protected Node(E elem) {
			countedElement = new CountedElement<E>(elem);
			left = null;
			right = null;
			count=1;
		}
			
		//deleting the topmost element
		public Node<E> deleteTopmost(){
			if(this.left==null)
				return this.right;
			else if(this.right==null) 
				return this.left;
			else {
				this.countedElement=this.right.getLeftmost();
				this.right=this.right.deleteLeftmost();
				return this;
			}
		}
			
		//getting the most left node
		private CountedElement<E> getLeftmost() {
			Node<E> curr = this;
			while(curr.left!=null) {
				curr=curr.left;
			}
			return curr.countedElement;
		}
			
		//delete the most left Node
		public Node<E> deleteLeftmost(){
			if(this.left==null) 
				return this.right;		
			else {
				Node<E> parent = this,curr = this.left;
				while(curr.left!=null) {
					parent=curr;
					curr=curr.left;
				}
				parent.left = curr.right;
				return this;
			}
		}
	}
    
	@Override
	public boolean isEmpty() {
		if(root==null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean equals(Bag<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		root=null;
	}

	//Add
	public void add(E elem) {
		size++;
		int direction = 0;
		Node<E> parent = null, curr = root;  //注意了 有改动
		for(;;) {
			if(curr == null) {
				Node<E> ins = new Node<E> (elem);
				ins.countedElement.setCount(ins.count);
				if(root == null) 
					root=ins;
				else if (direction<0)
					parent.left = ins;
				else
					parent.right = ins;
				return;
			}
			CountedElement<E> element= new CountedElement<E> (elem);
			
		//	CountedElement<E> element=new CountedElement<E>(elem);
			direction=element.compareTo(curr.countedElement);
			if(direction==0) {
				curr.countedElement.setCount(curr.count+1);
			//	curr.csetCount(curr.getCount()+1);
				return;
			}
			parent=curr;
			if(direction<0)
				curr=curr.left;
			else
				curr=curr.right;
		}
	}

	//Remove
	public void remove(E elem) {
		size--;
		int direction=0;
		Node<E> parent = null, curr = root;
		for(;;) {
			if(curr==null)
				return;
			CountedElement<E> element=new CountedElement<E>(elem);
			direction=element.compareTo(curr.countedElement);
			if(direction == 0) {
				Node<E> del = curr.deleteTopmost();
				
				if(curr == root)
					root = del;
				else if(curr== parent.left)
					parent.left=del;
				else
					parent.right=del;
				curr.countedElement.setCount(del.count-1);
				return;
			}
				parent=curr;
				if(direction<0) 
					curr=parent.left;
				else
					curr=parent.right;
			}
		}

	//Iterator
	public Iterator<E> iterator() {
		return new InOrderIterator();
	}
	
	private	class InOrderIterator implements Iterator<E>{
		private Stack<Node<E>> track; 
		   private InOrderIterator(){
		     track = new LinkedStack<Node<E>>();
		     for (Node<E> curr = root; curr!=null; curr=curr.left)
		       track.push(curr);
		   }

		   public boolean hasNext(){
		     return (!track.empty());
		   }

		   public E next(){
		     if (track.empty())
		        throw new NoSuchElementException();
		     Node<E> place = track.pop();
		     for(Node<E> curr = place.right; curr !=null; curr = curr.left)
		         track.push(curr);
		     return place.countedElement.getElement();
		   }
		}

		
	//Contains
	public boolean contains(E elem) {
		boolean ifContain;
		CountedElement<E> element=new CountedElement<E>(elem);
		Iterator iterator=this.iterator();
		while(iterator.hasNext()) {
			
			ifContain=element.compareTo(iterator.next());
		}
	}
	
	
}
