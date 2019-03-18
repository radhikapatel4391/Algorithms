package javaPractice;
import java.util.*;  

public class stackCollection extends ArrayList<String>{

	public static void main(String args[])  {
		ArrayList<String> aarList = new ArrayList<String>(100);
		System.out.println("ArrayList size "+aarList.size());
		aarList.add("Radhika");
		System.out.println("First element: "+aarList.get(0));
		List<String> t = new ArrayList();
		t.add("a");
		t.add("z");
		t.add("aa");
		for(String ss: t)
		{
			if(ss=="aa" || ss == "z")
				t.remove(ss);
			System.out.println(t.size());
		}
		aarList.addAll(0,t);
		aarList.replaceAll(e -> (e.toLowerCase()));
		t = aarList.subList(1, 3);
		Iterator itr=t.iterator();
		String s = (String) itr.next();
		ArrayList al = new ArrayList();
		al.add("123");
		al.add(1);
		al.add(1.2F);
		al.add("Radhika");
		System.out.println("al non generic " + al.get(0));
		System.out.println(al.indexOf(1));
		System.out.println("sublist " + t);
		//aarList.removeRange(1,3);
		for(String ss: aarList)
		{
			if(ss=="aa" || ss == "z")
				aarList.remove(ss);
		}
		
		
		
		
		Stack<String> stack = new Stack<String>();
		stack.push("Ayush");
		stack.push("Garvit");
		stack.push("Amit");
		stack.push("Ashish");
		stack.push("Garima");
		stack.pop();
		//stack.get(0);
		
		LinkedHashSet<String> set=new LinkedHashSet();  
		//set.
		
		Vector<String> v = new Vector();
		v.add("Radhika");
		v.add("patel");
		v.add("ooooo");
		v.sort(Comparator.comparing(String::toString));
		for(String srr:v)
		{
			System.out.println(srr);
		}
		
		Iterator<String> itrr = stack.iterator();
		while (itrr.hasNext()) {
			System.out.println(itrr.next());
		}
	}

}
