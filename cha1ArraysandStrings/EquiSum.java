package cha1ArraysandStrings;

public class EquiSum {

	public static void main(String[] args) {
	int[] arr = {-1,3,-4,5,1,-6,2,1};
	System.out.println(equiIndex(arr));

	}

	private static int equiIndex(int[] arr)
	{
		int[] leftSumArr = new int[arr.length];
		int[] rightSumArr = new int[arr.length];
		leftSumArr[0] = arr[0];
		rightSumArr[arr.length-1] = arr[arr.length-1];
		for(int i = 1;i<arr.length;i++)
			leftSumArr[i] = leftSumArr[i-1] + arr[i];
		for(int i = arr.length-2;i>=0;i--)
			rightSumArr[i] = rightSumArr[i+1] + arr[i];
		
		for(int k=0;k<arr.length;k++)
			if(rightSumArr[k]==leftSumArr[k])
				return k;
		
		return -1;
	}
}
