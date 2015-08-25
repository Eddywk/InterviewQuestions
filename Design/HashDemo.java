package Design;

import java.util.LinkedList;

class Cell<K, V>{
	private K key;
	private V value;
	
	public Cell(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public boolean isSame(K key){
		return this.key.equals(key);
	}
	
	public boolean equals(Cell<K, V> c){
		return isSame(c.getKey());
	}
	
	public K getKey(){ return this.key; }
	
	public V getValue(){ return this.value; }
}


class HashDemo<K, V> {
	private final int MAX_SIZE = 100;
	LinkedList<Cell<K, V>>[] items;
	
	public HashDemo(){
		items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
	}
	
	/*Hash Function*/
	public int hashCodeofKey(K key){
		return key.toString().length() % items.length;
	}
	
	public void put(K key, V value){
		int index = hashCodeofKey(key);
		/*New a linked list if it does not exist*/
		if(items[index] == null){
			items[index] = new LinkedList<Cell<K, V>>();
		}
		Cell<K, V> cell = new Cell<K, V>(key, value);
		LinkedList<Cell<K, V>> list = items[index];
		/*Traverse the linked list to see if there is an item has same key
		 *if found replace it*/
		for(Cell<K, V> c : list){
			if(c.equals(cell)){
				list.remove(c);
				break;
			}
		}
		/*Add new cell to list*/
		list.add(cell);
	}
	
	public V get(K key){
		int x = hashCodeofKey(key);
		if(items[x] == null){
			return null;
		}
		LinkedList<Cell<K, V>> list = items[x];
		/*Traverse the linked list to find the cell we want*/
		for(Cell<K, V> c : list){
			if(c.isSame(key)){
				return c.getValue();
			}
		}
		return null;
	}
}
