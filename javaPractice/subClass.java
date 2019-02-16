package javaPractice;

public class subClass extends superClass {

	public static void main(String[] args) {
		subClass sub = new subClass();
		sub.test();
		superClass sup = new  superClass();
		sup.test();
		superClass supp = new subClass();
		supp.test(); // superclass get called.......
		supp.test2(); // subclass get called.........but if not exist in superClass then compile error..
	//	subClass subsuper = (subClass) new  superClass();// error.....runtime
	
	}
	public static void test() {
		System.out.println("subclass");
	}
	public void test2()
	{
		System.out.println("Hello from test2 at subclass");
	}
}
