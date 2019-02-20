package javaPractice;

interface Test1 {
	   int i =90;
	 
	 int wwwww =90;
	public void get();

	 default void test() {
		System.out.println("I am from test1");
		System.out.println(i);
	}
	private void t() {
		System.out.println(i);
	}
	private static void tt() {
		
	}
	public static void testStatic() {
		System.out.println("I am from test1 testStatic");

	}
}
