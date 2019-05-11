

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class e_alive {
	static int rSize;
	static int cSize;
	static boolean[][] matrix;
	static Queue<int[]> alivecellQueue;
	static int totalElements;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter values \n");
		

		while (sc.hasNextInt()) {
			//System.out.println("has somethis....");
			int m = sc.nextInt();
			int n = sc.nextInt();
			int mm = sc.nextInt();
			int nn = sc.nextInt();
			//System.out.println(m+" "+n);
			alivecellQueue = new LinkedList<int[]>();
			while ((mm > 0) && (nn > 0)) {				
				alivecellQueue.add(new int[] { mm, nn });
				mm = sc.nextInt();
				nn = sc.nextInt();
				//System.out.println(mm+" "+nn);
				
			}
			//System.out.println("out of while");
			rSize = m + 2;
			cSize = n + 2;
			matrix = new boolean[rSize][cSize];
			totalElements = (m) * (n);
			makeAlive();
			System.out.println(canBeAlive());
		}
		
		sc.close();
		 

	}

	private static void makeAlive() {
		for (int[] a : alivecellQueue) {
			matrix[a[0]][a[1]] = true;
			totalElements--;
		}
	}

	private static String canBeAlive() {
		while (!alivecellQueue.isEmpty()) {
			int[] arr = alivecellQueue.remove();
			int r = arr[0];
			int c = arr[1];
			if (matrix[r][c + 1] == false && c < cSize - 2)// right ngbr is dead then make it alive
			{
				int k = canBeAlive(r, c + 1);
				if (k == 0) {
					alivecellQueue.add(new int[] { r, c + 1 });
					matrix[r][c + 1] = true;
					totalElements--;
				} else if (k == 3) {
					return "impossible";
				}
			}
			if (matrix[r + 1][c] == false && r < rSize - 2)// bottom ngbr is dead then make it alive
			{
				int k = canBeAlive(r + 1, c);
				if (k == 0) {
					alivecellQueue.add(new int[] { r + 1, c });
					matrix[r + 1][c] = true;
					totalElements--;
				} else if (k == 3) {
					return "impossible";
				}
			}
			if (matrix[r][c - 1] == false && c > 1)// left ngbr is dead then make it alive
			{
				int k = canBeAlive(r, c - 1);
				if (k == 0) {
					alivecellQueue.add(new int[] { r, c - 1 });
					matrix[r][c - 1] = true;
					totalElements--;
				} else if (k == 3) {
					return "impossible";
				}
			}
			if (matrix[r - 1][c] == false && r > 1)// top ngbr is dead then make it alive
			{
				int k = canBeAlive(r - 1, c);
				if (k == 0) {
					alivecellQueue.add(new int[] { r - 1, c });
					matrix[r - 1][c] = true;
					totalElements--;
				} else if (k == 3) {
					return "impossible";
				}
			}
			if (totalElements == 0) // all become alive no need furthore process.
				return "possible";
		}
		if (totalElements > 0) // some one left without being alive
			return "impossible";
		return "possible";

	}

	private static int canBeAlive(int r, int c) {

		int count = 0;
		if (matrix[r - 1][c])
			count++;
		if (matrix[r + 1][c])
			count++;
		if (matrix[r][c - 1])
			count++;
		if (matrix[r][c + 1])
			count++;

		if (count == 2) {
			return 0;// can be alive
		} else if (count < 2) {
			return 1;// not possible
		} else {
			return 2;// impossible.
		}
	}

}
