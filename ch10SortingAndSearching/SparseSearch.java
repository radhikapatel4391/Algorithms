package ch10SortingAndSearching;

public class SparseSearch {

	public static int search(String[] arr,String m)
	{
		if(m.length()==0)
			return binarySearch(arr,m);
		return specialSearch(arr,m);
	}
	public static int binarySearch(String[] arr,String m)
	{
		int start = 0;
		int end = arr.length-1;
		while(start<=end)
		{
			int mid = (start+end)/2;
			if(arr[mid]==m)
			{
				return mid;
			}else if(arr[mid].compareTo(m)<0) // search in right
			{
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return -1;
	}
	public static int specialSearch(String[] arr,String m)
	{
		int start = 0;
		int end = arr.length-1;		
		
		while(start<=end) //array is not empty....
		{	
			int mid = (start+end)/2;
			int eleft = mid;
			int sright = mid;
			if(arr[mid].isEmpty())
			{
				while(true)
				{
					if(eleft<start && sright>end) //reach to both end ...
					{
						return -1;
					}else if(eleft>=start && !arr[eleft].isEmpty())
					{
						mid = eleft;
						break;
					}else if(sright<=end && !arr[sright].isEmpty())
					{
						mid = sright;
						break;
					}
					sright++;
					eleft--;
				}
				
			}
			
			if(arr[mid]==m)
			{
				return mid;
			}else if( arr[mid].compareTo(m)<0) // search in right
			{
				start = sright; //already traverse few empty string.....
			}else {
				end = eleft; //already traverse few empty string...
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String[] arr = new String[] {"at","","","","","ball","","","","car","","","dad","",""};
		for(String a: arr)
		{
			System.out.print(search(arr,a)+" ");
		}
		System.out.print(search(arr,"eat")+" ");
	}

}
