package javaPractice;
import java.util.*;
public class arrayObjectPassByvalue {

	public static void main(String[] args) {
		HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
		String[] arr1 = new String[1];
		ArrayList[] arr2 = new ArrayList[2];
		ArrayList<Integer> l =  new ArrayList();
		l.add(7);
		ArrayList<String> l2 =  new ArrayList();
		l2.add("Radhika");
		map.put("Radhika",l);
		arr1[0] = "Radhika";
		arr2[0] = l;
		arr2[1] = l2;
		System.out.println("map size: "+map.size());
		System.out.println(arr2[0].get(0));
		System.out.println(arr1[0]);
		change(arr1,arr2,map);
		System.out.println("map size: "+map.size());
		System.out.println(arr2[0].get(0));
		System.out.println(arr1[0]);
	}
	public static void change(String[] arr11,ArrayList[] arr22,HashMap<String,ArrayList<Integer>> mapp)
	{
		System.out.println("In side Change ......");
		arr11[0] = "Patel";
		
		ArrayList<Integer> l =  new ArrayList();
		l.add(5);
		arr22[0] = l;
		mapp.put("Patel",l);
		System.out.println("map size: "+mapp.size());
		System.out.println(arr22[0].get(0));
		System.out.println(arr11[0]);
		System.out.println("Return from chage");
	}
}
