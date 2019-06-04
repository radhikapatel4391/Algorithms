import java.util.*;


public class m_maxflow {
	class Edge
	{
		String startNode;
		String endNode;
		int weight;
		Edge(String start,String end,int weight)
		{
			this.startNode = start;
			this.endNode = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m_maxflow object = new m_maxflow();
		while(sc.hasNext())
		{
<<<<<<< HEAD
			caseCount++;			
			int edgecount = sc.nextInt();
			if (edgecount==-1)
					return;
			System.out.printf("Case %d: ",caseCount);
			ArrayList<Edge> edges = new ArrayList<Edge>(2*edgecount);
=======
			String start = sc.next("[A-Z]");
			String end = sc.next("[A-Z]");
			ArrayList<Edge> edges = new ArrayList<Edge>();
>>>>>>> parent of 48f535b... Revert "update"
			Set<String> vertices = new HashSet<String>();
			String s = sc.next();
			while(!s.contains("*"))
			{
				if(!s.matches("[A-Z]"))
					s = sc.next("[A-Z]");
				String e = sc.next("[A-Z]");
				vertices.add(e);				
<<<<<<< HEAD
				vertices.add(s);			
				edges.add(object.new Edge(s,e));
				edges.add(object.new Edge(e,s));	
=======
				vertices.add(s);
				int w = Integer.parseInt(sc.next("\\d+"));
				edges.add(object.new Edge(s,e,w));
				s = sc.next();
>>>>>>> parent of 48f535b... Revert "update"
			}
			if(vertices.size()<=0)
			{
				System.out.println("NIL");
				
			}else{
				HashMap<String,ArrayList<Edge>> graph = new HashMap<String,ArrayList<Edge>>();
				HashMap<String,Integer> mtable = new HashMap<String,Integer>(vertices.size());
				for(String ss:vertices)
				{
					mtable.put(ss, Integer.MAX_VALUE);
				}
				for(Edge edge:edges)
				{
					String key = edge.startNode;
					ArrayList<Edge> value = graph.get(key);
					if(value==null)
						value = new ArrayList<Edge>();
					value.add(edge);
					graph.put(key,value);
				}
				int ans = findMaxofMin(graph,mtable,start,end);
				if(ans==Integer.MAX_VALUE || ans==Integer.MIN_VALUE)
					System.out.println("NIL");
				else
					System.out.println(ans);
			}
			
<<<<<<< HEAD
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
				ArrayList<Edge> value = graph.get(key);
				if(value==null)
					value = new ArrayList<Edge>();
				value.add(edge);
				graph.put(key,value);
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
=======
>>>>>>> parent of 48f535b... Revert "update"
		}
		 sc.close();
	}
	
	public static int findMaxofMin(HashMap<String,ArrayList<Edge>> graph,HashMap<String,Integer> mtable,String start,String end)
	{
		int max = Integer.MIN_VALUE;
		
<<<<<<< HEAD
		int ans = mtable.get(start);
		if(start==end)
			return ans;
//		if(ans==-1) //lopp case...
//			return Integer.MAX_VALUE;
		if(ans!=0 && ans!=Integer.MAX_VALUE)
			return ans;
=======
		if(start.charAt(0)==end.charAt(0))
			return Integer.MAX_VALUE;
		int ansSub = mtable.get(start);
		if(ansSub!=Integer.MAX_VALUE && ansSub!=-1)
			return ansSub;
		ArrayList<Edge>  edges = graph.get(start);
>>>>>>> parent of 48f535b... Revert "update"
		mtable.put(start,-1);
		if(edges!=null)
		{
<<<<<<< HEAD
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
		mtable.put(start,min);
		return min;
=======
					
			for(Edge edge:edges)
			{
				if(mtable.get(edge.endNode)!=-1)
					max = Math.max(max,Math.min(edge.weight,findMaxofMin(graph,mtable,edge.endNode,end)));
			}
		}	
		mtable.put(start,max);
>>>>>>> parent of 48f535b... Revert "update"
		
		return max;
	}

}
