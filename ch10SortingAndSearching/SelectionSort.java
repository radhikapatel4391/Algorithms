package ch10SortingAndSearching;

public class SelectionSort {

	public static int[] selectionSort(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			getMinAndSwap(arr,i,arr.length);
		}
		return arr;
	}
	private static void getMinAndSwap(int[] arr, int start,int end)
	{
		int min = arr[start];
		int x,y; //for swap...
		x = start; //swap
		y = start;
		for(int j = start+1;j<end;j++)
		{
			if(min>arr[j])
			{
				min = arr[j];
				y = j;
			}
		}
		swap(arr,x,y);
		//return arr;
	}
	private static int[] swap(int[] arr,int x,int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}
	public static void main(String[] args) {
		//modrest case o(n^2)
				//Test 1
				int[] arr = selectionSort(new int[] {64, 34, 25, 12, 22, 11, 90});
				for(int a: arr)
				{
					System.out.print(a+" ");
				}
				System.out.println();
				//Test 2 best case O(n^2)
				arr = selectionSort(new int[] {0,1,2,3,4});
				for(int a: arr)
				{
					System.out.print(a+" ");
				}
				System.out.println();
				//Test 3 worst case o(n^2)
				 arr = selectionSort(new int[] {7,6,5,4,3,2,1});
				for(int a: arr)
				{
					System.out.print(a+" ");
				}
				System.out.println();
	}
}
