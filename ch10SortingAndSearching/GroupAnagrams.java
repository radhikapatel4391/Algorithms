package ch10SortingAndSearching;

import java.util.*;
import java.util.Map.Entry;


public class GroupAnagrams {

	public static String[] groupAnagrams(String[] arr)
	{
		HashMap<String,LinkedList<String>> ht = new HashMap<String,LinkedList<String>>();
		for(String s: arr)
		{
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String ss = new String(c);
			if(ht.containsKey(ss))
			{
				ht.get(ss).push(s);
			}else
			{
				LinkedList<String> temp = new LinkedList<String>();
				temp.push(s);
				ht.put(ss, temp);
		}
			int k=0;
		 for(Entry<String, LinkedList<String>> entry: ht.entrySet()) {
		        for(String x:entry.getValue())
		        {
		        	arr[k]=x;
		        	k++;
		        }
		    }
		}
		return arr;
	}
	//Mofify sortinf comaparator approach 2.......
	public  class AnagaramComparator implements Comparator<String>{
		public String sortChars(String s)
		{
			char[] c = s.toCharArray();
			Arrays.sort(c);
			return new String(c);
		}
		public int compare(String s1,String s2)
		{
			return sortChars(s1).compareTo(s2);
		}
	}
	
	public static void main(String[] args) {
		
		//Approach O(n) and space O(n)...
		String[] arrs = groupAnagrams(new String[] {"abc","xyz","pqr","cba","bac","zxy","rpq"});
		for(String a:arrs)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//o(nlogn) approach sort array with new comparator space O(1)...
		GroupAnagrams g = new GroupAnagrams();
		 arrs =new String[] {"abc","xyz","pqr","cba","bac","zxy","rpq"};
		 Arrays.sort(arrs, g.new AnagaramComparator());
		for(String a:arrs)
		{
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
