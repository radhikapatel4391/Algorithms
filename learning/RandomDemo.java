package learning;
import java.util.*;
public class RandomDemo{
	
	public static void main(String[] args){
	Random rand = new Random();
	Set<Integer> s = new HashSet<Integer>(100);
	for(int i=0;i<110;i++)
	{
		s.add(rand.nextInt(100));
		
	}
	System.out.println(s.size());
	}
}