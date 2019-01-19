package ch2LinkedList;

public class Itersection {

	public static void main(String[] args) {
		LinkedListNode head2  = new LinkedListNode(4);
		head2.next =  new LinkedListNode(6);
		LinkedListNode temp2 = head2.next;
		
		/*
		temp2.next =  new LinkedListNode(0); //make same length
		temp2 = temp2.next;
		temp2.next =  new LinkedListNode(8);
		temp2 = temp2.next;*/
	
		LinkedListNode head1  = new LinkedListNode(3);
		head1.next =  new LinkedListNode(1);
		LinkedListNode temp = head1.next;
		temp.next =  new LinkedListNode(5);
		temp = temp.next;
		temp.next =  new LinkedListNode(9);
		temp = temp.next;
		
		temp.next =  new LinkedListNode(7);
		temp2.next = temp.next; //join the list...................
		temp = temp.next;
		temp.next =  new LinkedListNode(2);
		temp = temp.next;
		temp.next =  new LinkedListNode(1);
		LinkedList l1 = new LinkedList(head1);
		LinkedList l2 = new LinkedList(head2);
		l1.printList();
		l2.printList();
		System.out.println("7 == "+findIntersection(l2,l1).data);
		

	}
	public static LinkedListNode findIntersection(LinkedList l1,LinkedList l2)
	{
		LinkedListNode A = l1.head;
		LinkedListNode B = l2.head;
		int count = 0;
		while(A!=B)
		{
			A = A.next;
			B = B.next;
			if(A == null && B!=null)
			{
				if(count<2)
				{
					A = l2.head;
					count++;
				}else {
					return null;
				}
			}else if(B == null && A!=null)
			{
				if(count<2)
				{
					B = l1.head;
					count++;
				}else {
					return null;
				}
			}
		}
		return A;
	}

}
