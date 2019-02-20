package javaPractice;


public class A implements Cloneable  // add 'implements'
{
  public Object clone() throws CloneNotSupportedException
  {
    A cloneA = (A) super.clone(); // this copies all fields and returns something of *the same type* as 'this'...
    return cloneA;
  }
}


