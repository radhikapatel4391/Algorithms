import java.util.regex.*;


public class RegularExpressionDemo {

	public static void main(String[] args) {
		int caseCount=1,countt=2,length=3;
		float anss = 4.55555f;
		System.out.printf("Case "+caseCount+": "+countt+"/"+length+" = %.1f",anss);
		System.out.println("%");
//		String x = "radhika \n"
//				+ "patel";
//		System.out.println(x);
//		System.out.println(Pattern.matches("radhika\\s+patel",x));
		String input="CV";
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
		//String s = "\\w[aeiou]\\w.*";
		//boolean r = pattern.toString().equals(s);		
		//System.out.println("I am pattern string: "+pattern.toString()+" "+r+" "+s);
		System.out.println(pattern.toString());
		String s = "do you like my new nonsense";
		System.out.println(s);
		Pattern pObj = Pattern.compile(pattern.toString()); //"\\w[aeiou]\\w.*"
		String[] arr = s.split("\\s+");
		int count = 0;
		for(String sub:arr)
		{
			Matcher m = pObj.matcher(sub);
			if(m.matches())
				count++;
		}
		float ans = (count*100)/(float)arr.length; //1f*(3*100)/arr.length ; // 
		System.out.printf(count+"/"+arr.length+"="+"%.1f",ans);

	}

}
