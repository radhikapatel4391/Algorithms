package ch4treeAndGraphs.buildOrder;

import java.util.LinkedList;

public class Project {

	public String name;
	public int dependences=0;
	public LinkedList<Project> children=null;
	public Project parent;
	public state s = state.BLANK;
	public Project(String s)
	{
		name = s;
	}
	
	}
