package OverridingEx;

import javaPractice.TestStaticBlockCalled;

public class SubClass extends SuperClass {

	TestStaticBlockCalled test() {
		return new TestStaticBlockCalled();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
