package javaPractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class PriorityQueueExmple {

	class Node implements Comparable<Node>{
		String name;
		int distance;
		Node(String name,int distance)
		{
			this.name = name;
			this.distance = distance;
		}
		public int compareTo(Node other)
		{
			if(distance>other.distance)
				return 1;
			else if(distance<other.distance)
				return -1;
			else
				return 0;
		}
	}
	public static void main(String[] args) {
		PriorityQueueExmple obj = new PriorityQueueExmple();
		PriorityQueue<PriorityQueueExmple.Node> Q = new PriorityQueue<PriorityQueueExmple.Node>();
		Deque<String> deque = new ArrayDeque<String>(); 
		//deque.
		Q.add(obj.new Node("a",100));
		Q.add(obj.new Node("b",2));
		Q.add(obj.new Node("c",50));
		Q.add(obj.new Node("d",0));
		for(PriorityQueueExmple.Node n:Q )
		{
			System.out.println(n.distance +"   "+n.name);
		}

	}

}
