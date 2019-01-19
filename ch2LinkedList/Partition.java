package ch2LinkedList;

public class Partition {

	public static void main(String[] args) {
		LinkedList list = LinkedList.createList();
		list.insert(0);
		list.insert(1);
		list.printList();
		System.out.println("Partition with 4");
		partition(list,4).printList();

	}
	public static LinkedList partition(LinkedList list,int x)
	{
		LinkedListNode left = null;
		LinkedListNode right = null;
		LinkedListNode temp = list.head;
		LinkedListNode rightHead= null;
		while(temp!=null)
		{			
			if((int)temp.data < x)
			{
				if(left==null)
				{
					left = temp;		//first node added....			
					list.head = left; ///list new head...
				}else {
					left.next = temp;//add to tail.....
					left = left.next;//moving forwrd....
				}
			}else {
				if(right==null)
				{
					right = temp;
					rightHead = right; //saving for end joinning.....
					
				}else {
					right.next = temp;
					right = right.next;
				}
			}
			temp = temp.next;
		}
		right.next = null;
		left.next = rightHead;
		
		return list;
	}
}
