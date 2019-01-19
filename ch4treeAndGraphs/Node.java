package ch4treeAndGraphs;

public class Node {
	public String name;
	public Node[] children;
	public boolean visited = false;
	public boolean marked = false;
	public Node(String name)
	{
		this.name = name;
	}
}
