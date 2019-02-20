package javaPractice;

public class B extends A //supposed to extend 'A' right?
{
  public Object clone() throws CloneNotSupportedException
  {
    Object cloneA = super.clone(); // this returns object of runtime type B
    B cloneB = (B)cloneA; // will work
    return cloneB;
  }
}