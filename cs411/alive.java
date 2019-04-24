package cs411;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class alive {
	static int rSize;
	static int cSize;
	static boolean[][] matrix;
	static Queue<int[]> alivecellQueue;
	static int totalElements;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		// 1. List, Set, Map copyOf(Collection) method
		
				List<String> actors = new ArrayList<>();

				actors.add("Jack Nicholson");
				actors.add("Marlon Brando");

				System.out.println(actors);
				// prints [Jack Nicholson, Marlon Brando]

				// New API added - Creates an UnModifiable List from a List.
				List<String> copyOfActors = List.copyOf(actors);

				System.out.println(copyOfActors);
				// prints [Jack Nicholson, Marlon Brando]

				// copyOfActors.add("Robert De Niro"); Will generate
				// UnsupportedOperationException

				actors.add("Robert De Niro");

				System.out.println(actors);
				// prints [Jack Nicholson, Marlon Brando, Robert De Niro]

				System.out.println(copyOfActors);
				// prints [Jack Nicholson, Marlon Brando]

				// 2. Collectors class toUnmodifiableList, toUnmodifiableSet, and
				// toUnmodifiableMap methods
				List<String> collect = actors.stream().collect(Collectors.toUnmodifiableList());
				System.out.println(collect);

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
			System.out.print(canBeAlive());
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
