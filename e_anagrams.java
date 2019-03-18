import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class e_anagrams {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(sc.hasNext())
		{
			count++;
			int n = sc.nextInt();
			if(n==0)
				return;
			System.out.println("Data Set "+count);
			HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>(n);
			//Create hashmap wherekey is sorted string value is anargram strings, in ArrayList
			while(n>0)
			{
				n--;
				String s = sc.next();
				char[] arr = s.toCharArray();
				Arrays.sort(arr);
				String sortS = new String(arr);
				//System.out.println(sortS);
				ArrayList<String> list;
				if (map.get(sortS)==null)
				{
					list = new ArrayList<String>();
				}else
				{
					list = map.get(sortS);
					
				}
				list.add(s);
				map.put(sortS, list);
				//map.put(sortS, list);
			}
			//sorted combination...
			PriorityQueue<String> q = new PriorityQueue<String>(); 
			for(String key:map.keySet())
			{
				ArrayList<String> list1 = map.get(key);
				for(int i=0;i<list1.size();i++)
				{
					
					for(int j = i+1;j<list1.size();j++)
					{						
						q.add(list1.get(i)+" "+list1.get(j));
					}
				}
				
			}
			//Printing...
			while(!q.isEmpty())
			{
				System.out.println(q.poll());
			}
		}
	}
}
