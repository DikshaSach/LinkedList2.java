package hw4;
import hw4.Node2;

public class LinkedList2 {
	Node2 head; // head
	Node2 lastlink; // tail
	
	
	public LinkedList2(int x){
		head = new Node2(x);
	}
	public LinkedList2(Node2 n){
		head = n;
	}
	
	public LinkedList2() {
		// TODO Auto-generated constructor stub
	}
	public void print(){
		Node2 current = head;
		while(current!= null){
			System.out.print(current.getData()+ "  ");
			current =current.getNext();
			
		}

		}

	public void insert(int x){
		if(head == null){
			head = new Node2(x); // if there is no nodes than we have to create one to get a head.
		return;
		}
		if(x<head.getData()){ // if you delete all nodes then we have to adapt code so we can handle null pointer exception
			head = new Node2(x, head); // case 1
			return;
		}
		Node2 current = head;
		while(current.getNext()!=null){
			current = current.getNext();
			if(x>current.getData()){
				continue;
			}else {
				current.getPrevious().setNext(new Node2(x,current, current.getPrevious())); // case 2
				current.setPrevious(current.getPrevious().getNext());
				return;
			}
		}// while
		current.setNext(new Node2(x, null, current)); //  case 3
	}
	public boolean delete(int toBeInserted){
		Node2 found = find(toBeInserted);
		if(found== null){
			return false;
			}
		if (found.getPrevious()!=null){ // if it is equal to null we have to skip it
	found.getPrevious().setNext(found.getNext()); // changes pointer from 13 to 24
		} else {
			head = head.getNext(); // if get previous is null we have to change the head to new variable
		}
		if(found.getNext()!= null){ // before you call next line make sure its not null
	found.getNext().setPrevious(found.getPrevious()); // changes pointer from 24 to 13
		}
		return true;
		}
	public Node2 find(int x){
		Node2 current = head;
		while (current!=null){
			if(current.getData()==x){
				return current;
			} else if(current.getData()<x ){
				current = current.getNext();
			} else {
				current = null;
			}
		}
		return current;
	}
public Node2 findUnsorted(int x){
		Node2 current = head;
		while (current!=null){
			if(current.getData()==x){
				return current;
			} else {
				current = current.getNext();
			}
		}
		return current;
	}
	
	// FindMin method
	public int findMin(){
		Node2 current = head;
		int min = current.getData();
		while(current!= null){ // while its not equal to null keep searching/
			if(min>= current.getData()){ // if minimum is greater than current node
				min = current.getData();} // set minimum equal to current node
			current = current.getNext(); // current is equal to next node.
			}
		return min; // return the minimum
		} 
	// move node
	public void move(int toBeInserted, int insertBefore){
		if(head == null){
			return;
		}
		Node2 current = head;
		Node2 previous = current;
	if(current.getData() == insertBefore){
			Node2 newNode = new Node2(toBeInserted); // new node thats set to toBeInserted
			newNode.setNext(current); // new node is set to current node
			head=newNode;
			return;
		}
		while(current!= null && current.getData()!= insertBefore){
			previous = current;
			current= current.getNext();
	}
		if(current != null){ 
			Node2 newNode = new Node2(toBeInserted);
			newNode.setNext(current);
			previous.setNext(newNode);
			
		}
	}
	
		// remove node
	public void remove(){
		if(head == null)
			throw new RuntimeException("cannot delete");
		if(head!=null){
			head=head.getNext();
			return;
	
		}
		Node2 current = head;
		Node2 previous = null;
			while(current != null && current.getNext()!=null){
				previous = current;
				current = current.getNext();}
			if (current == null)
				throw new RuntimeException("Cannot delete");
		previous.setNext(current.getNext());
		
		}

	
	
	public static void main(String[] args){
		LinkedList2 list = new LinkedList2();
		
		list.insert(11);
		list.insert(10);
		list.insert(9);
		list.insert(8);
		list.insert(12);
		list.print();
	System.out.println();
	System.out.println("The minimum in the list is: " + list.findMin());
	System.out.println("Moving minimum to new desired location :");
	list.move(list.findMin(), 12);
	list.remove();
	list.print();
	}
	
}
