package animalShelter;

import java.util.LinkedList;
import java.util.Queue;

public class Animalshelter {

	Queue<Animal> dog = new LinkedList<Animal>();
	Queue<Animal> cat = new LinkedList<Animal>();
	private int age = 0;
	
	public void enqueue(Animal a) {
		a.setStamp(age++);
		if(a.getType() == AnimalType.Dog)
		{
			dog.add(a);
		}else {
			cat.add(a);
		}
		
	}
	public Animal deQueueAny() {
		if(dog.peek().isOlder(cat.peek()))
		{
			return dog.remove();
		}else {
			return cat.remove();
		}
	}
	public Animal deQueueDog() {
		return dog.remove();
	}
	public Animal deQueueCat() {
		return cat.remove();
	}
	public void print() {
		System.out.print("Cat : ");
		cat.forEach((n)->System.out.print(n.getName() + " "+n.getStamp()+", "));
		System.out.println();
		System.out.print("Dog : ");
		dog.forEach((n)->System.out.print(n.getName() + " "+n.getStamp()+", "));
		System.out.println();
	}
	public static void main(String[] args) {
		Animalshelter ob1 = new Animalshelter();
		ob1.enqueue(new Animal("cat1",AnimalType.Cat));
		ob1.enqueue(new Animal("cat2",AnimalType.Cat));
		ob1.enqueue(new Animal("dog1",AnimalType.Dog));
		ob1.enqueue(new Animal("cat3",AnimalType.Cat));
		ob1.enqueue(new Animal("cat4",AnimalType.Cat));
		ob1.enqueue(new Animal("dog2",AnimalType.Dog));
		ob1.enqueue(new Animal("cat5",AnimalType.Cat));
		ob1.enqueue(new Animal("cat6",AnimalType.Cat));
		ob1.enqueue(new Animal("dog3",AnimalType.Dog));
		ob1.enqueue(new Animal("dog4",AnimalType.Dog));
		ob1.enqueue(new Animal("dog5",AnimalType.Dog));
		ob1.print();
		System.out.println("dequeany : "+ob1.deQueueAny().getName());
		System.out.println("dequedog : "+ob1.deQueueDog().getName());
		System.out.println("dequeuecat : "+ob1.deQueueCat().getName());
		System.out.println("dequeany : "+ob1.deQueueAny().getName());
		ob1.print();
		Animalshelter ob2 = new Animalshelter();
		ob2.enqueue(new Animal("cat1ob2",AnimalType.Cat));
		ob2.enqueue(new Animal("cat2ob2",AnimalType.Cat));
		ob2.enqueue(new Animal("dog1ob2",AnimalType.Dog));
		ob2.print();
		ob1.print();
	}
	

}
