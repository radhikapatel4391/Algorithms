import java.util.*;
public class e_intervals {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	class Node
	{
		char flag;
		float value;
		Node(char f,float v)
		{
			flag = f;
			value = v;
		}
	}
	while(sc.hasNext())
	{
		String s = sc.nextLine();
		
		while(!s.matches(".*\\w+.*"))
			 s = sc.nextLine();
		System.out.println(s);
		int n = sc.nextInt();
		Node[] arr = new Node[2*n];
		for(int i =0;i<2*n;i++)
		{
			Node start = new Node('s',sc.nextFloat());
			arr[i] = start;
			Node end = new Node('e',sc.nextFloat());
			arr[++i] = end;			
		}
		
		 Arrays.sort(arr,  new Comparator<Node>() {
		        @Override
		        public int compare(Node e1, Node e2) {
		        	if (e1.value < e2.value) return -1;
		            if (e1.value ==  e2.value) return 0; // Fails on NaN however, not sure what you want
		            if (e1.value >  e2.value) return 1;
		            return 0;
		        }
		    });
		 float sum = 0;
		 float start = arr[0].value;
		 for(int k=1;k<2*n;k++)
		 {
			 while(k<arr.length && arr[k].flag=='s')
				 k++;
			 while(k<arr.length && arr[k].flag=='e')
				 k++;
			 float end = arr[k-1].value;
			 sum +=end-start;
			 if(k<arr.length)
				 start = arr[k].value;			 
		 }
		 System.out.printf("%.3f",sum);
		 System.out.println();
		
	}
	}

}
