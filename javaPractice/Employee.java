package javaPractice;
class Employee implements Comparable<Employee>{
	private String id;
	private String name;
	private int salary;
	private String post;

	public Employee(String id, String name) {
		this.id = id;
		this.name = name;

	}
	public String getName() {
		return this.name;
	}
	public String getid() {
		return this.id;
	}
	@Override
	public int compareTo(Employee e)
	{
		return this.id.compareTo(e.id);
	}
}