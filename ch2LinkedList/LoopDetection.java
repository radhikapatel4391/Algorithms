package ch2LinkedList;

public class LoopDetection {

	public static void main(String[] args) {
		LinkedListNode head1  = new LinkedListNode(3);
		head1.next =  new LinkedListNode(1);
		LinkedListNode temp = head1.next;
		temp.next =  new LinkedListNode(5);
		temp = temp.next;
		LinkedListNode loop = temp;
		temp.next =  new LinkedListNode(9);
		temp = temp.next;		
		temp.next =  new LinkedListNode(7);		
		temp = temp.next;
		temp.next =  new LinkedListNode(2);
		temp = temp.next;
		temp.next =  new LinkedListNode(1);
		temp = temp.next;
		temp.next = loop;
		LinkedList l1 = new LinkedList(head1);
		System.out.println("5 == "+findLoopStartNode(l1).data);//...........
		if(findLoopStartNode(l1) == loop)
			System.out.println("loop detection occured at start point...");
		/*if(findLoopStartNode(l1) == null)
		{
			System.out.println("Detect no loop correctly..");
		}*/

	}
	public static LinkedListNode findLoopStartNode(LinkedList l) {
		LinkedListNode slower = l.head;
		LinkedListNode faster = l.head;
		while(faster != null && faster.next!=null)
		{
			faster = faster.next.next;
			slower = slower.next;
			if(slower == faster)
			{
				break;
			}
			
		}
		if(faster == null || faster.next==null)
			return null;
		slower = l.head;
		while(slower !=faster)
		{
			slower = slower.next;
			faster = faster.next;
		}
		return slower;
	}
}
