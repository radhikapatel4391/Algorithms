import java.util.*;


public class m_toll {
	class Edge
	{
		String startNode;
		String endNode;
		
		Edge(String start,String end)
		{
			this.startNode = start;
			this.endNode = end;
			
		}
	}
	public static void main(String[] args) {
		m_toll object = new m_toll();
		Scanner sc = new Scanner(System.in);
		int caseCount = 0;
		while(sc.hasNext())
		{
			caseCount++;			
			int edgecount = sc.nextInt();
			if (edgecount==-1)
					return;
			System.out.printf("Case %d: ",caseCount);
<<<<<<< HEAD
			ArrayList<Edge> edges = new ArrayList<Edge>(2*edgecount);
=======
			ArrayList<Edge> edges = new ArrayList<Edge>(edgecount);
>>>>>>> parent of 97c8f38... update
			Set<String> vertices = new HashSet<String>();
			while(edgecount>0)
			{
				edgecount--;
				String s = sc.next("[A-Za-z]");				
				String e = sc.next("[A-Za-z]");
				vertices.add(e);				
				vertices.add(s);			
<<<<<<< HEAD
				edges.add(object.new Edge(s,e));
				edges.add(object.new Edge(e,s));	
=======
				edges.add(object.new Edge(s,e));				
>>>>>>> parent of 97c8f38... update
			}
			int n = sc.nextInt();
			String start = sc.next("[A-Za-z]");
			String end = sc.next("[A-Za-z]");
			
			HashMap<String,ArrayList<Edge>> graph = new HashMap<String,ArrayList<Edge>>();
			HashMap<String,Integer> mtable = new HashMap<String,Integer>(vertices.size());
			for(String s:vertices)
			{
				mtable.put(s, 0);
			}
			
			boolean hasUppercase = !end.equals(end.toLowerCase());
			if(hasUppercase)
			{
				double a = 20/19d;
				 a = n*a; 
				n= (int)Math.ceil(a);
			}
			else
				n = n+1;
			mtable.put(end, n);
			for(Edge edge:edges)
			{
				String key = edge.startNode;
<<<<<<< HEAD
				ArrayList<Edge> value = graph.get(key);
				if(value==null)
					value = new ArrayList<Edge>();
				value.add(edge);
				graph.put(key,value);
=======
				graph.computeIfAbsent(key,k->new ArrayList<Edge>()).add(edge);
>>>>>>> parent of 97c8f38... update
			}
			int ans = findMinVlaue(graph,mtable,start,end);
			 hasUppercase = !start.equals(start.toLowerCase());
			if(hasUppercase)
			{
				double d = 20D;
				ans = (int) (ans - Math.ceil((ans/d)));
			}
			else
			{
				ans = ans-1;
			}			
			System.out.println(ans);
		}
		 sc.close();			
		}
	public static int findMinVlaue(HashMap<String,ArrayList<Edge>> graph,HashMap<String,Integer> mtable,String start,String end)
	{
		
		int ans = mtable.get(start);
		if(start==end)
			return ans;
<<<<<<< HEAD
//		if(ans==-1) //lopp case...
//			return Integer.MAX_VALUE;
		if(ans!=0 && ans!=Integer.MAX_VALUE)
			return ans;
		mtable.put(start,-1);
		int min = Integer.MAX_VALUE;
		ArrayList<Edge> list = graph.get(start);
		if(list!=null)
		{
		    for(Edge e:list)
		{
		    if(mtable.get(e.endNode)!=-1)
		    {
		    	int x = findMinVlaue(graph,mtable,e.endNode,end);			
				min = Math.min(min, x);
		    }
		}
		}
		if(min<Integer.MAX_VALUE)
		{
			boolean hasUppercase = !start.equals(start.toLowerCase());
			//	boolean hasLowercase = !start.equals(start.toUpperCase());
				if(hasUppercase)
				{
					double a = 20/19d;
					 a = min*a; 
					min= (int)Math.ceil(a);
				}
				else
					min = min+1;
		}
=======
		if(ans==-1) //lopp case...
			return 10000;
		if(ans!=0)
			return ans;
		mtable.put(start,-1);
		int min = Integer.MAX_VALUE;
		for(Edge e:graph.get(start))
		{
			int x = findMinVlaue(graph,mtable,e.endNode,end);			
			min = Math.min(min, x);
		}
		boolean hasUppercase = !start.equals(start.toLowerCase());
		//	boolean hasLowercase = !start.equals(start.toUpperCase());
			if(hasUppercase)
			{
				double a = 20/19d;
				 a = min*a; 
				min= (int)Math.ceil(a);
			}
			else
				min = min+1;
>>>>>>> parent of 97c8f38... update
		mtable.put(start,min);
		return min;
		
	}

	}


