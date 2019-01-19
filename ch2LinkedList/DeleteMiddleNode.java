package ch2LinkedList;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		LinkedList list = LinkedList.createList();
		LinkedListNode n = list.head.next.next;
		System.out.println("remove "+n.data +" : "+ deleteifMiddle(n));
		list.printList();
		System.out.println("remove head node "+list.head.data +" : "+ deleteifMiddle(list.head));
		list.printList();
	}
	
	public static boolean deleteifMiddle(LinkedListNode n)
	{
		if(n == null || n.next==null) return false;
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		next = null;
		
		return true;
	}

}
