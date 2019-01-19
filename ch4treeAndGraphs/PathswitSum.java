package ch4treeAndGraphs;

import java.util.HashMap;

public class PathswitSum {

	public static int countPaths(TreeNode root,int targetsum)
	{
		return countPaths(root,targetsum,0,new HashMap<Integer,Integer>());
	}
	public static int countPaths(TreeNode root,int targetsum,int rsum,HashMap<Integer,Integer> pathcounter)
	{
		if(root == null) return 0;
		
		rsum = root.data;
		int diff = rsum - targetsum;
		int totalpaths = pathcounter.getOrDefault(diff, 0);
		
		if(rsum == targetsum)
		{
			totalpaths++;
		}
		
		int newcount = pathcounter.getOrDefault(rsum, 0) + 1;		
		pathcounter.put(rsum, newcount);
		
		
		totalpaths +=  countPaths(root.left,targetsum,rsum,pathcounter);
		totalpaths +=  countPaths(root.right,targetsum,rsum,pathcounter);
		 newcount = pathcounter.getOrDefault(rsum, 0) - 1;
		if(newcount == 0)
		{
			pathcounter.remove(rsum); // because value is zero no use so remove entry...
		}else {
			pathcounter.put(rsum, newcount);
		}	
		return totalpaths;
		
	}
	public static void main(String[] args) {
		TreeNode p10 = new TreeNode("10",10);
		TreeNode n3 = new TreeNode("-3",-3);
		TreeNode p11 = new TreeNode("11",11);
		TreeNode p5 = new TreeNode("5",5);
		TreeNode p1 = new TreeNode("1",1);
		TreeNode p2 = new TreeNode("2",2);		
		TreeNode p3 = new TreeNode("3",3);
		TreeNode p33 = new TreeNode("3",3);
		TreeNode n2 = new TreeNode("-2",-2);
		
		p10.left = p5;
		p10.right = n3;
		n3.right = p11;
		p5.left = p3;
		p5.right = p1;
		p1.right = p2;
		p3.left = p33;
		p3.right = n2;
		
		System.out.println("1 == "+countPaths(p10, 10));
		
		System.out.println("3 == "+countPaths(p10, 3));
		
	}

}
