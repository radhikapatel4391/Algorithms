package javaPractice;

public class ExceptionOrder {
	
	     public static void main(String []args) throws Exception{
	        System.out.println("Hello World");
	        int[] ar = new int[] {1,2,3};
	        try{
	        	System.out.println(ar[-1]);
	           //throw new Exception("try");
	            
	        }catch(Exception e)
	        {
	        	System.out.println(e);
	        	//throw new Exception("catch");
	        }finally {
	        	//throw new Exception("finally");
	        }
	       
	     }
	}


