package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

enum Day {

	 MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY

	}

	public class BuggyBread1{

	    public static void main (String args[]) {
	    	System.err.print("Error....");
	    	String s = "Radhika patel";
	    	String s2 = "Radhika patel";
	    	String sub = s.substring(3, 7);
	    	System.out.println(s.hashCode());
	    	System.out.println(s2.hashCode());
	    	System.out.println(sub.hashCode());

	    	String[] arr = new String[20];
	    	List<String> a = Arrays.asList(arr);
	    List<String> l = new ArrayList(a);
	    l.add("Radhika");
	    for(String ss:l)
	    {
	    	System.out.println(ss);
	    }
	    
	     

	    }

	}