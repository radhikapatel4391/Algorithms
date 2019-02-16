package ch10SortingAndSearching;

public class SortedSearchNosize {
	 
	 public static int binarySearch(Listy l,int m,int start,int end)
		{
			
			while(start<end)
			{
				int mid = (start+end)/2;
				if(l.elementAt(mid)==m)
				{
					return mid;
				}else if(l.elementAt(mid) == -1 || l.elementAt(mid)>m )
				{
					end = mid;  //need search in left if mid is empty....
				}else {
					start = mid+1;
				}
			}
			return -1;
		}
	
	public static int search(Listy l,int m)
	{
		if(l.elementAt(0)==m)
			return 0;
		int i=1;
		while(l.elementAt(i)!= -1 && l.elementAt(i)<m)
		{
			i = i*2;
		}
		return binarySearch(l,m,i/2,i+1); //end is not inclusive...
	}

	public static void main(String[] args) {
		int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		Listy l = new Listy(arr);
		
		
		int i=0;
		while(l.elementAt(i)!=-1)
		{
			System.out.print(search(l,l.elementAt(i))+" ");
			i++;
		}
		System.out.print(search(l,50)+" ");
		

	}

}
class Listy{
	 private int[] arr = new int[10000];
	 private int size = -1;
	 Listy(int[] a)
	 {
		 for(int i:a)
		 {
			 push(i);
		 }
	 }
	public int elementAt(int i)
	{
		if(i>size)
		{
			return -1;
		}
		return arr[i];			
	}
	public void push(int i)
	{
		arr[++size] = i;
	}
	
	
}
