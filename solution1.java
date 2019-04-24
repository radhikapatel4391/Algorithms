import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class solution1 {

	public static void main(String[] args) {
		superStack(args);
	}
	public static void superStack(String args[])
	{

		ArrayList<Integer> stack = new ArrayList<Integer>();
		for(String s:args)
		{
			int element;
			int e  = 0;
			int k =0;
			String[] arr = s.split(" ");
			if (arr[0].contains("push"))
			{
				element = Integer.parseInt(arr[1]);
				stack.add(element);
			}
			else if(arr[0].contains("pop"))
			{
				element = stack.remove(stack.size()-1);
			}
			else {
				e = Integer.parseInt(arr[1]);
				k = Integer.parseInt(arr[2]);				
				
				for(int i = 0;i<e;i++)
				{
					int x = stack.get(i);
					x = x+k;
					stack.set(i, x);
				}
			}
			
			if (stack.size()>0)
			{
				System.out.println(stack.get(stack.size()-1));
			}else
			{
				System.out.println("EMPTY");
			}
			
		}
		
	}

}
