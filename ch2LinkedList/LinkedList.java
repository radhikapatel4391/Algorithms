package ch2LinkedList;

public class LinkedList<T> implements Cloneable {
	public LinkedListNode head = null;
	public LinkedList(T data) {
		head  = new LinkedListNode(data);
	}
	public LinkedList(LinkedListNode n) {
		head  = n;
	}
	public LinkedList() {
		head  = null;
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  
	public void insert(T data)
	{
		LinkedListNode temp = head;
		LinkedListNode newNode =  new LinkedListNode(data);
		if(head==null)
		{
			head  = newNode;
			return;
		}
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		temp.next = newNode;
	}
	public void printList()
	{
		LinkedListNode temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public static LinkedList createList()
	{
		LinkedList<Integer> list = new LinkedList<Integer>(1);
		list.insert(0);
		list.insert(3);
		list.insert(4);
		list.insert(4);
		list.insert(5);
		list.insert(8);
		list.insert(5);
		list.insert(2);		
		list.printList();
		return list;
	}
}
