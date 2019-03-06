package ch3stacksAndQueues;



public class QueueUsingStcks<T> {

	private Mystack<T> olds= new Mystack<T>();
	private Mystack<T> news= new Mystack<T>();
	public void add(T item) {
		news.push(item);
	}
	public T remove() {
		shiftMystacks();
		return olds.pop();
	}
	public T peek()
	{
		shiftMystacks();
		return olds.peek();
	}
	private void shiftMystacks() {
		if(olds.isEmpty())
		{
			while(!news.isEmpty())
			{
				olds.push(news.pop());
			}
		}
	}
	public int size()
	{
		return olds.getSize() + news.getSize();
	}
	public boolean isEmpty() {
		return olds.isEmpty() && news.isEmpty();
	}
	public void print() throws CloneNotSupportedException
	{
		System.out.println("Queue is..");
		olds.print();
		news.print();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		QueueUsingStcks<Integer> ob1 = new QueueUsingStcks<Integer>();
		ob1.add(1);
		ob1.add(2);
		ob1.add(3);
		ob1.add(4);		
		ob1.print();
		ob1.remove();
		ob1.remove();
		ob1.add(5);
		ob1.add(6);	
		ob1.add(7);	
		ob1.add(8);	
		ob1.print();
	}

}
