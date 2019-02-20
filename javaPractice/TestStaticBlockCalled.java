package javaPractice;

import hashtable.Node;

public class TestStaticBlockCalled extends TestStaticBlock{
	TestStaticBlockCalled()
	{
		super(7);
	}
	static{
		System.out.println("TestStaticBlockCalled Child static..");
		System.out.println(Node.temp);
	}
	public static void main(String[] args) {
		
		TestStaticBlockCalled t1 = new TestStaticBlockCalled();
		t1.test();
		//System.out.println(t1.x);
	}
	public void test() {
		System.out.println(this.toString());
	}

}
