package ch3stacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Mystack<T> implements Cloneable {
	public static class StackNode<T>{
		private T data;
		private StackNode<T> next = null;
		
		public StackNode(T data)
		{
			this.data = data;
		}
	}
	
	private StackNode<T> top = null;
	private int size = 0;
	public int getSize() {
		return size;
	}
	public T pop() {
		if (top == null) new EmptyStackException();
			
		T item = top.data;
		top = top.next;
		size--;
		return item;
		
	}
	public void push(T item)
	{
		
		StackNode<T> newnode = new StackNode(item);
		newnode.next = top;
		top = newnode;
		size++;
	}
	public T peek() {
		if (top == null) new EmptyStackException();
		return top.data;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public Mystack<T> clone() throws CloneNotSupportedException{
		return (Mystack<T>) super.clone();
	}
	public ArrayList<T> createArray() throws CloneNotSupportedException {
		Mystack<T> tempstack = this.clone();
		ArrayList<T> arr = new ArrayList<T>(this.size);
		
		
		while(tempstack.getSize()>0)
		{
			arr.add(tempstack.pop());
		}
		return arr;
	}
	
	public void print() throws CloneNotSupportedException {
		Mystack<T> tempstack = this.clone();
		System.out.print("Top to Bottom : ");
		while(tempstack.getSize()>0)
		{
			System.out.print(tempstack.pop()+" ");
		}
		System.out.println();
	}
}
