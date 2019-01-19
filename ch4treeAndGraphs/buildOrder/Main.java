package ch4treeAndGraphs.buildOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import ch3stacksAndQueues.Mystack;


public class Main {

	
	public static HashMap<String,Project> createProject(String arr[])
	{
		 HashMap<String,Project> projects = new HashMap<String,Project>(arr.length);
		for(int i=0;i<arr.length;i++)
		{
			projects.put(arr[i], new Project(arr[i])) ;			
		}
		return projects;
	}
	public static HashMap<String,Project> addDependences(HashMap<String,Project> projects,String[][] dep)
	{
		//assume dependency are store in n*2
		for(int i=0;i<dep.length;i++)
		{
			Project p = projects.get(dep[i][0]);
			Project c = projects.get(dep[i][1]);
			if(p.children==null)			
				p.children = new LinkedList<Project>();
			p.children.add(c);
			c.dependences++;
			c.parent = p;					
		}
		return projects;
	}
	public static Mystack<Project> getOrderedUsingDFS(HashMap<String,Project> projects)
	{
		Mystack<Project> stack = new Mystack<Project>();
		//1. make all node state blank first.....
		Iterator it = projects.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<String,Project> pair= (Map.Entry<String,Project>)it.next();
			pair.getValue().s = state.BLANK;
		}
		//2 if node is blank then process it..
		 it = projects.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<String,Project> pair= (Map.Entry<String,Project>)it.next();
			if(pair.getValue().s == state.BLANK)
			{
				
				if(!doDFS(pair.getValue(),stack))
				{
					return null;
				}
			}
		}
		
		return stack;
	}
	public static boolean doDFS(Project p,Mystack<Project> stack)
	{
		if(p.s == state.PARIAL)
			return false;
		if(p.s==state.BLANK)
		{
			p.s = state.PARIAL;
			if(p.children!=null)
			{
				for(Project child : p.children)
				{
					if(!doDFS(child,stack))
						return false;
				}
			}
			
			p.s = state.COMPLETE;
			stack.push(p);			
		}
		
		return true;
	}
	public static Project[] getOrdered(HashMap<String,Project> projects)
	{
		Project[] ordered = new Project[projects.size()];
		int i = 0;
		Iterator it = projects.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<String,Project> pair= (Map.Entry<String,Project>)it.next();
			//System.out.println(pair.getKey() + +pair.getValue().dependences);
			if(pair.getValue().dependences == 0)
				ordered[i++] = pair.getValue();
		}
		int current = 0;
		
		while(current<ordered.length)
		{
			if(ordered[current]==null)//cycle....or something wrong...
				return null;
			
			if(ordered[current].children!=null)
			{
				for(Project child:ordered[current].children)
				{
					
						child.dependences--;
						if(child.dependences==0)
							ordered[i++] = child;					
					
					
				}
			}
			
			current++;
		}
		return ordered;
		
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		String[] s = new String[] {"a","b","c","d","e","f","g"};
		String[][] d = new String[][] {{"f","c"},{"f","a"},{"f","b"},{"c","a"},{"b","a"},{"a","e"},{"b","e"},{"d","g"}};
		//...............................................................................................................
		Project[] p = getOrdered(addDependences(createProject(s),d));
		for(Project pro:p)
		{
			System.out.println(pro.name);
		}
	    //...............................................................................................
		System.out.println("Testing of getOrderedUsingDFS");
		ArrayList<Project> stack = getOrderedUsingDFS(addDependences(createProject(s),d)).createArray();
		for(Project pro:stack)
		{
			System.out.println(pro.name);
		}
		
		
	}

}
