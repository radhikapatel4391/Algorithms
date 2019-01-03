package learning;

public class ArrayUsage {

	public static void main(String args[])
	{
		int[] intArray = new int[10];
		char[] charArray = new char[10];
		float[] floatArray = new float[10];
		String[] sArray = new String[10];
		Integer[] IArray = new Integer[10];
		for(int i = 0; i<10;i++)
		{
			System.out.println(intArray[i]);
			System.out.println(charArray[i]);
			//System.out.println(floatArray[i]);
			//System.out.println(sArray[i]);
			System.out.println(IArray[i]);
		}
	}
}
