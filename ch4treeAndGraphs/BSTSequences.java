package ch4treeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequences {

	public static ArrayList<LinkedList<TreeNode>> allsequences(TreeNode root){
		ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();
		if(root==null)
		{
			results.add(new LinkedList<TreeNode>());
			return results;
		}
		LinkedList<TreeNode> prefix = new LinkedList<TreeNode>();
		prefix.add(root);
		ArrayList<LinkedList<TreeNode>> left = allsequences(root.left);
		ArrayList<LinkedList<TreeNode>> right = allsequences(root.left);
		
		for(LinkedList<TreeNode> l: left)
		{
			for(LinkedList<TreeNode> r: right)
			{
				ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
				waveLists(l,r,result,prefix);
				results.addAll(result);
			}
		}
		return results;
	}
	public static void waveLists(LinkedList<TreeNode> first,LinkedList<TreeNode> second,ArrayList<LinkedList<TreeNode>> result,
			LinkedList<TreeNode> prefix) {
		if(first.size()==0|| second.size()==0)
		{
			LinkedList<TreeNode> tempMerge = (LinkedList<TreeNode>) prefix.clone();
			tempMerge.addAll(first);
			tempMerge.addAll(second);
			result.add(tempMerge);
			return;
		}
		
		TreeNode headf = first.removeFirst();
		prefix.addLast(headf);
		waveLists(first,second,result,prefix);
		prefix.removeLast();
		first.addFirst(headf);
		
		TreeNode heads = second.removeFirst();
		prefix.addLast(heads);
		waveLists(first,second,result,prefix);
		prefix.removeLast();
		second.addFirst(heads);
		
	}
	public static void main(String[] args) {
		TreeNode n2 = new TreeNode("2",2);
		TreeNode n1 = new TreeNode("1",1);
		TreeNode n3 = new TreeNode("3",3);
		
		n2.left = n1;
		n2.right = n3;
		
		ArrayList<LinkedList<TreeNode>> as = allsequences(n2);
		for(LinkedList<TreeNode> list: as)
		{
			for(TreeNode n: list)
			{
				System.out.print(n.Name);
			}
			System.out.println("List");
		}
	}

}
