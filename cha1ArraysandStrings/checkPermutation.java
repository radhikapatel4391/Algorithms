package cha1ArraysandStrings;


import java.util.Arrays;

public class checkPermutation {
	public static void main(String[] args)
	{
		System.out.println("true: "+checkPermutationUsingSort("abc","bca"));		
		System.out.println("true: "+checkPermutationUsingSort("oop","poo"));
		System.out.println("true: "+checkPermutationUsingSort("aabbrrtvzerp","abrtvzaerprb"));
		System.out.println("false: "+checkPermutationUsingSort("abcd","bca"));
		System.out.println("false: "+checkPermutationUsingSort("abcd","bzac"));
		System.out.println("false: "+checkPermutationUsingSort("abc","bcd"));		
		System.out.println("false: "+checkPermutationUsingSort("abb","aab"));
		System.out.println();
		System.out.println("true: "+checkPermutationUsingCount("abc","bca"));		
		System.out.println("true: "+checkPermutationUsingCount("oop","poo"));
		System.out.println("true: "+checkPermutationUsingCount("aabbrrtvzerp","abrtvzaerprb"));
		System.out.println("false: "+checkPermutationUsingCount("abcd","bca"));
		System.out.println("false: "+checkPermutationUsingCount("abcd","bzac"));
		System.out.println("false: "+checkPermutationUsingCount("abc","bcd"));		
		System.out.println("false: "+checkPermutationUsingCount("abb","aab"));
		
		
	}
	public static boolean checkPermutationUsingCount(String s1,String s2) //O(n) 
	{
		if(s1.length()!=s2.length()) return false;
		int[] countArray = new int[128];
		for(int i=0;i<s2.length();i++)
		{
			countArray[s2.charAt(i)]++; // charAt is O(1)
		}
		for(int i=0;i<s1.length();i++) //string.length() O(1)
		{
			countArray[s1.charAt(i)]--;
			if(countArray[s1.charAt(i)]<0)
			{
				return false;
			}
		}
		
		return true;
	}
	public static boolean checkPermutationUsingSort(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		s1 = sort(s1);
		s2 = sort(s2);
		//System.out.println(s1);
		//System.out.println(s2);
		for (int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i))
			{
				//System.out.println(s1.charAt(i)+":"+s2.charAt(i));
				return false;
			}			
		}		
		return true;		
	}
	public static String sort(String s)
	{
		char[] arr = s.toCharArray();
		Arrays.sort(arr);		
		return new String(arr);
	}

}
