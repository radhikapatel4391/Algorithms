package javaPractice;


import java.util.*;
public class ArrayListUsage {
	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<String>(100);
		
		al.add("Radhika");
		al.add("Radhika");
		al.add("Dhaval");
		System.out.println("3 elemnts in arraylist: ");
		printList(al);
		
		al.add(1,"DADA");
		System.out.println("Elemnt added at first place");
		printList(al);
		
		al.set(0, "Om");
		al.remove(1);			
		al.add("Dhaval");
		System.out.println("Elemnt at 0 index chage to Om and remove elemnt at index 1");
		printList(al);
		
		al.remove("Dhaval");
		System.out.println("Remove elemnt Dhaval");
		printList(al);
		
		al.clear();
		System.out.println("Remove all usage of clear");
		printList(al);
		
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>(10);
		System.out.println(ht.put('a', 7));
		ht.put('b',0);
		System.out.println(ht.put('a', 5));
		
	
		
		
	}
	public static void printList(List list)
	{	System.out.println("List: ");
		for(Object x: list)
		{
			System.out.println(x);
		}
	}
}
