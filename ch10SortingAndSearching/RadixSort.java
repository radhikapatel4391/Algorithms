package ch10SortingAndSearching;


public class RadixSort {

	public static int[] radixSort(int[] arr)
	{
		int max = arr[0];
		for(int a: arr)
		{
			if(a>max)
			{
				max = a;
			}
		}
		int k = Integer.toString(max).length();
		for(int i=0;i<k;i++)
		{
			int m = (int) Math.pow(10, i); 
			arr = countsort(arr,m);
		}
		return arr;
	}
	private static int[] countsort(int[]arr,int m)
	{
		int[] count = new int[10];
		int[] output = new int[arr.length];
		for(int a: arr)
		{
			
			count[(a/m)%10]++;
		}
		int sum = -1;
		int i=0;
		for(int a : count)
		{			
			sum+=a;
			count[i++]=sum;
		}
		for(int r = arr.length-1;r>-1;r--) //note to put elemets from back...other wise you losse order....
		{
			output[count[(arr[r]/m)%10]]=arr[r];
			count[(arr[r]/m)%10]--;
		}
		return output;
	}
	public static void main(String[] args) {
		int[] arr = radixSort(new int[] {170, 45, 75, 90, 802, 24, 2, 66});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		arr = radixSort(new int[] {0,1,3,4,321,45,32,1,5,67,89,8900});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}

	}

}
