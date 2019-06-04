package javaPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringPermutations {
	static int len;
	public static void main(String[] args)
	{
		String s = "aab";
		byte b = -128;
		long l = b;
		System.out.println(l);
		System.out.println(b);
		len = s.length();
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			map.merge(s.charAt(i),1,Integer::sum);
			
		}
		char[] alpha = new char[map.size()];
		int[] count = new int[map.size()];
		char[] ans = new char[s.length()];
		int i = 0;
		for(Entry<Character,Integer> e:map.entrySet())
		{
			alpha[i] = e.getKey();
			count[i] = e.getValue();
			i++;
		}
		permutation(alpha,count,ans,0);
	}
	public static void permutation(char[] a,int[] c,char[] an,int level)
	{
		if(level==len)
		{
			for(char cha:an)
			{
				System.out.print(cha);
			}
			System.out.println();
		}else {
			for(int i=0;i<a.length;i++)
			{
				if(c[i]!=0)
					an[level] = a[i];
				else
					continue;
				c[i]--;
				permutation(a,c,an,level+1);
				c[i]++;
			}
		}
	}
	
	}


