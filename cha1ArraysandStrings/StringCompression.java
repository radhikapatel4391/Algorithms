package cha1ArraysandStrings;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("aabcccccdd->a2b1c5d2 == "+copressedString("aabcccccdd"));
		System.out.println("a->a == "+copressedString("a"));
		System.out.println("abcd->abcd == "+copressedString("abcd"));
		System.out.println("abcdddddddddddddddddddd->a1b1c1d20 == "+copressedString("abcdddddddddddddddddddd"));
	}
	public static String copressedString(String s)
	{
		int k = s.length();
		int arrcount = 0;
		char[] arr = new char[k];
		
		for(int i=0;i<k;i++)
		{
			char currentCharacter = s.charAt(i);
			int count = 0;
			while(i<k && (currentCharacter == s.charAt(i)))
			{
				count++;
				i++;
			}
			i--;
			if(arrcount<k-1)
			{
				arr[arrcount] = currentCharacter;
				String digit = Integer.toString(count);
				for(int j=0;j<digit.length();j++)
				{
					arr[++arrcount] = digit.charAt(j);
				}				
				arrcount++;
			}else {
				return s;
			}
		}
		return new String(arr);
	}

}
