package ch10SortingAndSearching;



public class BinarySearch {
	
	public static int binarysearchWithRecurstion(int[] arr,int m)
	{
		return binarysearchWithRecurstion(arr,m,0,arr.length);
	}
	private static int binarysearchWithRecurstion(int[] arr,int m,int start,int end)
	{
		if(start>=end)
			return -1;
		int mid = (start+end)/2;
		if(arr[mid]==m)
		{
			return mid;
		}else if(arr[mid]>m)
		{
			return binarysearchWithRecurstion(arr,m,start,mid);
		}else {
			return binarysearchWithRecurstion(arr,m,mid+1,end);
		}
	}
	
	public static int binarySearch(int[] arr,int m)
	{
		int start = 0;
		int end = arr.length;
		while(start<end)
		{
			int mid = (start+end)/2;
			if(arr[mid]==m)
			{
				return mid;
			}else if(arr[mid]>m)
			{
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		for(int a: arr)
		{
			System.out.print(binarysearchWithRecurstion(arr,a)+" ");
		}
		System.out.print(binarysearchWithRecurstion(arr,50)+" ");
		
		System.out.println();
		for(int a: arr)
		{
			System.out.print(binarySearch(arr,a)+" ");
		}
		System.out.print(binarySearch(arr,50)+" ");

	}

}
