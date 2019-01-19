package cha1ArraysandStrings;

import java.util.Random;

public class RotateMatrix {

	public static void main(String[] args) {
		int N = 5;
	int[][] m = new int[N][N];
	Random rand = new Random();
	for(int i = 0;i<N;i++)
	{
		for(int j=0;j<N;j++)
		{
			m[i][j] = rand.nextInt(10);
			System.out.print(m[i][j]+" ");
		}
		System.out.println();
	}
	m= rotate(m);
	System.out.println("After 90 degree rotation:");
	for(int i = 0;i<N;i++)
	{
		for(int j=0;j<N;j++)
		{
			
			System.out.print(m[i][j]+" ");
		}
		System.out.println();
	}

	}
	public static int[][] rotate(int[][] matrix)
	{
		int n = matrix.length;
		for(int layer =0;layer<n/2;layer++)
		{
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++)
			{
				//left = [last-i+layer,first]
				//top = [first,i]
				//right = [i,last]
				//bottom = [last,last-i+layer]
				
				//save left
				int left = matrix [last-i+layer][first];
				//left=bottom
				matrix[last-i+layer][first] = matrix[last][last-i+layer];
				//bottom = right
				matrix[last][last-i+layer] = matrix[i][last];
				//right = top
				matrix[i][last] = matrix[first][i];
				//top = left
				matrix[first][i] = left;			
				
			}
		}
		return matrix;
	}
}
