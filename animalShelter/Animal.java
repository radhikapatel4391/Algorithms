package animalShelter;

public class Animal {
	private String name;
	private int stamp; //smaller stamp value could be older animal....
	private AnimalType type;
	
	public Animal(String name,AnimalType type) {
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public AnimalType getType() {
		return type;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	
	public boolean isOlder(Animal other)
	{
		return this.stamp< other.stamp;
	}
}
