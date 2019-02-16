package cs411;

import java.util.LinkedList;
import java.util.Queue;

public class alive {
	static int  rSize;
	static int cSize;
	static boolean[][] matrix;
	static Queue<int[]> alivecellQueue;
	static int totalElements;
	public static void main(String[] args) {		
		//reading input...
		for(int i=0;i<args.length;i++)
		{			
			int m = Integer.parseInt(args[i++]);
			int n = Integer.parseInt(args[i++]);			
			alivecellQueue =  new LinkedList<int[]> ();
			while(Integer.parseInt(args[i])!= 0 && Integer.parseInt(args[i+1])!= 0)
			{				
				int mm = Integer.parseInt(args[i++]);
				int nn = Integer.parseInt(args[i++]);			
				alivecellQueue.add(new int[] {mm,nn});
				
			}
			rSize = m+2;
			cSize = n+2;
			matrix = new boolean[rSize][cSize];			
			totalElements = (m)*(n);
			makeAlive();
			System.out.println(canBeAlive());
			i++;
		}		

	 }
	private static void makeAlive() {
		for(int[] a:alivecellQueue)
		{
			matrix[a[0]][a[1]]=true;
			totalElements--;
		}
	} 
	private static String canBeAlive() {
		while(!alivecellQueue.isEmpty())
		{
			int[] arr = alivecellQueue.remove();
			int r = arr[0];
			int c = arr[1];				
			if(matrix[r][c+1]==false && c<cSize-2)//right ngbr is dead then make it alive
			{
				int k = canBeAlive(r,c+1);
				if(k==0)
				{
					alivecellQueue.add(new int[] {r,c+1});
					matrix[r][c+1] = true;
					totalElements--;
				}else if(k==3)
				{
					return "impossible";
				}
			}
			if(matrix[r+1][c]==false && r<rSize-2)//bottom ngbr is dead then make it alive
			{
				int k = canBeAlive(r+1,c);
				if(k==0)
				{
					alivecellQueue.add(new int[] {r+1,c});
					matrix[r+1][c] = true;
					totalElements--;
				}else if(k==3)
				{
					return "impossible";
				}
			}
			if(matrix[r][c-1]==false && c>1)//left ngbr is dead then make it alive
			{
				int k = canBeAlive(r,c-1);
				if(k==0)
				{
					alivecellQueue.add(new int[] {r,c-1});
					matrix[r][c-1] = true;
					totalElements--;
				}else if(k==3)
				{
					return "impossible";
				}
			}
			if(matrix[r-1][c]==false && r>1)//top ngbr is dead then make it alive
			{
				int k = canBeAlive(r-1,c);
				if(k==0)
				{
					alivecellQueue.add(new int[] {r-1,c});
					matrix[r-1][c] = true;
					totalElements--;
				}else if(k==3)
				{
					return "impossible";
				}
			}
			if(totalElements==0) //all become alive no need furthore process.
				return "possible";
		}
		if(totalElements>0) //some one left without being alive
			return "impossible";
		return "possible";
		
	}		
	private static int canBeAlive(int r,int c) {			
		
		int count = 0;
		if(matrix[r-1][c])
			count++;
		if(matrix[r+1][c])
			count++; 
		if(matrix[r][c-1])
			count++;					
		if(matrix[r][c+1])
			count++;
		
		if(count==2)
		{
			return 0;//can be alive
		}else if(count<2)
		{
			return 1;//not possible
		}else {
			return 2;// impossible.
		}
	}			
	
	

	
}
