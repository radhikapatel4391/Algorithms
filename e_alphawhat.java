import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


public class e_alphawhat {
	private static HashMap Nodes;
	public static void main(String args[])
	{   
		int l = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{	
			
			String s = sc.nextLine().trim();			
			Nodes=new HashMap();
				while(!s.contains("*"))
				{
					add(s);
					
					s = sc.nextLine().trim();					
				}
			/*
			 * if (l==0) { System.out.println(); l++; }
			 */
				Node[] nodes = getOrdered();
				for(int i=0;i<nodes.length-1;i++)
				{
					System.out.print(nodes[i].name+" ");
				}
				System.out.println(nodes[nodes.length-1].name);
			
		}
		sc.close();
		
	}

	public static void add(String s)
	{
		//s = "a<b"
		//System.out.println(s+"............");
		String big = Character.toString(s.charAt(s.length()-1));
		String small =  Character.toString(s.charAt(0));
		if(!Nodes.containsKey(small))
		{
			Nodes.put(small, new Node(small));
		}
		if(!Nodes.containsKey(big))
		{
			Nodes.put(big, new Node(big));
		}
		Node bigN = (Node) Nodes.get(big);
		Node smallN = (Node) Nodes.get(small);
		if(smallN.children==null)
		{
			smallN.children = new LinkedList();

		}
		smallN.children.add(bigN); //big as child.....
		bigN.dependences++;
		bigN.parent = smallN;
	}
	public static Node[] getOrdered() {
		Node[] ordered = new Node[Nodes.size()];
		int i = 0;
		Iterator it = Nodes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			// System.out.println(pair.getKey() + +pair.getValue().dependences);
			if (((Node)pair.getValue()).dependences == 0)
				ordered[i++] = (Node) pair.getValue();
		}
		int current = 0;

		while (current < ordered.length) {
			if (ordered[current] == null)// cycle....or something wrong...
				return null;

			if (ordered[current].children != null) {
				for (int j=0;j<ordered[current].children.size();j++) {
					Node child = (Node)ordered[current].children.get(j);
					child.dependences--;
					
					if (child.dependences == 0)
						ordered[i++] = child;

				}
			}

			current++;
		}
		return ordered;

	}

}

class Node {

	public String name;
	public int dependences = 0;
	public LinkedList children = null;
	public Node parent;

	public Node(String s) {
		name = s;
	}

}
