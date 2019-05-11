
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class e_coins {

	public static   void main(String[] args) {
		
		int trial=0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			trial++;
			int n = sc.nextInt();
			//create positive prob and negative prob array..
			double[] arrp = new double[n]; 
			double[] arrn = new double[n]; 
			for(int k=0;k<n;k++)
			{
				arrp[k] = sc.nextDouble();
			}
			for(int k=0;k<n;k++)
			{
				arrn[k] = 1 - arrp[k];
			}
			int count = 0;
			System.out.println("TRIAL "+trial);
			double[][] mtable = new double[n][n+1];
			mtable[0][0] = arrn[0];
			
			 for(int i=1;i<n;i++)			  
				 mtable[i][0] = mtable[i-1][0]*arrn[i];
			
			 mtable[0][1] = arrp[0];
			 for(int i=2;i<n+1;i++)
				 mtable[0][i] = 0;
			 for(int i=1;i<n;i++)
			 {
				 for(int j=1;j<n+1;j++)
				 {
					// System.out.println(mtable[i-1][j-1]+" "+mtable[i-1][j]);
					 mtable[i][j] = (arrp[i]* mtable[i-1][j-1])+ (arrn[i]*mtable[i-1][j]);
				 }
			 }
			 for(int k=0;k<n+1;k++)
			 {
				 String s = String.format("%3d",k);
				//System.out.println((mtable[n-1][k]));
				System.out.printf(s+":  "+"%3.6f",mtable[n-1][k]);
				System.out.println();
			 }
			 mtable = null;
//			for(double x:FindProbability(arrp,arrn))
//			{
//				String s = String.format("%3d",count);
//				System.out.printf(s+":"+"%3.6f",x);
//				System.out.println();
//				count++;
//			}
		}
		
		sc.close();
	}
	
}
