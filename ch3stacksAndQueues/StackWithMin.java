package ch3stacksAndQueues;

public class StackWithMin extends Mystack<Integer> {
	private Mystack<Integer> minstack = new Mystack<Integer>();
	
	public Integer min() {
		
		if(minstack.isEmpty()) return Integer.MAX_VALUE;
		return minstack.peek();
	}
	public void push(Integer item) {
		if(min()>item)
		{
			minstack.push(item);
		}
		super.push(item);
	}
	public Integer pop() {
		Integer item = super.pop();
		if(item==min())
			minstack.pop();
		return item;
	}
	

	public static void main(String[] args) {
		StackWithMin s = new StackWithMin();
		s.push(5);
		System.out.println("5 == "+s.min());
		s.push(6);
		System.out.println("5 == "+s.min());
		s.push(3);
		System.out.println("3 == "+s.min());
		s.push(7);
		System.out.println("3 == "+s.min());
		s.pop();
		System.out.println("3 == "+s.min());
		s.pop();
		System.out.println("5"
				+ " == "+s.min());
		
		
	}

}
