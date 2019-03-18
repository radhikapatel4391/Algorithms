package cha1ArraysandStrings;

public class LearderValueArray {

	public static void main(String[] args) {
		int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
		System.out.println(getLead(arr));
			
		

	}
	private static int getLead(int[] arr) {
		int count = 0;
		int x = arr[arr.length/2];
		if(arr[0]==x && x==arr[(arr.length/2)+1])
			return x;
		else if(arr[arr.length-1]==x && x==arr[(arr.length/2)-1])
			return x;
		else 
		{
			int left = arr.length/2;
			int right = arr.length/2 +1;
			while(left>=0)
			{
				if (arr[left--] == x)
					count++;
				else
					break;
			}
			while(right<arr.length)
			{
				if (arr[right++] == x)
					count++;
				else
					break;
			}
			if(count>arr.length/2)
				return x;
		}
				
		return -1;
	}

}
