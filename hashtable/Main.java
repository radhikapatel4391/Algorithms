package hashtable;

import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Test1();
		Test2();
		
	}
	private static void Test1() {
		HashTable<String,Integer> ht = new HashTable<String,Integer>(10);
		System.out.println("Blank: "+ht);
		ht.set("Radhika",0);
		System.out.println("1 added: "+ht);
		ht.remove("Radhika");
		System.out.println("removed: "+ht);
		ht.set("Dhaval",1);
		ht.set("Radhika",2);
		ht.set("om",3);
		ht.set("dhara",5);
		System.out.println(ht);
		ht.set("Radhika",7);		
		ht.insert("Dhaval",3);		
		ht.set("dhara",10);
		System.out.println(ht);
	}
	private static void Test2() {
		
		
		Dummy bob = new Dummy("Bob", 20);
		Dummy jim = new Dummy("Jim", 25);
		Dummy alex = new Dummy("Alex", 30);
		Dummy tim = new Dummy("Tim", 35);
		Dummy maxwell = new Dummy("Maxwell", 40);
		Dummy john = new Dummy("John", 45);
		Dummy julie = new Dummy("Julie", 50);
		Dummy christy = new Dummy("Christy", 55);
		Dummy tim2 = new Dummy("Tim", 100); // This should replace the first "tim"
		
		Dummy[] dummies = {bob, jim, alex, tim2, maxwell, john, julie, christy,tim};
		
		 //Test: Insert Elements. 
		HashTable<String, Dummy> hash = new HashTable<String, Dummy>(3);
		for (Dummy d : dummies) {
			hash.insert(d.getName(), d);
		}
		System.out.println("created hash table....."+hash.getSize());
		System.out.println(hash);	
		System.out.println(" ");
		System.out.println("change tim age 35 to 100...........");
		hash.set(tim2.getName(), tim2);
		System.out.println(hash);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Remove entry one by one..........");
		 //Test: Recall 
		for (Dummy d : dummies) {
			String name = d.getName();
			Dummy dummy = hash.get(name);
			if (dummy == null) {
				System.out.println("Dummy named " + name + ": null");
			} else {
				System.out.println("Dummy named " + name + ": " + dummy.toString());
			}
			Dummy d2 = hash.remove(name);
			if (d2 == null) {
				System.out.println("Dummy removed named " + name + ": " + "null");
			} else {
				System.out.println("Dummy removed named " + name + ": " + d2.toString());
			}
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("after remove hash table.....");
		System.out.println(hash);
	}

}
