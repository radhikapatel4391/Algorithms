package javaPractice;

interface test1 {
	public static final int i = 45;

	public void get();

	default void test() {
		System.out.println("I am from test1");

	}

	public static void testStatic() {
		System.out.println("I am from test1 testStatic");

	}
}
