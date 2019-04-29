import java.util.Scanner;

public class e_hops {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int network = 0;
		while (sc.hasNext()) {
			network++;
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = n;

			for (int i = 0; i < n; i++)
				arr[i][i] = 0;
			int x = sc.nextInt();
			while (x != -1) {
				int y = sc.nextInt();
				if(x<n && y<n)
				{
					arr[x][y] = 1;
					arr[y][x] = 1;
				}
				x = sc.nextInt();
			}
			x = sc.nextInt();// read extra -1...

			arr = AllshortestPath(arr);

			// print...
			System.out.println("NETWORK " + network);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] < n)
						System.out.printf("%4d", arr[i][j]);
					else
						System.out.printf("   -");
				}
				System.out.println();
			}
		}
		sc.close();

	}

	public static int[][] AllshortestPath(int[][] arr) {
		int n = arr.length;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
				{	
					arr[i][j] = Math.min(arr[i][j], (arr[i][k] + arr[k][j]));
						
				}
		}
		return arr;
	}

}
