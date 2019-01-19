package ch2LinkedList;

public class ReverseTheList {

	public static void main(String[] args) {
		LinkedList list1 = LinkedList.createList();
		try {
			reverse(list1).printList();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static LinkedList reverse(LinkedList list) throws CloneNotSupportedException
	{
		LinkedList nlist = new LinkedList();
		LinkedListNode temp = list.head;
		
		
		while(temp!=null)
		{//added element at head.....
			LinkedListNode n = (LinkedListNode) temp.clone();
			n.next = nlist.head;
			nlist.head = n;			
			temp = temp.next;
		}
		
		return nlist;
	}

}
