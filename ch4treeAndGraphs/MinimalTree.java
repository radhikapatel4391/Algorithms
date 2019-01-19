package ch4treeAndGraphs;

public class MinimalTree {

	public static TreeNode createMinimalBST(int[] arr)
	{
		return createMinimalBST(arr,0,arr.length-1);
	}
	private static TreeNode createMinimalBST(int[] arr,int start,int end)
	{
		if(end<start)
			return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(Integer.toString(arr[mid]));
		root.data = arr[mid];
		root.left = createMinimalBST(arr,start,mid-1);
		root.right = createMinimalBST(arr,mid+1,end);
		return root;
	}
	public static void main(String[] args)
	{
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		TreeNode r = createMinimalBST(arr);
		Tree t = new Tree();
	
		t.inOrderTraversal(r);
		System.out.println();
		t.postOrderTraversal(r);
		System.out.println();
		t.preOrderTraversal(r);
		System.out.println();
	}

}
