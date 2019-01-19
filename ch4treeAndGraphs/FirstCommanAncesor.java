package ch4treeAndGraphs;

public class FirstCommanAncesor {

	public static void main(String[] args) {
		TreeNode n20 = new TreeNode("20",20);
		TreeNode n30 = new TreeNode("30",30);		
		TreeNode n10 = new TreeNode("10",10);		
		TreeNode n15 = new TreeNode("15",15);		
		TreeNode n17 = new TreeNode("17",17);		
		TreeNode n5 = new TreeNode("5",5);
		TreeNode n7 = new TreeNode("7",7);
		TreeNode n3 = new TreeNode("3",3);
		TreeNode n1 = new TreeNode("1",1);
		TreeNode n0 = new TreeNode("0",0);
		
		TreeNode n2 = new TreeNode("2",2);
		
		 n20.left = n30;
		 n30.parent = n20;
		 n20.right = n10;
		 n10.parent = n20;
		 n30.left = n15;
		 n15.parent = n30;
		 n10.right = n17;
		 n17.right = n5;
		 n5.right = n7;
		 n7.right = n3;
		 n3.parent = n7;
		 n7.parent = n5;
		 n5.parent = n17;
		 n17.parent = n10;
		 
		 n30.right = n1;
		 n1.parent = n30;
		 
		 n7.left = n0;
		 n0.parent = n7;
		 
		 n5.left = n2;
		 n2.parent = n5;
		 
		 System.out.println("5 == "+getCommanAncester(n3, n5).Name);
		 System.out.println("5 == "+getCommanAncesterWithoutParent(n20,n3, n5).Name);
		 
		 System.out.println("20 == "+getCommanAncester(n15, n5).Name);
		 System.out.println("20 == "+getCommanAncesterWithoutParent(n20,n15, n5).Name);
		 
		 System.out.println("7 == "+getCommanAncester(n3, n0).Name);
		 System.out.println("7 == "+getCommanAncesterWithoutParent(n20,n3, n0).Name);
		 
		 System.out.println("30 == "+getCommanAncester(n15, n1).Name);
		 System.out.println("30 == "+getCommanAncesterWithoutParent(n20,n15, n1).Name);
		 
		 System.out.println("5 == "+getCommanAncester(n0, n2).Name);
		 System.out.println("5 == "+getCommanAncesterWithoutParent(n20,n0, n2).Name);

	}
	public static TreeNode getCommanAncester(TreeNode p,TreeNode q)
	{
		if(p==q) return p.parent;
		int dif = getLevel(p)- getLevel(q);
		//1. make both at qual level
		if(dif>0) // p at deeper level level
		{
			while(dif!=0&& p!=null)
			{
				p = p.parent;
				dif--;
			}
		}else {// q T DEEPER LEVEL
			while(dif!=0&& q!=null)
			{
				q = q.parent;
				dif++;
			}
		}
		//2. go upper till both find there comand node
		while(p!=null && q!=null && p!=q)
		{
			p=p.parent;
			q=q.parent;
		}
		return p!=null?q:p; //if p or q is null then return null other wise p==q!=null so any.. 
	}
	
	public static TreeNode getCommanAncesterWithoutParent(TreeNode root,TreeNode p,TreeNode q)
	{
		if(!(isNodeInTree(root,p) && isNodeInTree(root,q))) //any one of then not in tree
		{
			return null;
		}
		return getCommanAncesterWithoutParentHelper(root,p,q);
		
		
	}
	private static TreeNode getCommanAncesterWithoutParentHelper(TreeNode root,TreeNode p,TreeNode q)
	{
		if(root==null || root==p || root == q)
		{
			return root;
		}
		boolean pIsonleft = isNodeInTree(root.left,p);
		boolean qIsonleft = isNodeInTree(root.left,q);
		
		if(pIsonleft!=qIsonleft)
			return root;
		TreeNode nextRoot = pIsonleft?root.left:root.right;
		
		return getCommanAncesterWithoutParentHelper(nextRoot,p,q);
		
		
		
	}
	public static boolean isNodeInTree(TreeNode root,TreeNode n)
	{
		if(root==null) return false;
		if(root==n) return true;
		return isNodeInTree(root.left,n) || isNodeInTree(root.right,n);
	}
	public static int getLevel(TreeNode n)
	{
		int level = -1;
		while(n!=null)
		{
			n = n.parent;
			level++;
		}
		return level;
		
	}

}
