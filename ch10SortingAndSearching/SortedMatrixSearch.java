package ch10SortingAndSearching;

public class SortedMatrixSearch {

	public static Coordinate findElement(int[][] matrix,int x)
	{
		Coordinate origin = new Coordinate(0,0);
		Coordinate dest = new Coordinate(matrix.length-1,matrix[0].length-1);
		return findElement(matrix,x,origin,dest);
	}
	public static Coordinate findElement(int[][] matrix,int x,Coordinate origin,Coordinate dest)
	{
		if(!origin.inBoundes(matrix) || !dest.inBoundes(matrix) || !origin.isBefore(dest))
			return null;
		if(matrix[origin.row][origin.column]==x)
			return origin;
		
		//diagonal binary search start and end coordinate becuse matrix might not be square..
		Coordinate start = (Coordinate)origin.clone();
		int diagDest = Math.min(dest.row-origin.row,dest.column-origin.column);
		Coordinate end = new Coordinate(start.row+diagDest,start.column+diagDest);
		Coordinate p = new Coordinate (0,0);
		
		//find pivot element such that above diagonal is smaller then x and pivot is larger or equal to x
		
		while(start.isBefore(end))
		{
			p.setToAverage(start, end);
			if(x>matrix[p.row][p.column])
			{
				start.row = p.row+1;
				start.column = p.column +1;
			}else if(x<matrix[p.row][p.column])
			{
				end.row = p.row-1;
				end.column = p.column-1;
			}else {
				return p;
			}
		}
		
		return partitionAndSearch(matrix,x,start,origin,dest);
		
			
	}
	private static Coordinate partitionAndSearch(int[][] matrix,int x,Coordinate pivot,Coordinate origin,Coordinate dest)
	{
		Coordinate lowerOrigin = new Coordinate(pivot.row,origin.column);
		Coordinate lowerDest = new Coordinate(dest.row,pivot.column-1);
		
		Coordinate upperOrigin = new Coordinate(origin.row,pivot.column);
		Coordinate upperDest = new Coordinate(pivot.row-1,dest.column);
		
		Coordinate f = findElement(matrix,x,lowerOrigin,lowerDest);
		if(f==null)
			return findElement(matrix,x,upperOrigin,upperDest);
		return f;
		
	}
	public static void main(String[] args) {
		int[][] arr = new int[][] {{15,20,40,85},{22,35,80,94},{30,55,95,105}};
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				Coordinate p = findElement(arr,arr[i][j]);
				System.out.print(p.row+","+p.column +"   ");
			}
			System.out.println();
		}
			

	}

}

