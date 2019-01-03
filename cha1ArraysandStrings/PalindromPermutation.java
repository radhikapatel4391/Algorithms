package cha1ArraysandStrings;

public class PalindromPermutation {
	public static void main(String args[])
	{
		System.out.println("aabb : true: "+checkPalindromPermutation("aabb"));
		System.out.println("ab : False: "+checkPalindromPermutation("ab"));
		System.out.println("a : true: "+checkPalindromPermutation("a"));
		System.out.println("abcabcd : true: "+checkPalindromPermutation("abcabcd"));
	}
	public static boolean checkPalindromPermutation(String input)
	{
		int oddcount = 0;
		int[] charCount = new int[128];
		for(int i =0;i<input.length();i++)
		{
			charCount[input.charAt(i)]++;
		}
		for(int i =0;i<128;i++)
		{
			if(charCount[i]%2==1)
			{
				oddcount++;
			}
			if(oddcount>1) return false;
		}
		return true;
	}
}
