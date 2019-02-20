package abstacttest;

import javaPractice.Person;


/* subclass Student extending the Person class */
class Student extends Person 
{ 
	//private String name;
    Student() 
    { 
        // invoke or call parent class constructor 
        super(); 
  
        System.out.println("Student class Constructor "+name); 
    } 
    //private void testmethod() {}
} 
class Visitor extends Student 
{ 
	Visitor() 
    { 
        // invoke or call parent class constructor 
        super();   
        System.out.println("Visitor class Constructor "+name); 
        testmethod();
    } 
} 
  
/* Driver program to test*/
class test 
{ 
    public static void main(String[] args) 
    { 
        Student s = new Student(); 
        Visitor v = new Visitor();
    } 
} 
