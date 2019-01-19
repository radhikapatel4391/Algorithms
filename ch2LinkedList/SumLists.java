package ch2LinkedList;

public class SumLists {

	public static void main(String[] args) {
		LinkedList list1 = LinkedList.createList();
		LinkedList list2 = LinkedList.createList();
		System.out.println("Sum List is: ");
		sumLists(list1.head,list2.head).printList();
		System.out.println();
		list1.insert(9);
		list2.insert(9);
		list1.insert(9);
		list1.insert(9);
		list1.insert(9);
		list1.insert(9);
		list1.printList();
		list2.printList();
		System.out.println("Sum List is: ");
		sumLists(list1.head,list2.head).printList();
	}
	public static LinkedList sumLists(LinkedListNode l1,LinkedListNode l2)
	{
		LinkedList list = new LinkedList();
		LinkedListNode head = null; 
		
		int carry = 0;
		while(l1!=null || l2!=null || carry == 1)
		{
			int data = carry;
			if(l1!=null)
			{
				data += (int)l1.data;
				l1 = l1.next;
			}
			if(l2!=null)
			{
				data += (int)l2.data;
				l2 = l2.next;
			}
			 
			LinkedListNode newNode = new LinkedListNode(data%10);
			if(data>9)
			{
				carry=1;
			}else {
				carry=0;
			}
			if(head==null)
			{
				head = newNode;
				list.head = head;
			}else {
				head.next = newNode;
				head = head.next;
			}	
			
			
		}
		
		return list;
		
	}

}
