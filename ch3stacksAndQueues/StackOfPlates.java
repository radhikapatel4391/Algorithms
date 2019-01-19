package ch3stacksAndQueues;

import java.util.ArrayList;

public class StackOfPlates<T> {
	
	private ArrayList<Mystack<T>> stacks = new ArrayList<Mystack<T>>();
	private int capasity = 10;
	public StackOfPlates(int capasity) {
		this.capasity = capasity;
		stacks.add(new Mystack<T>());
	}
	
	public void push(T item)
	{//current stack is not full....
		if(stacks.get(stacks.size()-1).getSize()<capasity)
		{
			stacks.get(stacks.size()-1).push(item);
		}else {// stack is full so add new stack and element in that new stck....
			Mystack<T> temp = new Mystack<T>();
			temp.push(item);
			stacks.add(temp);
		}
	}
	public T pop()
	{
		return popAt(stacks.size()-1);
	}
	public T popAt(int index)
	{
		T item = stacks.get(index).pop();
		if(stacks.get(index).isEmpty())
			stacks.remove(index);
		return item;
	}
	public void print()
	{ 
		stacks.forEach((n)-> {
			try {System.out.println("Stack :");
				n.print();
				
				
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
	
		StackOfPlates<Integer> ob1 = new StackOfPlates<Integer>(5);
		ob1.push(1);
		ob1.push(2);
		ob1.push(3);
		ob1.push(4);
		ob1.push(5);
		ob1.push(6);
		ob1.push(7);
		ob1.push(8);
		ob1.push(9);
		ob1.push(10);
		ob1.push(11);
		ob1.print();
		ob1.pop();
		ob1.pop();
		ob1.print();
		ob1.popAt(1);
		ob1.print();
		

	}

}
