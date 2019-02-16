package javaPractice;

public class testInterfaces implements test2,test1{

	public void get() {
		//System.out.println(this.i);
		test2.super.test();

	}
	public static void main(String[] args) {
		test1.testStatic();
	}
	
	  public void test() { System.out.println("testInterface"); }
	  
	  
	 }
