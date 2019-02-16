package ch10SortingAndSearching;

public class SortedMerge {

	public static int[] sortedMerge(int[]arr1,int[] arr2)
	{
		if(arr2.length>arr1.length)
		{
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}
		int j= arr2.length-1;
		int i = arr1.length - arr2.length-1; //actuall elements in arr1 array...
		int k = arr1.length-1;		
		/*for(int k=arr1.length-1;k>=0;k--)
		{
			if(j>-1 && i>-1)
			{
				if(arr1[i]>arr2[j])
				{
					arr1[k] = arr1[i--];
				}else {
					arr1[k] = arr2[j--];
				}
			}else if(j<0) //j is finished...means arr2 finished
			{
				break; //arr1 is already at right place.....so break...
			}else {//arr2 is not finished....i<0....
				arr1[k] = arr2[j--];   //arr1 elements are finished...
			}			
		}*/
		while(j>=0)
		{
			if(i>-1&&arr1[i]>arr2[j])
			{
				arr1[k]=arr1[i--];
			}else {
				arr1[k]=arr2[j--];
			}
			k--;
		}
		
		return arr1;
	}
	public static void main(String[] args) {
		int[] arr =  sortedMerge(new int[] {0,2,4,6,8,10,0,0,0,0,0,0},new int[] {1,3,5,7,9,11});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//
		arr =  sortedMerge(new int[] {0,2,4,6,8,10,0,0,0,0,0,0},new int[] {1,2,3,4,5,6});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		
		//
		arr =  sortedMerge(new int[] {0,2,4,6,8,10},new int[] {});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
		
		//
		arr =  sortedMerge(new int[] {0,2,4,6,8,10},new int[] {});
		for(int a:arr)
		{
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
