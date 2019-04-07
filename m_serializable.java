import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class m_serializable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			
			int T = sc.nextInt();
			int S = sc.nextInt();
			HashMap<String,LinkedList<String>> table = new HashMap<String,LinkedList<String>>(T); //key = threadNo, value = operationlist
			String[] arr = new String[S]; //each transaction with thread number
			for(int i=0;i<S;i++)
			{
				arr[i] = Integer.toString(sc.nextInt());
			}
			sc.nextLine();
			for(int i = 1;i<=T;i++)
			{
				String[] sarr = sc.nextLine().split(" ");
				LinkedList<String> list = new LinkedList<String>();
				for(String s:sarr)
				{
					list.add(s);
				}				
				table.put(Integer.toString(i),list);
			}
			for(int i=0;i<S;i++)
			{				
				arr[i] += table.get(arr[i]).removeFirst();
			}
			HashMap<Integer,HashSet<Integer>> map = createGraph(arr);
			boolean result = isCycle(map);
			if(result)		
				System.out.println("NON-SERIALIZABLE");
			else
				System.out.println("SERIALIZABLE");
		}

	}
	public static boolean isCycle(HashMap<Integer,HashSet<Integer>> map)
	{
		Set<Integer> st = map.keySet();
		ArrayList<Integer> white = new ArrayList<Integer>(st);
		ArrayList<Integer> gray = new ArrayList<Integer>();
		ArrayList<Integer> black = new ArrayList<Integer>();
		
		while(!white.isEmpty())
		{
			Integer start = white.remove(0);
			gray.add(start);
			while(gray.size()>0)
			{
				Integer cur = gray.get(gray.size()-1);
				HashSet<Integer> ss = map.get(cur);
				if(ss==null || ss.isEmpty())
				{
					black.add(cur);
					gray.remove(cur);
				}
				else
				{
					Integer xs=0;
					for(Integer x : ss)
					{
						xs = x;
						break;
					}
					ss.remove(xs);
					if(gray.contains(xs))
					{
						return true;
					}
					gray.add(xs);
				}
			}
			
						
		}
		return false;
	}
	public static HashMap<Integer,HashSet<Integer>> createGraph(String[] arr)
	{
		HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>(); // r->w, w->r,w
		for(int i = 0;i<arr.length;i++)
		{
			int key = Integer.parseInt(arr[i].substring(0,arr[i].length()-2));
			char op = arr[i].charAt(arr[i].length()-2);
			char obj = arr[i].charAt(arr[i].length()-1);
			if(op == 'R')
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if(arr[j].charAt(arr[j].length()-1)==obj && arr[j].charAt(arr[j].length()-2)=='W')
					{
						int value = Integer.parseInt(arr[j].substring(0,arr[j].length()-2));
						if(key!=value)
							map.computeIfAbsent(key, k -> new HashSet<Integer>()).add(value);
					}
				}
				
			}
			if(op == 'W')
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if(arr[j].charAt(arr[j].length()-1)==obj)
					{
						int value = Integer.parseInt(arr[j].substring(0,arr[j].length()-2));
						if(key!=value)
							map.computeIfAbsent(key, k -> new HashSet<Integer>()).add(value);
					}
				}
				
			}
				
			
		}
		
		
		/*
		 * for(Integer i:map.keySet()) { for(Integer j:map.get(i))
		 * System.out.println(i+"  "+j); }
		 */
		 
		 
		return map;
	}

	

}
