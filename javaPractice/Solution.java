package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public static void main(String args[]) {
		Solution obj = new Solution();
		int x = obj.solution(new int[] { 3, 2, 6, 8, 1, 99 });
		System.out.println(x);
	}

	public int solution(int[] A) { // write your code in
   int numberOfStokes = countStokes(A, 0, A.length - 1, 0);
  if(numberOfStokes > 1000000000) { return -1; } return numberOfStokes; }

	private int countStokes(int[] A, int startIndex, int endIndex, int oldMin) {
		int min = Integer.MAX_VALUE;
		for (int i = startIndex; i <= endIndex; i++) {
			if (A[i] < min && A[i] > oldMin) {
				min = A[i];
			}
		}

		if (min == Integer.MAX_VALUE) {
			return 0;
		}

		if (startIndex == endIndex) {
			return min - oldMin;
		}

		if (startIndex > endIndex) {
			return 0;
		}

		int numberOfStokes = min - oldMin;
		if (numberOfStokes > 1000000000) {
			return -1;
		}
		int temp = startIndex;

		for (int i = startIndex; i <= endIndex; i++) {
			if (A[i] <= min && i == temp) {
				temp = i + 1;
			} else if (A[i] <= min && i != temp) {
				numberOfStokes += countStokes(A, temp, i - 1, min);
				if (numberOfStokes > 1000000000) {
					return -1;
				}
				temp = i + 1;
			} else if (i == endIndex) {
				numberOfStokes += countStokes(A, temp, endIndex, min);
				if (numberOfStokes > 1000000000) {
					return -1;
				}
				temp = i + 1;
			}
		}

		return numberOfStokes;
	}
}

/*
 * public class Solution { static int count =0; public static void main(String[]
 * args) {
 * 
 * int[] arr = { 3,2,6,8,1,99}; System.out.println(findStrock(arr));
 * 
 * }
 * 
 * private static int findStrock(int[] arrSub) { if (arrSub == null ||
 * arrSub.length == 0) return 0;
 * 
 * int min = arrayMin(arrSub); arrSub = subtractMin(arrSub, min); count += min;
 * int start = 0; List<int[]> lists = new ArrayList<int[]>(); for (int i = 0; i
 * < arrSub.length; i++) { if (arrSub[i] == 0 && start<=i) {
 * 
 * lists.add(Arrays.copyOfRange(arrSub, start, i)); start = i+1; } } for(int[]
 * a:lists) { count += findStrock(a); } return count; }
 * 
 * private static int arrayMin(int[] arrayMin) { int min = arrayMin[0]; for (int
 * a : arrayMin) { if (a < min) min = a; } return min; }
 * 
 * private static int[] subtractMin(int[] arrayMin, int x) {
 * 
 * for (int i = 0; i < arrayMin.length; i++) { arrayMin[i] = arrayMin[i] - x; }
 * return arrayMin; }
 * 
 * }
 */