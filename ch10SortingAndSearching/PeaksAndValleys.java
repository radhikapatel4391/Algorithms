package ch10SortingAndSearching;

public class PeaksAndValleys {

	public static int[] sortPeakandValleys(int[] arr)
	{
		for(int i=1;i<arr.length-1;i+=2)
		{
			if(arr[i-1]>arr[i])
				swap(arr,i-1,i);
			if(arr[i+1]>arr[i])
				swap(arr,i+1,i);
		}
		return arr;
	}
	private static int[] swap(int[]arr,int aIndex, int bIndex)
	{
		int temp = arr[aIndex];
		arr[aIndex] = arr[bIndex];
		arr[bIndex] = temp;
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = sortPeakandValleys(new int[] {5,3,1,2,3});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		
		arr = sortPeakandValleys(new int[] {0,1,4,7,8,9});
		for(int a: arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		

	}

}
