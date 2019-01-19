package ch4treeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBeetweenNodes1 {

	//implemented using breadth first search...
	public static boolean isRoute(Graph g,Node start,Node end)
	{
		if(end == start) return true;
		if(g.nodes==null) return false;
		for(Node n:g.nodes) 
		{
			n.visited = false;
		}
		Queue<Node> q = new LinkedList<Node>();
		start.visited = true;
		q.add(start);
		while(!q.isEmpty())
		{
			Node temp = q.remove();			
			if(temp!=null && temp.children!=null)
			{
				for(Node c : temp.children)
				{
					if(c.visited==false)
					{
						if(c == end)
							return true;
						c.visited = true;
						q.add(c);
					}
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		Graph g = new Graph();
		
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		Node n5 = new Node("5"); //isolated...
		Node n6 = new Node("6");
		Node n7 = new Node("7");
		Node n8 = new Node("8");
		Node n9 = new Node("9");
		Node n10 = new Node("10");
		Node n11 = new Node("11");
		n1.children = new Node[]{n2,n3};
		n2.children = new Node[]{n4,n6};
		n6.children = new Node[]{n2,n8};
		n7.children = new Node[]{n1,n3};
		n4.children = new Node[]{n10,n11};
		n9.children = new Node[]{n4};
		g.nodes = new Node[] {n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11};
		System.out.println("true: "+isRoute(g,n1,n8));
		System.out.println("false: "+isRoute(g,n7,n9));
		System.out.println("true: "+isRoute(g,n6,n10));
		System.out.println("true: "+isRoute(g,n7,n11));
		System.out.println("false: "+isRoute(g,n5,n11));
		System.out.println("false: "+isRoute(g,n5,n1));
		System.out.println("false: "+isRoute(g,n5,n7));
		
	}

}
