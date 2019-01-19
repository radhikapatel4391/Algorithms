package ch3stacksAndQueues;

import java.util.NoSuchElementException;

public class ThreeinOne {

	private int stacksize = 10;
	private int noOfStacks = 3;	
	private int[] arr ; 
	private int[] tops;
	
	public ThreeinOne(int stacksize,int noOfStacks)
	{
		this.stacksize = stacksize;
		this.noOfStacks = noOfStacks;
		arr = new int[stacksize*noOfStacks];
		tops = new int[noOfStacks];
		System.out.println("stackNumber start with 1....");
		for(int i=0;i<noOfStacks;i++)
		{
			tops[i] = (i*stacksize)-1; // stackno*n/noOfstacks - n = noofstack*size
		}
	}
	public ThreeinOne(int stacksize)
	{
		this(stacksize,3);
	}
	public ThreeinOne()
	{
		this(10,3);
	}
	public void push(int stackNum,int item)
	{
		if(isFull(stackNum)) throw new StackOverflowError();
		tops[stackNum-1]++;
		arr[tops[stackNum-1]] = item;
		
		
	}
	public int peek(int stackNum)
	{
		if(isEmpty(stackNum)) throw new NoSuchElementException();
		
		return arr[tops[stackNum-1]];
	}
	public int pop(int stackNum)
	{
		if(isEmpty(stackNum)) throw new NoSuchElementException();
		int item = arr[tops[stackNum-1]];
		arr[tops[stackNum-1]] = 0; //clear
		tops[stackNum-1]--; 
		return item;
	}
	public boolean isEmpty(int stackNum)
	{
		return tops[stackNum-1] == ((stackNum-1)*stacksize)-1; // (i*stacksize)-1
	}
	public boolean isFull(int stackNum)
	{
		return tops[stackNum-1] == (stackNum*stacksize)-1; // 
	}
	public void print() {
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		ThreeinOne ob1 = new ThreeinOne(5,2);
		System.out.println("true == "+ob1.isEmpty(1));
		System.out.println("true == "+ob1.isEmpty(2));
		System.out.println("False == "+ob1.isFull(1));
		System.out.println("False == "+ob1.isFull(2));
		ob1.push(1, 1);
		ob1.push(2, 2);
		ob1.push(1, 1);
		ob1.push(2, 2);
		ob1.push(1, 1);
		ob1.push(2, 2);
		ob1.push(1, 1);
		ob1.push(2, 2);
		ob1.push(1, 5);
		ob1.push(2, 55);
		//ob1.push(1, 1); error
		//ob1.push(2, 2); error
		
		System.out.println("5 == "+ob1.peek(1));
		System.out.println("55 == "+ob1.peek(2));
		ob1.pop(1);
		ob1.pop(2);
		
		ob1.print();
		ThreeinOne ob2 = new ThreeinOne(15,3);
		System.out.println("true == "+ob2.isEmpty(1));
		System.out.println("true == "+ob2.isEmpty(2));
		System.out.println("true == "+ob2.isEmpty(3));
		System.out.println("False == "+ob2.isFull(1));
		System.out.println("False == "+ob2.isFull(2));
		System.out.println("False == "+ob2.isFull(3));
		ob2.push(1, 1);
		ob2.push(2, 2);
		ob2.push(3, 3);
		ob2.print();
	}
	
}
