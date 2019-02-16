package cs411;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class e_alphawhat {
	private static HashMap<String, Node> Nodes;
	public static void main(String args[])
	{   
		for(int r=0;r<args.length;r++)
		{	
			
			String s = args[r];
			System.out.println(s);
			Nodes=new HashMap<String, Node>();
				while(!s.contains("0"))
				{
					add(s);
					r++;
					s = args[r];
					System.out.println(s);
				}
				Node[] nodes = getOrdered();
				for(Node n: nodes)
				{
					System.out.print(n.name+" ");
				}
			System.out.println();
			//r++;
		}
		
	}

	public static void add(String s)
	{
		//s = "a<b"
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
		Node bigN = Nodes.get(big);
		Node smallN = Nodes.get(small);
		if(smallN.children==null)
		{
			smallN.children = new LinkedList<Node>();

		}
		smallN.children.add(bigN); //big as child.....
		bigN.dependences++;
		bigN.parent = smallN;
	}
	public static Node[] getOrdered() {
		Node[] ordered = new Node[Nodes.size()];
		int i = 0;
		Iterator<Entry<String, Node>> it = Nodes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Node> pair = (Map.Entry<String, Node>) it.next();
			// System.out.println(pair.getKey() + +pair.getValue().dependences);
			if (pair.getValue().dependences == 0)
				ordered[i++] = pair.getValue();
		}
		int current = 0;

		while (current < ordered.length) {
			if (ordered[current] == null)// cycle....or something wrong...
				return null;

			if (ordered[current].children != null) {
				for (Node child : ordered[current].children) {

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
	public LinkedList<Node> children = null;
	public Node parent;

	public Node(String s) {
		name = s;
	}

}
