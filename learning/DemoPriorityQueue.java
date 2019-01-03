package learning;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;

public class DemoPriorityQueue
{

	public static void main(String[] args)
	{
		Queue q1 = new PriorityQueue(10);
		Queue<Employee> emps = new PriorityQueue<Employee>(5);
		/*for (int i = 10;i>0;i--)
		{
			q1.add(i);
		}
		for (int i = 10;i>0;i--)
		{
			System.out.println(q1.poll());
		}*/
		
		for (int i = 10;i>0;i--)
		{
			emps.add(new Employee(i+"","name"+i));
		}
		for (int i = 10;i>0;i--)
		{
			System.out.println(emps.poll().getid());
		}
		
	}
	public static Comparator<Employee> empcomp = new Comparator<Employee>() {
		@Override
		public  int compare(Employee e1,Employee e2)
		{
			return e1.getid().compareTo(e2.getid());
		}
	};
	

	
}