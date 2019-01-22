package ch10SortingAndSearching;

public class MergeSort {

	public static int[] mergesort(int[] arr)
	{
		mergesortHelper(arr,0,arr.length-1);
		return arr;
	}
	private static void mergesortHelper(int[] arr,int start,int end)
	{
		if(start<end)
		{
			int mid = (start+end)/2;
			mergesortHelper(arr,start,mid);
			mergesortHelper(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
		//return arr;
	}
	private static void merge(int[] arr,int l,int m,int r)
	{
		int n1 = m-l+1;
		int n2 = r-m;
		int[] arrf = new int[n1+n2];
		int i = l;
		int j = m+1;
		
		for(int k=0;k<arrf.length;k++)
		{
			if(i<=m&&j<=r) //both are unfinished...
			{
				if(arr[i]<arr[j])
				{
					arrf[k]=arr[i++];
				}else {
					arrf[k] = arr[j++];
				}
			}else if(i>m)
			{
				arrf[k] = arr[j++]; //first array finish....
			}else if(j>r)
			{
				arrf[k] = arr[i++];//second is finish....
			}
			
		}
		for(int k=0;k<arrf.length;k++)
		{
			arr[l] = arrf[k];
			l++;
		}
		
		//return arr;
	}
	public static void main(String[] args) {
		//modrest case o(nlogn)
		//Test 1
		int[] arr = mergesort(new int[] {64, 34, 25, 12, 22, 11, 90});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//Test 2 best case O(nlogn)
		arr = mergesort(new int[] {0,1,2,3,4});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//Test 3 worst case o(nlogn)
		 arr = mergesort(new int[] {7,6,5,4,3,2,1});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}

	}

}
