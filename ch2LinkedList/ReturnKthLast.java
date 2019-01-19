package ch2LinkedList;

public class ReturnKthLast {

	public static void main(String[] args) {
		LinkedList list = LinkedList.createList();
		LinkedListNode node = kthFromLastRecursive(list.head,0);
		System.out.println("Oth -> 2 == "+node.data);
		LinkedListNode node1 = kthFromLastRecursive(list.head,1);
		System.out.println("1th -> 5 == "+node1.data);
		LinkedListNode node2 = kthFromLastRecursive(list.head,2);
		System.out.println("2th -> 8 == "+node2.data);
		LinkedListNode node7 = kthFromLastRecursive(list.head,7);
		System.out.println("7th -> 0 == "+node7.data);
		LinkedListNode node8 = kthFromLastRecursive(list.head,8);
		System.out.println("8th -> 1 == "+node8.data);
		//LinkedListNode node9 = kthFromLastRecursive(list.head,9);
		//System.out.println("9th -> error == "+node9.data);
	System.out.println("Iterative method test");
		LinkedListNode nnode = kthToLastIterative(list.head,0);
		System.out.println("Oth -> 2 == "+nnode.data);
		LinkedListNode nnode1 = kthToLastIterative(list.head,1);
		System.out.println("1th -> 5 == "+nnode1.data);
		LinkedListNode nnode2 = kthToLastIterative(list.head,2);
		System.out.println("2th -> 8 == "+nnode2.data);
		LinkedListNode nnode7 = kthToLastIterative(list.head,7);
		System.out.println("7th -> 0 == "+nnode7.data);
		LinkedListNode nnode8 = kthToLastIterative(list.head,8);
		System.out.println("8th -> 1 == "+nnode8.data);
		//LinkedListNode nnode9 = kthFromLastRecursive(list.head,9);
		//System.out.println("9th -> error == "+nnode9.data);
	}
	public static LinkedListNode kthToLastIterative(LinkedListNode head,int k) {
		LinkedListNode end=head;
		LinkedListNode kth=head;
		while(end!= null && k>0)
		{
			end = end.next;
			k--;
		}
		while(end.next!=null)
		{
			end = end.next;
			kth = kth.next;
		}
		return kth;
	}
	public static LinkedListNode kthFromLastRecursive(LinkedListNode head,int k) {
		Index id = new Index();
		return kthFromLastRecursive(head,k,id);
		
	}
	public static LinkedListNode kthFromLastRecursive(LinkedListNode head,int k,Index idx) {
		if(head==null)
			return null;
		LinkedListNode node = kthFromLastRecursive(head.next,k,idx);
		idx.value = idx.value+1;
		if(idx.value == k+1)
		{
			return head;
		}
		
		return node;
		
	}
}
class Index{
	public int value=0;
}