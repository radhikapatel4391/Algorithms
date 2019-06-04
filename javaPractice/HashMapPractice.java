package javaPractice;

import java.util.HashMap;

public class HashMapPractice {

	public static void main(String[] args) {
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	hm.put("Radhika",1);
	hm.put("Radhika",2);
	hm.put("Dhaval",3);
	for(String s:hm.keySet())
	{
		System.out.println(s+hm.get(s));
	}
	

	}

}
