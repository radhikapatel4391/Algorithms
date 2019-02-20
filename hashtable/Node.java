package hashtable;

 public class Node<K,V> {
	 public  static int temp=90;
	 
	static{
		System.out.println("Node");
	}
	private Node<K,V> pre=null;
	private Node<K,V> next=null;	
	private V value;
	private K key;
	
	public Node(K key,V value)
	{
		this.key = key;
		this.value = value;
		
		
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public Node<K,V> getPre() {
		return pre;
	}
	public void setPre(Node<K,V> pre) {
		this.pre = pre;
	}
	public Node<K,V> getNext() {
		return next;
	}
	public void setNext(Node<K,V> next) {
		this.next = next;
	}
}
