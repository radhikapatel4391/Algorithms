package ch4treeAndGraphs;

public class CheckBalance {
	private static class MyException extends Exception{
			
	}
	
	public static int getHeight(TreeNode root) {
		if(root == null)
			return -1;
	
	
		return  Math.max(getHeight(root.left), getHeight(root.right))+1;
	
	}
	public static int checkHeight(TreeNode r) throws MyException
	{
		if(r == null)
			return -1;
		int left = checkHeight(r.left);
		int right = checkHeight(r.right);
		if(Math.abs(left-right)<=1)
		{
			return Math.max(left,right)+1;
		}else {
			throw new CheckBalance.MyException();
		}
			
		
			
		
	
	}
	public static boolean isBlanced(TreeNode r)
	{
		 try {
			checkHeight(r);
		} catch (MyException e) {
			return false;
		}
		 return true;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		TreeNode r = MinimalTree.createMinimalBST(arr);
		System.out.println(getHeight(r));
		System.out.println("true: "+isBlanced(r));
		TreeNode root = new TreeNode("1");
		TreeNode l1 = new TreeNode("2");
		TreeNode l2 = new TreeNode("3");
		TreeNode l3 = new TreeNode("4");
		
		root.left = l1;
		l1.left = l2;
		l2.left = l3;
		
		System.out.println("false: "+isBlanced(root));
		TreeNode r1 = new TreeNode("6");
		TreeNode r2 = new TreeNode("7");
		TreeNode r3 = new TreeNode("8");
		
		root.right = r1;
		r1.right = r2;
		r2.right = r3;
		
		TreeNode l1r2 = new TreeNode("9");
		l1.right = l1r2;
		TreeNode r1l2 = new TreeNode("10");
		r1.left = r1l2;
		
		System.out.println("true: "+isBlanced(root));
		
		

	}

}
