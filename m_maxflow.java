import java.util.*;
<<<<<<< HEAD


=======
>>>>>>> parent of 97c8f38... update
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
			String start = sc.next("[A-Z]");
			String end = sc.next("[A-Z]");
			ArrayList<Edge> edges = new ArrayList<Edge>();
			Set<String> vertices = new HashSet<String>();
			String s = sc.next();
			while(!s.contains("*"))
			{
				if(!s.matches("[A-Z]"))
					s = sc.next("[A-Z]");
				String e = sc.next("[A-Z]");
				vertices.add(e);				
				vertices.add(s);
				int w = Integer.parseInt(sc.next("\\d+"));
				edges.add(object.new Edge(s,e,w));
				s = sc.next();
			}
<<<<<<< HEAD
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
			
=======

			HashMap<String,HashMap<String,Integer>> minPath = new HashMap<String,HashMap<String,Integer>>();
			for(Edge edge:edges)
			{
				String key = edge.startNode;
				minPath.computeIfAbsent(key, k -> new HashMap<String,Integer>()).put(edge.endNode,edge.weight);
				
			}
			int ans = findMaxofMin(minPath,start,end);
			if(ans==Integer.MAX_VALUE || ans==Integer.MIN_VALUE)
				System.out.println("NIL");
			else
				System.out.println(ans);
>>>>>>> parent of 97c8f38... update
		}
		 sc.close();
	}
	
<<<<<<< HEAD
	public static int findMaxofMin(HashMap<String,ArrayList<Edge>> graph,HashMap<String,Integer> mtable,String start,String end)
	{
		int max = Integer.MIN_VALUE;
		
		if(start.charAt(0)==end.charAt(0))
			return Integer.MAX_VALUE;
		int ansSub = mtable.get(start);
		if(ansSub!=Integer.MAX_VALUE && ansSub!=-1)
			return ansSub;
		ArrayList<Edge>  edges = graph.get(start);
		mtable.put(start,-1);
		if(edges!=null)
		{
					
			for(Edge edge:edges)
			{
				if(mtable.get(edge.endNode)!=-1)
					max = Math.max(max,Math.min(edge.weight,findMaxofMin(graph,mtable,edge.endNode,end)));
			}
		}	
		mtable.put(start,max);
		
=======
	public static int findMaxofMin(HashMap<String,HashMap<String,Integer>> minPath,String start,String end)
	{
		int max = Integer.MIN_VALUE;
		
		if(start==end)
			return Integer.MAX_VALUE;
		HashMap<String,Integer> currentMap = minPath.get(start);
		if(currentMap!=null)
		{
			Integer val = currentMap.get(end);
			if( val!= null)
				return val;			
			for(String s:currentMap.keySet())
			{
				max = Math.max(max,Math.min(currentMap.get(s),findMaxofMin(minPath,s,end)));
			}
		}
		minPath.computeIfAbsent(start,k -> new HashMap<String,Integer>()).put(end,max);
>>>>>>> parent of 97c8f38... update
		return max;
	}

}
