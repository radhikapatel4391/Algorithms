package cha1ArraysandStrings;

import java.util.Random;

public class ZeroMatrix {

	public static void main(String[] args) {
		int N = 5;
		int M = 10;
		
		int[][] m = new int[N][M];
		Random rand = new Random();
		for(int i = 0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				m[i][j] = rand.nextInt(10);
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		m= makezero(m);
		System.out.println("After make zero:");
		for(int i = 0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}


	}
	public static int[][] makezero(int[][] m)
	{
		int row = m.length;
		int col = m[0].length;
		boolean firstrowzero = false;
		boolean firstcolzero = false;
		
		//look first row has zero or not
		for(int i=0;i<col;i++)
		{
			if(m[0][i]==0)
			{
				firstrowzero=true;
				break;
			}
		}
		//find first column has zero??
		for(int i=0;i<row;i++)
		{
			if(m[i][0]==0)
			{
				firstcolzero=true;
				break;
			}
		}
		//find zero elements in matrix and update that in first row and column
		for(int i = 1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				if(m[i][j]==0)
				{
					m[0][j]=0;
					m[i][0]=0;
				}
			}
		}
		//make zero row column
		
		for(int i=1;i<col;i++)
		{
			if(m[0][i]==0)
			{
				m = nulifyCol(m,i);
			}
		}
		for(int i=1;i<row;i++)
		{
			if(m[i][0]==0)
			{
				m = nulifyRow(m,i);
			}
		}
		if(firstrowzero)
		{
			m = nulifyRow(m,0);
		}
		if(firstcolzero)
		{
			m = nulifyCol(m,0);
		}
		
		return m;
	}
	private static int[][] nulifyRow(int[][] m,int k)
	{
		for(int i=0;i<m[0].length;i++)
		{
			m[k][i]=0;
		}
		return m;
	}
	private static int[][] nulifyCol(int[][] m,int k)
	{
		for(int i=0;i<m.length;i++)
		{
			m[i][k]=0;
		}
		return m;
	}
}
