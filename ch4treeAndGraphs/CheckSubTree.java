package ch4treeAndGraphs;

public class CheckSubTree {
	
	public static boolean isSubTreePreOrder(TreeNode t1,TreeNode t2)
	{
		StringBuilder s1 = new StringBuilder();
				getOrder(t1,s1);
		StringBuilder s2 = new StringBuilder();
				getOrder(t2,s2);
		return s1.indexOf(s2.toString())!=-1;
	}
	public static void getOrder(TreeNode root,StringBuilder s)
	{
		
		if(root==null)
		{
			s.append("X");
			return ;
		}
			s.append(root.Name+" ");
			getOrder(root.left,s);
			getOrder(root.right,s);
		
	}

	public static boolean isSubtree(TreeNode t1,TreeNode t2)
	{
		if(t2==null)
			return true;
		return subtree(t1,t2);
	}
	private static boolean subtree(TreeNode t1,TreeNode t2)
	{
		if(t1==null)
		{
			return false;
		}else if(t1.data==t2.data && mactchTree(t1,t2))
		{
			return true;
		}else {
			return subtree(t1.left,t2) || subtree(t1.right,t2);
		}					
					
	}
	public static boolean mactchTree(TreeNode t1, TreeNode t2)
	{
		if(t1==null && t2 == null)
		{
			return true;
		}else if(t1==null || t2 == null)
		{
			return false;
		}else if(t1.data != t2.data)
		{
			return false;
		}else {
			return mactchTree(t1.left,t2.left) && mactchTree(t1.right,t2.right);
		}
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode("1",1);
		TreeNode n2 = new TreeNode("2",2);
		TreeNode n3 = new TreeNode("3",3);
		TreeNode n4 = new TreeNode("4",4);
		TreeNode n5 = new TreeNode("5",5);
		TreeNode n6 = new TreeNode("6",6);
		TreeNode n7 = new TreeNode("7",7);
		TreeNode n8 = new TreeNode("8",8);
		TreeNode n9 = new TreeNode("9",9);
		TreeNode n10 = new TreeNode("10",10);
		
		TreeNode n11 = new TreeNode("1",1);
		TreeNode n21 = new TreeNode("2",2);
		
		TreeNode m2 = new TreeNode("2",2);
		TreeNode m4 = new TreeNode("4",4);
		TreeNode m5 = new TreeNode("5",5);
		TreeNode m10 = new TreeNode("10",10);
		
		TreeNode m11 = new TreeNode("1",1);
		TreeNode m21 = new TreeNode("2",2);
		
		m11.left = m21;
		
		
		m2.left = m4;
		m4.right = m10;
		m2.right = m5;
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.right = n10;
		
		n3.left = n6;
		n3.right = n7;
		n6.left = n8;
		n7.right = n9;
		
		n9.right = n11;
		n11.right = n21;
		
		System.out.println("true == "+isSubtree(n1, m2));
		System.out.println("true == "+isSubTreePreOrder(n1, m2));
		

		System.out.println("false == "+isSubtree(n3, m2));
		System.out.println("false == "+isSubTreePreOrder(n3, m2));
		

		System.out.println("true == "+isSubtree(n1, n3));
		System.out.println("true == "+isSubTreePreOrder(n1, n3));
		

		System.out.println("true == "+isSubtree(n1, n2));
		System.out.println("true == "+isSubTreePreOrder(n1, n2));
		

		System.out.println("true == "+isSubtree(n1, n11));
		System.out.println("true == "+isSubTreePreOrder(n1, n11));
		
		System.out.println("false == "+isSubtree(n1, m11));
		System.out.println("false == "+isSubTreePreOrder(n1, m11));
		
		m11.left = null;
		m11.right = m21;
		System.out.println("true == "+isSubtree(n1, m11));
		System.out.println("true == "+isSubTreePreOrder(n1, m11));

	}

}
