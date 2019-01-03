package hashtable;

import java.util.ArrayList;

public class HashTable<K,V>{
	private ArrayList<LinkedList<K,V>> table;
	private int size = 100;
	public HashTable()
	{
		table = new ArrayList<LinkedList<K,V>>(size);
		table.ensureCapacity(size);
		for (int i = 0; i < size; i++) {
			table.add(null);
		}
	}
	public int getSize() {
		
		return size;
	}
	public HashTable(int size)
	{
		table = new ArrayList<LinkedList<K,V>>(size);
		this.size = size;
		table.ensureCapacity(size);
		for (int i = 0; i < size; i++) {
			table.add(null);
		}
	}
	
	private int getPosition(K key)
	{
		long keycode = Math.abs(key.hashCode());
		return (int) (keycode % size);		
	}
	public void insert(K key, V value)	
	{	
		this.set(key,value);
		/*int index = getPosition(key);
		LinkedList<K,V> positionValue = table.get(index);
		if(positionValue != null)
		{
			positionValue.insert(key,value);
		}
		else
		{
			 positionValue = new LinkedList<K,V>(key,value);			
			 table.set(index, positionValue);
		}
		*/
	}
	public void set(K key, V value)
	{
		int index = getPosition(key);
		LinkedList<K,V> positionValue = table.get(index);
		if(positionValue != null)
		{
			positionValue.set(key,value);
		}
		else
		{
			 positionValue = new LinkedList<K,V>(key,value);			
			 table.set(index, positionValue);
		}
	}
	public V remove(K key)	
	{	int index = getPosition(key);
		LinkedList<K,V> positionValue = table.get(index);
		if(positionValue != null)
		{		
			 V value =  positionValue.removeByKey(key);
			 return value;
			
		}	
		return null;
	}
	public V get(K key)
	{		
		LinkedList<K,V> positionValue = table.get(getPosition(key));
		if(positionValue != null && !positionValue.isEmpty())
		{
			 Node<K,V> n = positionValue.getNode(key);
			 if(n!= null)
			 {
				 return n.getValue();
			 }
			 
			 return null;
		}
		return null;
	}
	public void replace(K key, V newValue)
	{
		
		LinkedList<K,V> positionValue = table.get(getPosition(key));
		if(positionValue != null && !positionValue.isEmpty())
		{
			Node<K,V> n = positionValue.getNode(key);
			 if(n!= null)
			 {
				  n.setValue(newValue);
			 }
		}
		
	}
	@Override
	public String toString()	
	{
		System.out.println("table size: "+table.size());
		StringBuilder bs = new StringBuilder(" ");
		int i=0;
		for(LinkedList<K,V> ele : table)
		{	
			if(ele==null)
			{
				bs.append("element "+i+"\t "+null + "\n" );
			}else {
				bs.append("element "+i+"\t "+ele.toString()+"\n");
				
			}
			i++;
			
		}
		return bs.toString();
		
	}
	
}
