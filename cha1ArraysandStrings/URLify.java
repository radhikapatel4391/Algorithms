package cha1ArraysandStrings;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceSpace("Mr John smith    ",13));
	}
	public static String replaceSpace(String input,int count)
	{
		
	
		char[] output = new char[input.length()];
		
		int k = 0;
		for(int i =0;i<count;i++)
		{
			if(input.charAt(i) != ' ')
			{
				output[k] = input.charAt(i);
				k++;
			}else
			{
				output[k] = '%';
				output[k+1] = '2';
				output[k+2] = '0';
				k+=3;
			}
		}
		return new String(output);
	}

}
