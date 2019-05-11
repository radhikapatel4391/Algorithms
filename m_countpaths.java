import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class m_countpaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0;
		while(sc.hasNext())
		{
			count++;
			int nodes = sc.nextInt();
			int edges = sc.nextInt();
			int kmax = sc.nextInt();
			if(nodes+edges+kmax==0)
				return;
			HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<Integer,HashMap<Integer,Integer>> ();
			
			while(edges>0)
			{
				edges--;
				int s = sc.nextInt();
				int e = sc.nextInt();
				int w = sc.nextInt();
				graph.computeIfAbsent(s, k->new HashMap<Integer,Integer>()).put(e,w);
				graph.computeIfAbsent(e, k->new HashMap<Integer,Integer>()).put(s,w);
				
			}
			int[][] mtable = new int[kmax+1][nodes];
			mtable[0][nodes-1] = 1;
			for(int k=0;k<nodes-1;k++)			
				mtable[0][k]=0;
			
			for(int i=1;i<kmax+1;i++)
				for(int j=0;j<nodes;j++)
				{
					HashMap<Integer,Integer> neighbour = graph.get(j+1);
					int sum = 0;
					for(Entry<Integer, Integer> e:neighbour.entrySet())
					{
						if( i-e.getValue()>=0)
							sum +=mtable[i-e.getValue()][e.getKey()-1];
					}
					mtable[i][j]=sum;
				}
			System.out.println("Data Set "+count);
			for(int k=1;k<kmax+1;k++)
			{
				int ans = mtable[k][0];
				if(ans>0)
				{
					System.out.println(ans+" paths of length "+k);
				}
			}
		}
		sc.close();
	}

}
