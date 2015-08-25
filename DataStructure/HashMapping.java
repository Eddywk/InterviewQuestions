package DataStructure;
class HashMapping {
	
	private class HashEntry{
		HashEntry next;
		int value;
		
		public HashEntry(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	final int HASH_TABLE_SIZE = 100;
	HashEntry[] hashtable;
	int capacity;
	int size;
	
	public HashMapping(){
		size = 0;
		capacity = HASH_TABLE_SIZE;
		hashtable = new HashEntry[capacity];
		for(int i = 0; i < hashtable.length; i++){
			hashtable[i].value = -1;
		}
	}
	
	public void put(String key, int value){
		int index = hashfunc(key);
	}
	
	public int get(String key){
		int index = hashfunc(key);
		if(hashtable[index].value == -1){
			return -1;
		}
		return hashtable[index].value;
	}
	
	private int hashfunc(String key){
		int sum = 0;
		for(int i = 0; i < key.length(); i++){
			sum = sum * 33 + (int)key.charAt(i);
			sum = sum % HASH_TABLE_SIZE;
		}
		return sum;
	}
}
