

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

	public static void main(String[] args) {
		
		String str = "bbb";
		System.out.println("Using String matches method: "+str.matches(".bb"));
		System.out.println("Using Pattern matches method: "+Pattern.matches(".bb", str));
		// using pattern with flags
		Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("ABcabdAb");
		// using Matcher find(), group(), start() and end() methods
		while (matcher.find()) {
			System.out.println("Found the text \"" + matcher.group()
					+ "\" starting at " + matcher.start()
					+ " index and ending at index " + matcher.end());
		}

		// using Pattern split() method
		pattern = Pattern.compile("\\W");
		String[] words = pattern.split("one@two#three:four$five");
		for (String s : words) {
			System.out.println("Split using Pattern.split(): " + s);
		}

		// using Matcher.replaceFirst() and replaceAll() methods
		pattern = Pattern.compile("1*2");
		matcher = pattern.matcher("11234512678");
		System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
		System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
	}

}
