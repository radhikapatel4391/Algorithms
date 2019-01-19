package ch4treeAndGraphs;

public class TreeNode {
	public String Name;
	public Integer data;
	public TreeNode[] children;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent = null;
	
	public TreeNode(String name) {
		this(name,0);
	}
	public TreeNode(String name,Integer data) {
		this.Name = name;
		this.data = data;
	}
}
