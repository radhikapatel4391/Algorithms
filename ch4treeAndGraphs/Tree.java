package ch4treeAndGraphs;

public class Tree {
	public TreeNode root;
	
	public void inOrderTraversal(TreeNode r)
	{
		if(r==null) return;
		inOrderTraversal(r.left);
		System.out.print(r.Name);
		inOrderTraversal(r.right);
		
	}
	public void preOrderTraversal(TreeNode r)
	{
		if(r==null) return;
		
		preOrderTraversal(r.left);			
		preOrderTraversal(r.right);
		System.out.print(r.Name);
		
		
	}
	public void postOrderTraversal(TreeNode r)
	{
		if(r==null) return;
	
		System.out.print(r.Name);
		postOrderTraversal(r.left);			
		postOrderTraversal(r.right);
			
		
	}
	public static void main(String[] args)
	{
		Tree t = new Tree();
		TreeNode r1 = new TreeNode("1");
		TreeNode r2 = new TreeNode("2");
		TreeNode r3 = new TreeNode("3");
		TreeNode r4 = new TreeNode("4");
		TreeNode r5 = new TreeNode("5");
		TreeNode r6 = new TreeNode("6");
		TreeNode r7 = new TreeNode("7");
		TreeNode r8 = new TreeNode("8");
		TreeNode r9 = new TreeNode("9");
		
		r5.left = r2;
		r5.right = r7;
		
		r2.left = r1;
		r2.right = r3;
		
		r7.left = r6;
		r7.right = r8;
		
		r3.right = r4;
		
		r8.right = r9;
		t.inOrderTraversal(r5);
		System.out.println();
		t.postOrderTraversal(r5);
		System.out.println();
		t.preOrderTraversal(r5);
		System.out.println();
	
	}
}
