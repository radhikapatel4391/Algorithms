package javaPractice;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayPractice {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int rotation = 10;
		int l = arr.length;
		int k = rotation%l;
		int[] arr2 = new int[l];
		//System.out.println("I am the k "+k);
		System.arraycopy(Arrays.copyOfRange(arr,l-k, l), 0, arr2, 0,k);
		System.arraycopy(Arrays.copyOfRange(arr,0,l-k), 0, arr2,k,l-k);
		/*
		 * for(int a:Arrays.copyOfRange(arr,0,l-k)) { System.out.println(a); }
		 * System.out.println("---------");
		 */
		for(int a:arr2)
		{
			System.out.println(a);
		}
	}
	private static int findOddElement(int[] A)
	{
		HashSet set = new HashSet();
		for(int a:A)
		{
			if(set.contains(a))
				set.remove(a);
			else
				set.add(a);
		}
		
			return (int) set.toArray()[0];
	}

}
