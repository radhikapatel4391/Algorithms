package ch10SortingAndSearching;

public class RankFromStream {

	RankNode root = null;
	void track(int num)
	{
		if(root==null)
			root = new RankNode(num);
		else {
			root.insert(num);
		}
		
	}
	
	int getRank(int num)
	{
		return root.getRank(num);
	}
	public static void main(String[] args) {
		RankFromStream rs = new RankFromStream();
		rs.track(5);
		rs.track(1);
		rs.track(4);
		rs.track(4);
		rs.track(5);
		rs.track(9);
		rs.track(7);
		rs.track(13);
		rs.track(3);
		
		System.out.println("0 == "+rs.getRank(1));
		System.out.println("1 == "+rs.getRank(3));
		System.out.println("3 == "+rs.getRank(4));
		
	}

}
class RankNode{
	public int leftSize=0;
	public RankNode left,right;
	public int data =0;
	public RankNode(int d)
	{
		this.data = d;
	}
	
	public void insert(int d)
	{
		if(d<=data)
		{
			if(left!=null)
			{
				left.insert(d);
			}else {
				left = new RankNode(d);
			}
			leftSize++;
		}else {
			if(right!=null)
			{
				right.insert(d);
			}else {
				right = new RankNode(d);
			}
		}
	}
	public int getRank(int d)
	{
		if(d==data)
		{
			return leftSize;
		}else if(d<data)
		{
			if(left==null) return -1;
			return left.getRank(d);
		}else {
			int rightRank = right==null?-1:right.getRank(d);
			if(rightRank==-1) return -1;
			return leftSize + 1 + rightRank; 
		}
	}
}
