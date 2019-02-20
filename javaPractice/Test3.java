package javaPractice;

public interface Test3 extends Test1,Test2 {

	@Override
	default void test() {
		// TODO Auto-generated method stub
		Test1.super.test();
	}

}
