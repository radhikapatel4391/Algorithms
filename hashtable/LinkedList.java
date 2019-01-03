package hashtable;

public class LinkedList<K, V> {

	private Node<K, V> head = null;

	public LinkedList() {
		head = null;
	}

	public LinkedList(K key, V value) {
		head = new Node<K, V>(key, value);
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void insert(K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value);
		if (head == null) 
		{
			head = newNode;

		} else
		{
			Node<K, V> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			newNode.setPre(temp);
		}

	}

	public void set(K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value);
		if (head == null) {
			head = newNode;

		} else if (head.getKey() == key) {
			head.setValue(value);
			return;
		} else {
			Node<K, V> temp = head;
			while (temp.getNext() != null) {
				if (temp.getKey() == key) {
					temp.setValue(value);
					return;
				}
				temp = temp.getNext();

			}
			temp.setNext(newNode);
			newNode.setPre(temp);
		}

	}	

	public V removeByKey(K key) {
		Node<K, V> temp = head;
		while (temp != null && temp.getKey() != key) {
			temp = temp.getNext();
		}
		if (temp == null)
			return null;
		V v = temp.getValue();
		if(temp.getPre() != null && temp.getNext() != null)
		{
			temp.getPre().setNext(temp.getNext());
			temp.getNext().setPre(temp.getPre());
		}else if(temp.getPre() != null)
		{
			temp.getPre().setNext(temp.getNext());
		}else if(temp.getNext() != null)
		{
			temp.getNext().setPre(temp.getPre());
			head = temp.getNext();
		}else
		{
			head = null; //both null means only element 
		}
		temp = null;
	//System.out.println(this);
		return v;
		/*if (temp.getPre() == null && temp.getNext() == null) // only head element that remove...
		{
			head = null;

		} else if (temp.getPre() == null) {// head elemnt remove..

			head = temp.getNext();
			head.setPre(null);

		} else if (temp.getNext() == null) { // tail element remove
			temp.getPre().setNext(null);
		} else {// middle element remove.
			temp.getPre().setNext(temp.getNext());
			temp.getNext().setPre(temp.getPre());
		}*/
		//System.out.println(this);
		

	}

	public Node<K, V> getNodeByValue(V value) {
		if (head == null)
			return null;
		Node<K, V> temp = head;
		while (temp!= null && temp.getValue() != value) {
			temp = temp.getNext();
		}
		return temp;
	}

	public Node<K, V> getNode(K key) {
		if (head == null)
			return null;
		Node<K, V> temp = head;
		while (temp!= null && temp.getKey() != key) {
			temp = temp.getNext();
		}
		return temp;
	}

	@Override
	public String toString() {
		if (head == null)
			return "";
		Node<K, V> temp = head;
		StringBuilder bs = new StringBuilder("" + temp.getKey() + "," + temp.getValue() + " | ");
		while (temp.getNext() != null) {
			temp = temp.getNext();
			bs.append("" + temp.getKey() + "," + temp.getValue() + " | ");

		}
		return bs.toString();
	}

}
