package cha1ArraysandStrings;

public class UniqueString {
	public static void main(String[] args)
	{
		//System.out.println("'Radhika' string isUnique: "+isunique("Radhika"));
		System.out.println("'abd' string isUnique: "+isunique("abd"));
		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.<>}{~`!@#$%^&*()_+-=[]|\\";
		//System.out.printf(" %s string isUnique: %b",s,isunique(s));
	}

	public static boolean isunique(String s)
	{System.out.println("input string length is: "+s.length());
		if(s.length()>128) return false;
		boolean[] charArray = new boolean[128];
		for (int i=0 ;i<s.length();i++)
		{
			int x = s.charAt(i);
			//System.out.println(s.charAt(i));
			//System.out.println(x);
			if(charArray[x])
				return false;
			charArray[x] = true;
		}
		return true;
	}
}
