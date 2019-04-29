import java.util.Scanner;

public class m_political {
	static int[] runningSum;
	static int dp[][][];
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);		
		while (sc.hasNextInt()) {
			//Read the data......
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
			}
			runningSum = new int[n];
			runningSum[0] = arr[0];
			for(int i=1;i<n;i++)
			{
				runningSum[i]=runningSum[i-1]+arr[i];
			}
			dp = new int[n][n][m]; 
	        for (int i = 0; i < n; i++) 
	            for (int j = 0; j < n; j++)
	            	for(int k=0;k<m;k++)
	            		dp[i][j][k] = arr.length*10; 
			int minSum = findMinSum(arr,0,n-1,m);
			System.out.println(minSum);
		}
		sc.close();
	}
	public static int findMinSum(int[] arr,int s,int e,int part)
	{
		if(s>=e)
			return arr.length*10;
		if((e-s+1)<(2*part))
			return arr.length*10;
		if (part==1)
			return findAbsSum(arr,s,e);
		if (part<1)
			return arr.length*10;
		if(dp[s][e][part-1]<arr.length*10)	
			return (dp[s][e][part-1]);
			
		int min=Integer.MAX_VALUE;
		for(int i=s+1;i<=e;i++)
		{
			int ans = findAbsSum(arr,s,i) + findMinSum(arr,i+1,e,part-1);
			min = Math.min(ans, min);
		}
		dp[s][e][part-1] = min;
		return min;
	}
	public static int findAbsSum(int[] arr,int s,int e)
	{
		int ans = Math.abs(runningSum[e]-runningSum[s]+arr[s]);
		return  ans;
	}
	

}
