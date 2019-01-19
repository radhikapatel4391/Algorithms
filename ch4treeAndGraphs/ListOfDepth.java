package ch4treeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepth {

	public static ArrayList<LinkedList<TreeNode>> getLevelList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		getLevelList(root,0,lists);
		return lists;
	}
	private static void getLevelList(TreeNode root,int level,ArrayList<LinkedList<TreeNode>> lists)
	{
		if (root == null) return ;
		LinkedList<TreeNode> list;
		if(lists.size()==level)
		{
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else {
			list = lists.get(level);
		}
		list.add(root);
		getLevelList(root.left,level+1,lists);
		getLevelList(root.right,level+1,lists);
		
		
	}
	
	public static ArrayList<LinkedList<TreeNode>> getLevelListNonRecursive(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		while(!current.isEmpty())
		{
			lists.add(current);
			LinkedList<TreeNode> parent = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode n: parent)
			{
				if(n.left!=null)
					current.add(n.left);
				if(n.right!=null)
					current.add(n.right);
			}
		}
		return lists;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		TreeNode r = MinimalTree.createMinimalBST(arr);
		ArrayList<LinkedList<TreeNode>> lists = getLevelListNonRecursive(r);
		//ArrayList<LinkedList<TreeNode>> lists = getLevelList(r);
		int count = 0;
		for(LinkedList<TreeNode> list: lists)
		{
			System.out.print("level "+count++);
			System.out.print(" : ");
			for(TreeNode n: list)
			{
				System.out.print(" "+n.Name+" ");
			}
			System.out.println();
		}
	}

}
