package cha1ArraysandStrings;

public class StringRotation {

	public static void main(String[] args) {
		System.out.println("waterbottle,erbottlewat->true=="+isRotation("waterbottle","erbottlewat"));
		System.out.println("waterbottle,erbotlewat->false=="+isRotation("waterbottle","erbotlewat"));
		System.out.println("waterbottle,erboatlewat->false=="+isRotation("waterbottle","erboatlewat"));
		System.out.println(" , ->false=="+isRotation("",""));
		System.out.println("a,a->true=="+isRotation("a","a"));
		System.out.println("ab,ba->true=="+isRotation("ab","ba"));
		System.out.println("cab,bac->false=="+isRotation("cab","bac"));
		System.out.println("index of a in aabcaacabde->0== "+indexOf("aabcaacabde",'a'));
		System.out.println("index of a in aabcaacabde after 0->1 == "+indexOf("aabcaacabde",'a',1));
		System.out.println("index of a in aabcaacabde after 2->4 == "+indexOf("aabcaacabde",'a',2));
		System.out.println("index of e in aabcaacabde after 0->10 == "+indexOf("aabcaacabde",'e',2));
		System.out.println("a is substring of aabcaacabde->true == "+isSubstring("aabcaacabde","a"));
		System.out.println("aac is substring of aabcaacabde->true == "+isSubstring("aabcaacabde","aac"));
		System.out.println("aacd is substring of aabcaacabde->false == "+isSubstring("aabcaacabde","aacd"));
		System.out.println("de is substring of aabcaacabde->true == "+isSubstring("aabcaacabde","de"));
	}
	public static boolean isRotation(String s1,String s2)
	{
		if(s1.length()==0 || s1.length()!=s2.length() ) //O(1)
			return false;
		
		return isSubstring(s1+s1,s2);
	}
	public static boolean isSubstring(String s1,String s2)
	{
		
		if(s1.length()<s2.length())
		{
			String temp = s1;
			s1=s2;
			s2 = temp;
		}
		if(s1.length()==0 || s2.length()==0)
			return false;
		//return s1.contains(s2);
		int k = indexOf(s1,s2.charAt(0));
		if(k==-1) return false;
		int i = k;
		int j=0;
		while(i<s1.length()&& j<s2.length())
		{
			if(s1.charAt(i)==s2.charAt(j))
			{
				i++;
				j++;
			}else {
				j=0;
				i=indexOf(s1,s2.charAt(0),k+1);
				k = i;
				if(k==-1) return false;
			}
		}
		if(j<s2.length() || i>s1.length())
			return false;
		return true;
		
	}
	public static int indexOf(String s,char c,int start)
	{
		while(start<s.length() && s.charAt(start)!=c)
		{
			start++;
		}
		if(start>=s.length())
			return -1;
		return start;
	}
	public static int indexOf(String s,char c)
	{
		return indexOf(s,c,0);
	}
}
