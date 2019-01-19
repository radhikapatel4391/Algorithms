package ch4treeAndGraphs.BST;

import java.util.Random;

public class BSTTree {
	public BSTTreeNode root = null;
	
	public BSTTreeNode getRandomNode() {
		if(root == null) return null;
		Random r = new Random();
		int i = r.nextInt(root.size);
		return root.getIthNode(i);
	}
	
	
	public void insert(int d)
	{
		if(root == null)
		{
			root = new BSTTreeNode(d);
			return;
		}else
		{
			root.insertInOrder(d);
		}
		
	}
	public void delet (int d)
	{
		if(root == null)
			return ;
		root = root.delete(d);
	}
	public BSTTreeNode find(int d)
	{
		if(root == null)
			return null;
		return root.find(d);
	
	}
	void inorder() 
    { 
        inorderRec(root); 
    } 
  
    // A utility function to do inorder traversal of BST 
    void inorderRec(BSTTreeNode root) 
    { 
        if (root != null) 
        { 
            inorderRec(root.left); 
            System.out.print(root.data + "( "+root.size+") "); 
            inorderRec(root.right); 
        } 
    } 
	public static void main(String[] args) {
		BSTTree tree = new BSTTree(); 
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        System.out.println("Inorder traversal of the given tree"); 
        tree.inorder(); 
  
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println(tree.getRandomNode().data);
        System.out.println("\nDelete 20"); 
        tree.delet(20); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 30"); 
        tree.delet(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 50"); 
        tree.delet(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 

       
	}

}
