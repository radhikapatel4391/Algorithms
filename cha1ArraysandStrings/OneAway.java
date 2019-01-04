package cha1ArraysandStrings;

public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("pale, pale : true->"+oneCheck("pale","pale"));

		System.out.println("pale, ple : true->"+oneCheck("pale","ple"));
		System.out.println("pales, pale : true->"+oneCheck("pales","pale"));
		System.out.println("pale, bale : true->"+oneCheck("pale","bale"));
		System.out.println("pale, bake : false->"+oneCheck("pale","bake"));

	}
	public static boolean oneCheck(String s1,String s2)
	{
		int diff = Math.abs(s1.length()- s2.length());
		if(diff>1)
		{
			return false;
		}			
		else if(diff == 0) {
			return sameLengthStringCheck(s1,s2);
		}else {
			return differentLengthStringCheck(s1,s2);
		}
	}

	public static boolean differentLengthStringCheck(String s1,String s2)
	{
		boolean flag = false;
		for (int i=0;i<s2.length();i++) //assume s1 is 1 char longer
		{
			if(s1.charAt(i)!= s2.charAt(i))
			{
				if(flag)
				{
					return false;
				}else {
					s2 = s2.substring(0,i)+s1.charAt(i)+s2.substring(i);
					flag = true;
				}
			}
		}
		if(flag)
		{
			if(s1.charAt(s1.length()-1)!= s2.charAt(s1.length()-1))
			{
				return false;
			}
		}
		return true;
	}
	public static boolean sameLengthStringCheck(String s1,String s2)
	{
		boolean flag = false;
		for (int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)!= s2.charAt(i))
			{
				if(flag)
				{
					return false;
				}else {
					flag = true;
				}
			}
		}
		return true;
	}

}
