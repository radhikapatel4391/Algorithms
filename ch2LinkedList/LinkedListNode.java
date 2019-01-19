package ch2LinkedList;

public class LinkedListNode<T>implements Cloneable  {
	public LinkedListNode next = null;
	public T data = null;
	public LinkedListNode()
	{
		this.data = null;
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		} 
	public LinkedListNode(T data)
	{
		this.data = data;
	}
}
