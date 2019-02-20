package javaPractice;

public interface Test2 {
	public static final int i = 32;
	 public void get();
	 default void test() {
		 System.out.println("I am from test1");
	 }
}
