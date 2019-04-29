import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class e_coins {

	public static void main(String[] args) {
		int trial=0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			trial++;
			int n = sc.nextInt();
			//create positive prob and negative prob array..
			BigDecimal[] arrp = new BigDecimal[n]; 
			BigDecimal[] arrn = new BigDecimal[n]; 
			for(int k=0;k<n;k++)
			{
				arrp[k] = new BigDecimal(sc.nextFloat());
			}
			for(int k=0;k<n;k++)
			{
				arrn[k] = new BigDecimal(1).subtract(arrp[k]);
			}
			int count = 0;
			System.out.println("TRIAL "+trial);
			for(BigDecimal x:FindProbability(arrp,arrn))
			{
				String s = String.format("%3d",count);
				System.out.printf(s+":"+"%3.6f",x);
				System.out.println();
				count++;
			}
		}
		
		sc.close();
	}
	@SuppressWarnings("unchecked")
	public static BigDecimal[] FindProbability(BigDecimal[] arrp,BigDecimal[] arrn)
	{
		int len = arrp.length;
		BigDecimal[] result = new BigDecimal[len+1];
		
		//basic string creation....
		char[] str = new char[len];
		for(int i=0;i<len;i++)
		{
			str[i]='0';
		}
		String s = new String(str);		
		
		//first value calculation for h=0...
		BigDecimal ans = new BigDecimal(1);		
		for(BigDecimal i: arrn)
			ans = ans.multiply(i);
		HashMap<String,BigDecimal> map = new HashMap<String,BigDecimal>();	
		map.put(s, ans);	
		result[0] = ans;
		
		//get next h = h+1 using value of old h.
		HashMap<String,BigDecimal> newMap = new HashMap<String,BigDecimal>();		
		for(int k=1;k<=(len/2);k++) //for each h value-update result
		{
			for(String sp:map.keySet()) //use previous map for new strings....
			{
				BigDecimal v = map.get(sp);
				for(int i=0;i<len;i++)  //try to modify at each possible index...
				{
					if(sp.charAt(i)=='0') //if string already exist then we should not include it...seth1(01,10) for will give 11 for h=2.
					{									
						String current = sp.substring(0,i)+'1'+sp.substring(i+1);
						if(newMap.get(current)==null)
						{
							BigDecimal currentVlaue = v.multiply(arrp[i]).divide(arrn[i]);
							newMap.put(current, currentVlaue);
						}					
					}
				}
			}
			BigDecimal sum = new BigDecimal(0); //make sum for final prob for h=k
			for(BigDecimal x:newMap.values())
				sum = sum.add(x);
			result[k]= sum;
			
			map.clear();
			map = (HashMap<String, BigDecimal>) newMap.clone(); //update map with newMap...
			newMap.clear();

		}
		int dummy = 0;
		for(int k=len;k>(len/2);k--)
			result[k] = result[dummy++];
		return result;
	}
}
