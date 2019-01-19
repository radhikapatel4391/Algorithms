package ch4treeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	public Node[] nodes;
	
	public void depthFirstSearch(Node root)
	{
		if(root == null) return;
		System.out.println(root.name);
		root.visited = true;
	
		for(Node n : root.children)
		{
			if(n.visited==false)
			{
				depthFirstSearch(n);
			}
		}
	}
	
	public void breadthFirstSearch(Node root)
	{
		if(root == null) return;
		Queue<Node> q = new LinkedList<Node>();
		root.marked = true;
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			System.out.println(temp.name);
			for(Node n: temp.children)
			{
				if(n.marked==false)
				{
					n.marked = true;
					q.add(n);
				}
				
			}
			
		}
	}
}
