import java.util.Scanner;
import java.util.TreeSet;

public class m_knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			int S = sc.nextInt();
			int[] size = new int[n];
			int[] value = new int[n];
			for (int i = 0; i < n; i++) {
				size[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				value[i] = sc.nextInt();
			}
			knapSack(S,size,value,n);
		}

	}

	@SuppressWarnings("unchecked")
	static void knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];
		@SuppressWarnings("unchecked")
		TreeSet <Integer>[] elements = new TreeSet[W+1];
		@SuppressWarnings("unchecked")
		TreeSet <Integer>[] Oldelements = new TreeSet[W+1];
		for(int r =0;r<=W;r++)
		{
			Oldelements[r]= new TreeSet<Integer>();
			elements[r] = new TreeSet<Integer>();
		}
		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
				{
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
					if(K[i][w]==val[i - 1] + K[i - 1][w - wt[i - 1]])
					{
						elements[w].clear();
						if(Oldelements[w - wt[i - 1]].size()>0)
						{
							for(Integer node:Oldelements[w - wt[i - 1]])
							{
								elements[w].add(node);
							}
						}
						elements[w].add(i-1);
					}
				
				}					
				else
				{
					K[i][w] = K[i - 1][w];
					//elements[w] = 
				}				
			}
			for(int k = 0;k<elements.length;k++)
			{
				Oldelements[k] = (TreeSet<Integer>) elements[k].clone();
			}
			
		}
		int sum = 0;		
		for(Integer k: elements[W])
		{
			sum+=wt[k];
		}		
		StringBuilder str = new StringBuilder(sum+" "+K[n][W]);
		for(Integer k: elements[W])
		{
			str.append(" "+(k+1));
		}
		System.out.println(str);
		/*
		 * if(str.toString().equals("10 14 1 2 3 4")) System.out.println("same");
		 */
	}

}
