import java.util.*;
public class e_rle {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext())
	{
		String s = sc.nextLine();
		s = s.trim();
		StringBuilder newString = new StringBuilder();
		boolean flag = false;
		int oneCount = 0;
		char current = s.charAt(0);
		for(int i = 1;i<s.length();i++)
		{
			int count = 1;
			
			while(i<s.length() && current==s.charAt(i++))
				count++;
			
			if(count>1)
			{
				flag = true;
			}
			else
			{
				flag = false;
				oneCount++;
			}
			if(flag && oneCount>0)
			{
				newString.append('1');
				oneCount = 0;
				flag = false;
			}
			if(count==1 && !flag && oneCount>1)
				newString.append(""+current);
			else
				newString.append(""+count+current);
			
			if (current=='1')
				newString.append('1');
			if(i-1<s.length())
			{
				current = s.charAt(i-1);
				i=i-1;
			}
		}
		System.out.println(newString.toString().trim());
	}

	}

}
