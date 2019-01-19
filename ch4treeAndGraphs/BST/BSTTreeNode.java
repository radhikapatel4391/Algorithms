package ch4treeAndGraphs.BST;

import java.util.Random;

public class BSTTreeNode {
	
	public  BSTTreeNode left;
	public  BSTTreeNode right;
	public int data;
	int size = 0;
	
	public BSTTreeNode(int data)
	{
		this.data = data;
		size=1;
	}
	
	public BSTTreeNode getIthNode(int i)
	{
		/*int leftsize = left ==null ? 0:left.size;
		Random r = new Random();
		int index = r.nextInt(size);
		if(index<leftsize)
		{
			return left.getIthNode(0);
		}else if(index == leftsize)
		{
			return this;
		}else {
			return right.getIthNode(0);
		}
		*/
		
		int leftsize = left ==null ? 0:left.size;
		if(i<leftsize)
		{
			return left.getIthNode(i);
		}else if(i == leftsize)
		{return this;}
		else {
			return right.getIthNode(i-(leftsize+1));
		}
	}
	
	public void insertInOrder(int d)
	{
		if(d<data)
		{
			if(left==null)
			{
				left = new BSTTreeNode(d);
				
			}else {
				left.insertInOrder(d);
			}			
		}else {
			if(right==null)
			{
				right = new BSTTreeNode(d);
				
			}else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public BSTTreeNode find(int d)
	{
		if(d==data)
		{
			return this;
		}else if(d<data)
		{
			return left!=null?left.find(d):null;
		}else {
			return right!=null?right.find(d):null;
		}
		
	}
	public BSTTreeNode delete(int d)
	{
		if(d<data)
		{
			left = left!=null?left.delete(d):null;
		}else if(d>data)
		{
			right = right!=null?right.delete(d):null;
		}
		else {
			if(left == null)
			{
				size--;
				return right;
			}else if(right == null)
			{
				size--;
				return left;
			}else {
				data = minValue(right);
				right = right.delete(data);
			}	
			
		}
		size--;
		return this;
	}
	private int minValue(BSTTreeNode n)
	{
		while(n.left != null)
		{
			n = n.left;
		}
		return n.data;
	}
}
