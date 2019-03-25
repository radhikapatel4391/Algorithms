import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class m_serializable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			
			int T = sc.nextInt();
			int S = sc.nextInt();
			HashMap<String,LinkedList<String>> table = new HashMap<String,LinkedList<String>>(T);
			String[] arr = new String[S];
			for(int i=0;i<S;i++)
			{
				arr[i] = Integer.toString(sc.nextInt());
			}
			sc.nextLine();
			for(int i = 1;i<=T;i++)
			{
				String[] sarr = sc.nextLine().split(" ");
				LinkedList<String> list = new LinkedList<String>();
				for(String s:sarr)
				{
					list.add(s);
				}
				
				table.put(Integer.toString(i),list);
			}
			for(int i=0;i<S;i++)
			{				
				arr[i] += table.get(arr[i]).removeFirst();
			}
			boolean flag = true;
			for(int i = arr.length-1;i>=0;i--)
			{
				if(arr[i].contains("W"))
				{
					int read = arr.length;
					int write = -1;
					String r = arr[i].charAt(0)+"R"+arr[i].charAt(2);
					String w = "W"+arr[i].charAt(2);
					for(int j =i-1;j>=0;j--)
					{
						if(arr[j].equals(r))
							read = j;
						else if(arr[j].contains(w))
							write = j;
					}
					if(read<write)
					{						
						flag = false;
						break;
					}					
				}
			}
			if(flag)
				System.out.println("SERIALIZABLE");
			else
				System.out.println("NON-SERIALIZABLE");
		}

	}

	

}
