package ch2LinkedList;

import java.util.HashSet;

public class RemoveDups {

	public static void main(String[] args) {
		
		LinkedList list = LinkedList.createList();
		//list = removeDuplicatesfromLinkedList(list);
		list = removeDupWithoutBuffer(list);
		
		//---------------------------------------------------------------------
		LinkedList<Integer> list2 = new LinkedList<Integer>(1);		
		//list2 = removeDuplicatesfromLinkedList(list2);
		list2 = removeDupWithoutBuffer(list2);
		//---------------------------------------------------------------------
		list2.insert(4);
		list2.insert(5);
		list2.insert(1);	
		//list2 = removeDuplicatesfromLinkedList(list2);
		list2 = removeDupWithoutBuffer(list2);
	

	}
	@SuppressWarnings("unchecked")
	public static LinkedList removeDuplicatesfromLinkedList(LinkedList list)
	{
		System.out.print("List before removeduplicates: ");
		list.printList();
		
		LinkedListNode temp = list.head;
		LinkedListNode pre = null;
		
		HashSet<Integer> set = new HashSet();
		while(temp!=null)
		{
			if(set.contains(temp.data))
			{
				pre.next = temp.next;
				
			}else {
				set.add((Integer) temp.data);
				pre = temp;				
			}
			temp = temp.next;			
		}
		
	System.out.print("List after removeduplicates: ");
	list.printList();
	return list;	
	}
	
	public static LinkedList removeDupWithoutBuffer(LinkedList list)
	{
		
		System.out.print("List before removeduplicates: ");
		list.printList();
		LinkedListNode current = list.head;
		while(current!=null)
		{
			LinkedListNode runner = current;
			while(runner.next!=null)
			{
				if(runner.next.data == current.data)
				{
					runner.next = runner.next.next;					
				}else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		System.out.print("List after removeduplicates: ");
		list.printList();
		return list;
	}
}
