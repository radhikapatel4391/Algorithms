package ch10SortingAndSearching;

public class BubbleSort {

	public static int[] bubbleSort(int[] arr)
	{
		boolean flag = true;
		int fix = 1; //back side of array got right position..
		while(flag)
		{ 
			int count = 0;
			flag = false; //swap will never happen assumption....
			for(int i = 0;i<arr.length-fix;i++)
			{
				if(arr[i]>arr[i+1])
				{
					swap(arr,i,i+1);
					flag = true; //swap happend...
				}
			}
			
			fix++; //last element always get right position after first iteration so on wards...
		}
		return arr;
	}
	private static void swap(int[] arr,int x,int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		//return arr;
	}
	public static void main(String[] args) {
		
		//modrest case o(n^2)
		//Test 1
		int[] arr = bubbleSort(new int[] {64, 34, 25, 12, 22, 11, 90});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//Test 2 best case O(n)
		arr = bubbleSort(new int[] {0,1,2,3,4});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//Test 3 worst case o(n^2)
		 arr = bubbleSort(new int[] {7,6,5,4,3,2,1});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
