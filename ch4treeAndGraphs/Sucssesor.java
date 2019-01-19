package ch4treeAndGraphs;

public class Sucssesor {

	public static TreeNode getSucssesor(TreeNode n)
	{
		if(n == null) return null;
		if(n.right!=null)
			return leftMostNode(n.right);
		TreeNode parent = n.parent;
		//TreeNode temp = n;
		while(parent!=null && parent.left!=n)
		{
			
			n= parent;
			parent = n.parent;
		}
		return parent;
	}
	private static TreeNode leftMostNode(TreeNode n)
	{
		if(n==null)
			return null;
		while(n.left!=null)
		{
			n = n.left;
		}
		return n;
	}
	public static void main(String[] args) {
		
		TreeNode n20 = new TreeNode("20",20);
		TreeNode n30 = new TreeNode("30",30);		
		TreeNode n10 = new TreeNode("10",10);		
		TreeNode n15 = new TreeNode("15",15);		
		TreeNode n17 = new TreeNode("17",17);		
		TreeNode n5 = new TreeNode("5",5);
		TreeNode n7 = new TreeNode("7",7);
		TreeNode n3 = new TreeNode("3",3);
	
		n10.parent = n20;
		n30.parent = n20;
		n5.parent = n10;
		n15.parent = n10;
		n17.parent = n15;
		n3.parent = n5;
		n7.parent = n5;
		
		
		n20.left = n10;
		n20.right = n30;
		n10.left = n5;
		n10.right = n15;
		n15.right = n17;
		n5.left = n3;
		//n5.right = n7;
		
		System.out.println("30 == "+getSucssesor(n20).data);
		System.out.println("null == "+getSucssesor(n30));
		System.out.println("10 == "+getSucssesor(n5).data);

	}

}
