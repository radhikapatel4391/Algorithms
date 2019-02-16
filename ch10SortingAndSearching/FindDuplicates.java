package ch10SortingAndSearching;

import java.util.BitSet;

public class FindDuplicates {

	
	public static void printDuplicate(short[] arr)
	{
		BitSet bs = new BitSet(32000);
		for(short s:arr)
		{
			if(bs.get(s))
			{
				System.out.println(s);				
			}else {
				bs.set(s);
			}
		}
	}
	public static void main(String[] args) {
		printDuplicate(new short[] {1,2,56,7000,654,32000,32,1,7000,32000});

	}

}
