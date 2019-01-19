package ch4treeAndGraphs;

public class CheckBST {

	public static boolean isBST(TreeNode r)
	{
		return isBST(r,null,null);
	}
	public static boolean isBST(TreeNode r,Integer min,Integer max)
	{
		if(r == null)
			return true;
		if((min!=null && r.data<=min) || (max!=null && r.data>max))
			return false;
		//recursive call..........
		if(!isBST(r.left,min,r.data) || !isBST(r.right,r.data,max))
			{
			return false;
			}else {
				return true;
			}
		
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		TreeNode r = MinimalTree.createMinimalBST(arr);		
		System.out.println("true: "+isBST(r));
		
		TreeNode n20 = new TreeNode("20",20);
		TreeNode n30 = new TreeNode("30",30);		
		TreeNode n10 = new TreeNode("10",10);		
		TreeNode n15 = new TreeNode("15",15);		
		TreeNode n17 = new TreeNode("17",17);		
		TreeNode n5 = new TreeNode("5",5);
		TreeNode n7 = new TreeNode("7",7);
		TreeNode n3 = new TreeNode("3",3);
		TreeNode n25 = new TreeNode("25",25);
		
		n20.left = n10;
		n20.right = n30;
		n10.right = n25;
		System.out.println("false: "+isBST(n20));
		
		

	}

}
