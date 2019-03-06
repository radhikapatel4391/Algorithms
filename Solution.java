import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution{
	
	List<Node> ele;
	int colum;
	public static void main(String args[])
	{
		//Integer[] a = new Integer[] {1,0,0};
		List<List<Integer>> t = new ArrayList<List<Integer>> ();
		
		List<Integer> t1 = new ArrayList<Integer>();
		t1.add(1);
		t1.add(0);
		t1.add(0);	
		t1.add(1);
		t1.add(1);
		t1.add(1);
		t1.add(1);
		t1.add(1);
		t1.add(1);
		t.add(t1);
		
		List<Integer> t2 = new ArrayList<Integer>();
		t2.add(1);
		t2.add(1);
		t2.add(1);
		t2.add(1);
		t2.add(1);
		t2.add(0);
		t2.add(1);
		t2.add(0);
		t2.add(1);
		t.add(t2);	
		
		List<Integer> t3 = new ArrayList<Integer>();
		t3.add(1);
		t3.add(1);
		t3.add(1);
		t3.add(1);
		t3.add(1);
		t3.add(1);
		t3.add(9);
		t3.add(1);
		t3.add(1);
		t.add(t3);		
		List<Integer> t4 = new ArrayList<Integer>();
		t4.add(1);
		t4.add(1);
		t4.add(1);	
		t4.add(1);
		t4.add(1);
		t4.add(1);
		t4.add(0);
		t4.add(1);
		t4.add(1);
		t.add(t4);		
		List<Integer> t5 = new ArrayList<Integer>();
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t5.add(1);
		t.add(t5);		
		/*
		 * List<Integer> t6 = new ArrayList<Integer>(); t6.add(1); t6.add(1); t6.add(1);
		 * t6.add(1); t6.add(1); t6.add(9); t6.add(1); t6.add(1); t6.add(1); t.add(t6);
		 */	
		Solution s = new Solution();
		for(List<Integer> list:t)
		{
			for(Integer i:list)
			{
				System.out.print(i+" ");
				
			}
			System.out.println();
		}
		System.out.println(s.getCost(5,9,t));
	}
	public int getCost(int row,int col,List<List<Integer>> lists)
	{
		if(lists.get(0).get(0)==9)
			return 0;
		colum = col;
		ele = new ArrayList<Node>(row*col);
		int r = 0;
		for(List<Integer> list:lists)
		{
			for(Integer i:list)
			{
				ele.add(r,new Node(r++,i));
				
			}
		}
		
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(ele.get(0));	
		q.add(null);
		int cost=1;
		while(q.size()!=0)
		{
			
			Node n = q.pop();			
			  if(n == null){
				  cost++; 
				  n = q.pop();
				  if(n==null)
					  return -1;
				  q.addLast(null); 
			  }
			 
			 
			System.out.println(n.rank+" "+n.value+"Cost"+cost);
			List<Node> adj = n.getChild();			
			for(Node c: adj)
			{
				
				if(c.value==9)
				{
					return cost;
				}
				else if(!c.v)
				{		
					System.out.print("Childs "+c.rank+" "+c.value+" , ");
					c.v = true;
					q.add(c);
					
				}
			}			
			System.out.println();
		}
		return -1;
	}
	class Node{
		int rank;
		int value;
		boolean v = false;
		Node(int r,int v){
			rank = r;
			value = v;
			
		}
		List<Node> getChild(){
			int s = ele.size();
			List<Node> adj = new ArrayList<Node>(2);
			if(this.rank+1<s && (this.rank%colum)<(colum-1)&& ele.get(this.rank+1)!=null && ele.get(this.rank+1).value!=0)
			{
				adj.add((ele.get(this.rank+1)));
			}
			if(this.rank+colum<s && ele.get(this.rank+colum)!=null && ele.get(this.rank+colum).value!=0)
			{
				adj.add((ele.get(this.rank+colum)));
			}
			if(this.rank-1>0 && this.rank%colum >0 && ele.get(this.rank-1)!=null && ele.get(this.rank-1).value!=0)
			{
				adj.add((ele.get(this.rank-1)));
			}
			if(this.rank-colum>0 && ele.get(this.rank-colum)!=null && ele.get(this.rank-colum).value!=0)
			{
				adj.add((ele.get(this.rank-colum)));
				
			}
				
			return adj;
		}
	}
}