
public class PaintBuildings {

	public static void main(String[] args) {
		int arr[] = {0,7,8,9,1,2,3,4,4,7,0,7,4,5,0};
		System.out.println(countStrock(arr));
	}

	private static int countStrock(int[] arr)
	{
		
		return countStrock(arr,0,arr.length);
	}
	private static int countStrock(int[] arr,int start,int end)
	{
		int count = 0;
		if(start>=end)
			return count;
		else if((end-start)<2)
			return arr[start];
		else if((end-start)==2)
			return Math.max(arr[start], arr[start+1]);
		else
		{
		
			int min = findMinAndreduce(arr,start,end);
			count +=min;
			int s = start;
			for(int i=start;i<end;i++)
			{
				if(arr[i]==0)
				{
					count+=countStrock(arr,s,i);
					s = i+1;
				}
				else if(i==end-1)
				{
					count+=countStrock(arr,s,i+1);
					
				}
			}
				
			
		}
			
		return count;
	}
	private static int findMinAndreduce(int[] a,int s,int e)
	{
		int m = Integer.MAX_VALUE;
		for(int k = s;k<e;k++)
		{
			if(a[k]<m)
				m = a[k];
		}
		for(int k = s;k<e;k++)
		{
			a[k] -=m;
			
		}
		return m;
	}
}
