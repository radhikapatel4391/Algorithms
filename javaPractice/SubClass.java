package javaPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SubClass extends SuperClass {

	
	public void print(Set<String> strSet) {
	}
	// public void print(Set<Integer> intSet) { }

	public static void main(String[] args) {
		//System.out.format("The square root of %d is %f.%n");//runtime exception....
		try {
			
			BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
	        BufferedWriter outputStream = new BufferedWriter(new FileWriter("characteroutput.txt"));
			//inputStream.
			  Console c = System.console();
		        if (c == null) {
		            System.err.println("No console.");
		            System.exit(1);
		        }

		        String login = c.readLine("Enter your login: ");
		        char [] oldPassword = c.readPassword("Enter your old password: ");
			//int i = 1/0;
			String s;
			String j = (s="text");
			System.out.println(s +"   "+j);
		} catch (RuntimeException e) {
			System.out.println("error divide by zero");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		try {

		} finally {

		}
		
		Object[] arr = new Object[2];
		arr[0] = new ArrayList<String>();
		arr[1] = new ArrayList<Integer>();
		for (Object i : arr) {
			System.out.println(i);
		}

		StringBuilder b = new StringBuilder("Able was I ere I saw Elba.");
		System.out.println(b.capacity());
		System.out.println("Did Hannah see bees? Hannah did.".length());
		List<Integer> li = new ArrayList<>();

		for (int i = 1; i < 50; i += 2)
			li.add(i);

		Integer x = 5;
		int y = x;
		/*
		 * for(Integer i : li ) { System.out.println(i); }
		 */

		String s = "a";
		System.out.println(s.compareTo("zabc"));
		SubClass sub = new SubClass();
		try {
			SuperClass sup = new SuperClass();
			sup.test();
			SuperClass supp = new SubClass();
			supp.test(); // superclass get called.......
			supp.test2(); // subclass get called.........but if not exist in superClass then compile
							// error..
			// subClass subsuper = (subClass) new superClass();// error.....runtime
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static void test() throws IOException {
		System.out.println("subclass");
		try (BufferedReader br = new BufferedReader(null, 0)) {
			
		}
	}

	public void test2() {
		System.out.println("Hello from test2 at subclass");
	}
}
