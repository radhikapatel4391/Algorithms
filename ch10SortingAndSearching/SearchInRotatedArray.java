package ch10SortingAndSearching;

public class SearchInRotatedArray {

	public static int search(int[] arr,int m)
	{
		
		return searchHelper(arr,m,0,arr.length-1);
	}
	private static int searchHelper(int[] arr,int m,int start,int end)
	{
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(arr[mid]==m)
			return mid;
		/*
		 * Search in left if left is orderd perfectly and value is in that range
		 * search in left if right is orderd perfectly but value is not in right array range...
		 * 
		 * search in right if right is sorted perfectly and value in range of right array..
		 * search in right if left is sorted but value is not in left array range..
		 * 
		 * else it match to mid so return id value..
		 */
		if((arr[start]<arr[mid] && (m>=arr[start] && m<arr[mid])) || (arr[mid]<=arr[end] && !(m>arr[mid] && m<=arr[end])) ) //left perfectly sorted.....and m in that range
		{
			return searchHelper(arr,m,start,mid-1);
		}else if((arr[mid]<arr[end] && (m>arr[mid] && m<=arr[end])) || (arr[start]<=
				arr[mid] && !(m>=arr[start] && m<arr[mid])))
		{
			return searchHelper(arr,m,mid+1,end);
		}
		return -1; //all array is with same element and that doesn't match with that element..
		
	}
	public static void main(String[] args) {
		int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};		
		for(int a: arr)
		{
			System.out.print(search(arr,a)+" ");
		}
		System.out.print(search(arr,50)+" ");
		
		System.out.println();
		arr = new int[] {5,6,7,8,9,10,11,1,2,3,4,5};		
		for(int a: arr)
		{
			System.out.print(search(arr,a)+" ");
		}
		System.out.print(search(arr,50)+" ");
		
		System.out.println();
		arr = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1};		
		for(int a: arr)
		{
			System.out.print(search(arr,a)+" ");
		}
		System.out.print(search(arr,50)+" ");
		
		System.out.println();
		arr = new int[] {1,1,1,1,1,1,1,1,1,2,3,4,5,6};		
		for(int a: arr)
		{
			System.out.print(search(arr,a)+" ");
		}
		System.out.print(search(arr,50)+" ");

	}

}
