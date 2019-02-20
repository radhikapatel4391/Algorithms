package javaPractice;
import hashtable.Node;
	public  class TestStaticBlock {
		static int x = 10;
		//private abstract void t(); 
		public TestStaticBlock(int i) {
			
		}
		
		//int i = 0;
	static {
		
		System.out.println("Get called TestStaticBlock");
	}
	
	public static void main(String[] args) {
		System.out.println("TestStaticBlock main method");
		TestStaticBlock t1 = new TestStaticBlock(1);
		TestStaticBlock t2 = new TestStaticBlock(1);
		
		t1.test();
		Foo f = new Foo();
	//	Node n = new Node(null, null);
	}
	public void test() {
		System.out.println(this.toString());
	}

}
