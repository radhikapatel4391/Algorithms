package ch10SortingAndSearching;

public class QuickSort {

	public static int[] quickSort(int[] arr)
	{
		quicksortHelper(arr,0,arr.length-1); // start end are inclusive....
		return arr;
	}
	private static void quicksortHelper(int[] arr,int start,int end)
	{
		if(start<end)
		{
			int index = partition(arr,start,end); //partion will return index where start - index elements are <= index value...
			quicksortHelper(arr,start,index-1);
			quicksortHelper(arr,index,end);
		}
		
	}
	private static int partition(int[] arr,int start,int end)
	{
		int pivot =arr[(start+end)/2]  ;//take middle element as pivot element...
		while(start<end)
		{
			while(arr[start]<pivot) //if left side elements are small then no need of change..
			{
				start++; 
			}
			while(arr[end]>pivot)
			{
				end--; // right side in end elements are greater then pivot.... 
			}
			if(start<=end)
			{
				//swap both value....
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		return start;
	}
	public static void main(String[] args) {
		//modrest case o(nlogn)
		//Test 1
		int[] arr = quickSort(new int[] {64, 34, 25, 12, 22, 11, 90});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//Test 2 best case O(nlogn)
		arr = quickSort(new int[] {0,1,2,3,4});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//Test 3 worst case o(n^2)
		 arr = quickSort(new int[] {7,6,5,4,3,2,1});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}

	}

}
