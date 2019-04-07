package javaPractice;

import java.util.ArrayList;
import java.util.HashMap;

public class mapPractice {

	public static void main(String[] args) {
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		map.computeIfAbsent(1, k -> new ArrayList<Integer>()).add(2);
		map.computeIfAbsent(1, k -> new ArrayList<Integer>()).add(2);
		map.computeIfAbsent(1, k -> new ArrayList<Integer>()).add(2);
		map.computeIfAbsent(1, k -> new ArrayList<Integer>()).add(2);
		for(Integer i: map.get(1))
		{
			System.out.println(i);
		}
	}

}
