package Design;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

class ConsistentHash<T> {
	private final int numberOfReplicas;
	private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();
	
	/*@param numberOfReplicas is number of virtual nodes
	 *@param nodes are machines you have*/
	public ConsistentHash(int numberOfReplicas, Collection<T> nodes){
		this.numberOfReplicas = numberOfReplicas;
		for(T node : nodes){
			this.add(node);
		}
	}
	
	/*Add machine nodes to our HashMap*/
	public void add(T node){
		/*Adding virtual nodes*/
		for(int i = 0; i < numberOfReplicas; i++){
			circle.put(hashCode(node.toString() + i), node);
		}
	}
	
	/*Remove machine nodes from our HashMap*/
	public void remove(T node){
		/*Removing virtual nodes*/
		for(int i = 0; i < numberOfReplicas; i++){
			circle.remove(hashCode(node.toString() + i));
		}
	}
	
	public T get(Object key){
		if(circle.isEmpty()){
			return null;
		}
		int hash = hashCode(key.toString());
		/*If object's key equals to a virtual node's key, we just return the node*/
		if(!circle.containsKey(hash)){
			/*Get the sub HashMap that all its key greater than hash*/
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);
			/*If no entry's key greater than hash means it is smallest one
			 *so we return circle.firstKey.
			 *Otherwise, we return sub HashMap's first key instead.*/
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		return circle.get(hash);
	}
	
	private int hashCode(T object){
		return object.hashCode();
	}
	
	private int hashCode(String key){
		int sum = 0;
		for(int i = 0; i < key.length(); i++){
			sum = sum * 33 + (int)(key.charAt(i));
			sum = sum % circle.size();
		}
		return sum;
	}
	
	
}
