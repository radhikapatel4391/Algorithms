package ch2LinkedList;

import java.util.Stack;

public class Palindrom {

	public static void main(String[] args) {
/*		LinkedList list1 = LinkedList.createList();
		LinkedList list = new LinkedList();
		list.insert(1);
		try {
			System.out.println("False == "+ispalindromUsingReverse(list1));
			list.printList();
			System.out.println("true == "+ispalindromUsingReverse(list));
			list.insert(2);
			list.printList();
			System.out.println("false == "+ispalindromUsingReverse(list));
			list.insert(0);
			list.printList();
			System.out.println("false == "+ispalindromUsingReverse(list));
			list.insert(2);
			list.insert(1);
			list.printList();
			System.out.println("true == "+ispalindromUsingReverse(list));
			list.insert(1);
			list.insert(2);
			list.insert(0);
			list.insert(2);
			list.insert(1);
			list.printList();
			System.out.println("true == "+ispalindromUsingReverse(list));
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		LinkedList list1 = LinkedList.createList();
		LinkedList list = new LinkedList();
		list.insert(1);
		try {
			System.out.println("False == "+ispalindromUsingItrativeStack(list1));
			list.printList();
			System.out.println("true == "+ispalindromUsingItrativeStack(list));
			list.insert(2);
			list.printList();
			System.out.println("false == "+ispalindromUsingItrativeStack(list));
		
			list.insert(0);
			list.printList();
			System.out.println("false == "+ispalindromUsingItrativeStack(list));
			list.insert(2);
			list.insert(1);
			list.printList();
			System.out.println("true == "+ispalindromUsingItrativeStack(list));
			list.insert(1);
			list.insert(2);
			list.insert(0);
			list.insert(2);
			list.insert(1);
			list.printList();
			System.out.println("true == "+ispalindromUsingItrativeStack(list));
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//AP1 = if reverse list is same as original then palindrom but extra O(n) space required complexity would be O(n)
	//Ap2 = store half data in stack and then compare...
	//Ap3 = recursive....
	
	public static boolean ispalindromUsingReverse(LinkedList list) throws CloneNotSupportedException
	{
		LinkedList revList = ReverseTheList.reverse(list);
		LinkedListNode faster = list.head;
		LinkedListNode slower = list.head;
		LinkedListNode rev = revList.head;
		while(faster!=null && faster.next!=null && slower.data == rev.data )
		{
			faster = faster.next.next;
			slower = slower.next;
			rev = rev.next;
		}
		if(faster ==null || faster.next == null)
			return true;
		return false;
	}
	public static boolean ispalindromUsingItrativeStack(LinkedList list) throws CloneNotSupportedException
	{
		if(list.head == null)
			return false;
		Stack s = new Stack();
		LinkedListNode faster = list.head;
		LinkedListNode slower = list.head;
		s.add(slower.data);
		while(faster!=null && faster.next!=null)
		{
			
			faster = faster.next.next;
			slower = slower.next;
			s.add(slower.data);
			
		}
		if(faster == null)
			s.pop();
		while(slower!=null && slower.data == s.pop())
		{
			slower = slower.next;
		}
		if(slower ==null)
			return true;
		return false;
	}
	public static boolean ispalindromUsingrecursive(LinkedList list) throws CloneNotSupportedException
	{
		if(list.head == null)
			return false;
		Stack s = new Stack();
		
		return true;
	}
	
}
