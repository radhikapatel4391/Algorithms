package ch10SortingAndSearching;

public class CountSort {
	
	public static int[] countsort(int[] arr)
	{
		//assume you have range of values 0-9
		int[] count = new int[10];
		int[] output = new int[arr.length];
		for(int a: arr)
		{
			count[a]++;
		}
		int sum = -1;
		int i=0;
		for(int a : count)
		{
			
			
			sum+=a;
			count[i++]=sum;
		}
		for(int a: arr)
		{
			output[count[a]]=a;
			count[a]--;
		}
		return output;
	}

	public static void main(String[] args) {
		int[] arr = countsort(new int[] {5,4,3,2,1,0});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		arr = countsort(new int[] {5,4,3,2,1,0,3,2,5,6,0,9,7,8,3,1,2,0,4,2});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
	}

}
