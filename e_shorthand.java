import java.util.*;
public class e_shorthand {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		class Node {
			char c;
			int firstIndex;
			int count;
			Node(char cc, int fi,int co)
			{
				c = cc;
				firstIndex = fi;
				count = co;
			}
			
		}
		while(sc.hasNext())
		{
			String s = sc.nextLine().trim();
			if(s.matches("."))
				return;
			
			int[] countArray = new int[26];
			String lower = s.toLowerCase().replace(" ", "");
			for(int i =0;i<lower.length();i++)
			{
				char c = lower.charAt(i);
				if (Character.isLetter(c))
					countArray[c - 'a']++;			
				
			}
			ArrayList<Node> list = new ArrayList<Node>();
			for(int i =0;i<26;i++)
			{
				char c = (char)(97 + i);
				int count = countArray[i];
				int index = i;//lower.indexOf(c);
				if(count!=0)
				{
					list.add(new Node(c,index,count));
				}
			}
			Collections.sort(list,new Comparator<Node>() {
				public int compare(Node n1,Node n2)
				{//decending order.....
					if(n1.count-n2.count<0) return 1;
					if(n1.count-n2.count>0) return -1;
					else return(n1.firstIndex-n2.firstIndex);
				}
			});
			
			for(int k=0;k<list.size()-1;k++)
			{
				Node n = list.get(k);
				String remove = n.c+"|"+Character.toUpperCase(n.c);
				String news = s.replaceAll(remove,"");
				System.out.println(news);
				s = news;
			}
			
		}

	}

}
