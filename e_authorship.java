import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e_authorship {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseCount = 0;
		while(sc.hasNext())
		{
			caseCount++;
			
			//get pattern
			String patternInput = sc.next();			
			if(patternInput.endsWith("*"))
				return;
			
			//get to match string
			StringBuilder inputString = new StringBuilder(sc.nextLine());			
			while(inputString.lastIndexOf("*")==-1)
				inputString.append("\n"+sc.nextLine());		
			
			//find count of words....
			String arr[] = inputString.toString().split("\\s+");		
			String pattern = createPattern(patternInput);
			int count = findMatchedWords(pattern,arr);
			
			//print format....
			float ans = (count*100)/(float)(arr.length-2); //1f*(3*100)/arr.length ; // 
			System.out.printf("Case "+caseCount+": "+count+"/"+(arr.length-2)+" = %.1f",ans);
			System.out.println("%");
		}

	}
	public static int findMatchedWords(String pattern,String[] arr)
	{
		Pattern pObj = Pattern.compile(pattern);
		int count = 0;
		for(int i=1;i<arr.length-1;i++) //we don't want * so
		{
			String sub = arr[i];
			Matcher m = pObj.matcher(sub);
			if(m.matches())
				count++;
		}
		return count;
	}
	public static String createPattern(String input)
	{
		StringBuilder pattern = new StringBuilder(); 
		for(int i=0;i<input.length();i++)
		{
			char c = input.charAt(i);
			if(c=='C')
				pattern.append("[^aeiou]");
			else if(c=='V')
				pattern.append("[aeiouy]");
			else
				pattern.append(c);
		}
		pattern.append(".*");
		return pattern.toString();
	}

}
