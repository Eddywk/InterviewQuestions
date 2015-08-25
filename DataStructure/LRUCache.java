package DataStructure;

import java.util.HashMap;

class LRUCache {
/*Design and implement a data structure for Least Recently Used (LRU) cache. 
 *It should support the following operations: get and set.
  get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
  set(key, value) - Set or insert the value if the key is not already present. 
  When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/	
	private class Node{
		Node prev;
		Node next;
		int key;
		int value;
		
		public Node(int key, int value){
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
	
	int capacity;
	/*Dummy Nodes*/
	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);
	HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}
	
	public int get(int key) {
		/*If there is no entry in cache, return -1*/
		if(!hs.containsKey(key)){
			return -1;
		}
		/*If we can find it, so it was recently used.*/
		Node cur = hs.get(key);
		/*Pick out the node and move it to before tail*/
		cur.next.prev = cur.prev;
		cur.prev.next = cur.next;
		move_to_tail(cur);
		/*Return value*/
		return hs.get(key).value;
	}
	
	public void set(int key, int value) {
		/*If we can find the entry in cache, 
		 *we move it to tail and give it new value*/
		if(get(key) != -1){
			hs.get(key).value = value;
			return;
		}
		/*If cache is full*/
		if(hs.size() == capacity){
			/*Remove least recently used entry*/
			hs.remove(head.next.key);
			head.next.prev = null;
			head.next = head.next.next;
			head.next.prev = head;
		}
		/*Insert new node and move it to tail*/
		Node newNode = new Node(key, value);
		hs.put(key, newNode);
		move_to_tail(newNode);
	}
	
	private void move_to_tail(Node node){
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;	
	}
}
