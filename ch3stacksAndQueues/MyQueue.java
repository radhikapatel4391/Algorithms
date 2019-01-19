package ch3stacksAndQueues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyQueue<T> {
	public static class QueueNode<T>
	{
		T data;
		QueueNode<T> next = null;
		public QueueNode(T data) {
			this.data = data;
		}
	}
	private QueueNode<T> front = null;
	private QueueNode<T> rear = null;
	
	public void add(T item)
	{
		QueueNode<T> ni = new QueueNode<T>(item);
		if(rear != null)
		{
			rear.next = ni;				
		}		
		rear = ni; // rear = rear.next;
		if(front == null)
			front = rear;
		
	}
	public T remove() {
		if(front == null) new NoSuchElementException();
		T  item = front.data;
		front = front.next;
		if(front == null)
			rear = null;
		return item;
	}
	public T peek() {
		if(front == null) new EmptyStackException();
		return front.data;
	}
	public boolean isEmpty() {
		return front == null;
	}
}
