package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;

public class SuperClass {

	public static void main(String[] args) {
		//TestStaticBlock t1 = new TestStaticBlockCalled(4);
		System.out.println(TestStaticBlockCalled.x);
	}
	
	public static void test() throws IOException {
		System.out.println("super class");
		/*
		 * try (BufferedReader br = new BufferedReader(null, 0)) {
		 * 
		 * }
		 */
	}
	 
	
	  public void test2() { System.out.println("Hello from test2 at superclass"); }
	 
}
