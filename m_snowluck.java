import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class m_snowluck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n==0)
				return;
			HashMap<Integer,ArrayList<Integer>> trees = new HashMap<Integer,ArrayList<Integer>>(n-1);
			for(int i=1;i<n;i++)
			{
				trees.put(i,new ArrayList<Integer>());
				for(int j=0;j<4;j++)
				{
					trees.get(i).add(sc.nextInt());
				}
			}
			
			
		}
		sc.close();


	}

}
