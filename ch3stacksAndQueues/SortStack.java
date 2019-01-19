package ch3stacksAndQueues;

public class SortStack {

	public static Mystack<Integer> sortStack(Mystack<Integer> s)
	{
		Mystack<Integer> r = new Mystack<Integer>();
		while(!s.isEmpty())
		{
			Integer item = s.pop();
			while(!r.isEmpty() && r.peek()<item)
			{
				s.push(r.pop());
			}
			r.push(item);
		}
		return r;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Mystack<Integer> stack = new Mystack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(6);
		stack.push(8);
		stack.push(1);
		stack.push(2);
		stack.print();
		System.out.println("Sorted..min on top");
		SortStack.sortStack(stack).print();
	}

}
