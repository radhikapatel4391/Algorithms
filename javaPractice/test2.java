package javaPractice;

public interface test2 {
	public static final int i = 32;
	 public void get();
	 default void test() {
		 System.out.println("I am from test1");
	 }
}
