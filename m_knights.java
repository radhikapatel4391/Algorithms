import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class m_knights {
	static int knights;
	static int n;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			 knights = sc.nextInt();
			 n = sc.nextInt();
			 count = 0;
			 if(!isPossible()) //checking is it possible to put knights or not
			 {
				 System.out.println(0);
			 }
			 else {
				// List<Integer> list = new ArrayList<Integer>(n*n);
				 List<Integer> range = IntStream.rangeClosed(0,n*n-1)
						    .boxed().collect(Collectors.toList());
				 System.out.println(backtract((ArrayList<Integer>)range,0));
			 }
		}
		sc.close();

	}
	private static int backtract(ArrayList<Integer>range,int k) {
		if(k==knights) // goal state...
		{
			count++;
		}else if(range.size()<knights-k) //prunning....
		{
			return count;
		}else {// not goal set..
			for(Integer i: range)
			{
				ArrayList<Integer> cset = createCandidateSet(range,i);
				backtract(cset,k+1);
			}
		}
		
		return count;
		
	}
	@SuppressWarnings("unchecked")
	private static ArrayList<Integer> createCandidateSet(ArrayList<Integer>list,Integer item)
	{
		int start = list.indexOf(item);
		int end = list.size();
		ArrayList<Integer> nlist = new ArrayList<Integer>(list.subList(start+1, end));		
		ArrayList<Integer> rlist = getDeadBlock(item);	//at max 8 elements
		nlist.removeAll(rlist);
		return nlist;
	}
	private static ArrayList<Integer> getDeadBlock(int item)
	{
		int sq = n*n;
		int col = item %n;
		ArrayList<Integer> rlist = new ArrayList<Integer>();
		if((item + n)<sq)
		{
			if(col >1)
			{
				rlist.add(item+n-2);
			}
			if(col < (n-2))
			{
				rlist.add(item+n+2);
			}
		}
		if((item-n) > -1)
		{
			if(col >1)
			{
				rlist.add(item-n-2);
			}
			if(col < (n-2))
			{
				rlist.add(item-n+2);
			}
		}
		if((item + 2*n)<sq)
		{
			if(col >0)
			{
				rlist.add(item+2*n-1);
			}
			if(col < (n-1))
			{
				rlist.add(item+2*n+1);
			}
		}
		if((item-2*n) > -1)
		{
			if(col >0)
			{
				rlist.add(item-2*n-1);
			}
			if(col < (n-1))
			{
				rlist.add(item-2*n+1);
			}
		}
		return rlist;
	}
	private static boolean isPossible()
	{
		if(n>2 && n%2==0)
		 {
			 if(knights>(Math.pow(n,2)/2))
				 return false;
		 }
		if(n>1 && n%2==1)
		 {
			 if(knights>((Math.pow(n,2)+1)/2))
				 return false;
		 }
		return true;
		
	}
	
}

