package javaPractice;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTableTest {

	public static void main(String[] args) {
		Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
		ht.put(1,"one");
		
		Set<Map.Entry<Integer,String>> s = ht.entrySet();
		Set<Integer> keySet = ht.keySet();
		Collection<String> valuesCollection = ht.values();
		
		Enumeration<Integer> keys = ht.keys();		
		Enumeration<String> values = ht.elements();
		
		ht.put(2,"two");
		ht.put(3,"one");
		ht.put(4,"one");

		for(Map.Entry<Integer,String> m: s)
		{
			System.out.println("map key value pair: "+m.getKey()+" "+m.getValue());
		}
		for(Integer key:keySet)
		{
			System.out.println("keyset iteration: "+key);
		}
		
		while(keys.hasMoreElements())
		{
			System.out.println("keys enumerator keys: "+keys.nextElement());
		}
		while(values.hasMoreElements())
		{
			System.out.println("values enumerator values: "+values.nextElement());
		}	
		
		for(String v:valuesCollection)
		{
			System.out.println("valuesCollection value "+v);
		}
	
		
	}

}
