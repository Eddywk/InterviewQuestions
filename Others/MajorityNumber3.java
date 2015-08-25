package Others;

import java.util.HashMap;
import java.util.Iterator;

/*Given an array of integers and a number k, the majority number is the number that occurs 
 *more than 1/k of the size of the array. Find it.*/
class MajorityNumber3 {
	public static int majorityNumber(int[] nums, int k) {
		/*Setup HashTable to store k - 1 candidates,
		 *because we need to find the number occurs more than 1/k
		 *rather than equals to 1/k*/
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for(int num : nums){
			/*If number exist in HashTable count++*/
			if(hash.containsKey(num)){
				hash.put(num, hash.get(num) + 1);
			}
			/*If number doesn't exist in HashTable but HashTable's size is not full,
			 *put it into HashTable as new candidate*/
			else if(hash.size() < k - 1){
				hash.put(num, 1);
			}
			/*If HashTable doesn't contains the number & HashTable is full*/
			else{
				/*Decrease all count in HashTable, if any number's count equals to 0, remove it*/
				Iterator<Integer> iterator = hash.keySet().iterator();
				while(iterator.hasNext()){
					int key = iterator.next();
					int value = hash.get(key) - 1;
					if(value == 0){
						iterator.remove();
					}else{
						hash.put(key, value);
					}
				}
			}
		}
		/*Reset count of all candidates*/
		for(int key : hash.keySet()){
			hash.put(key, 0);
		}
		/*Record number of occurs of all candidates*/
		for(int num : nums){
			if(hash.containsKey(num)){
				int value = hash.get(num);
				hash.put(num, value + 1);
			}
		}
		/*Find the number with maximum occurs count*/
		int max = Integer.MIN_VALUE;
		int count = -1;
		for(int key : hash.keySet()){
			if(hash.get(key) > count){
				max = key;
				count = hash.get(key);
			}
		}
		return max;
	}
	
	public static void main(String args[]){
		/*6 one 3 three 2 two 1 four 4 five*/
		int[] tc = {1,1,1,1,1,1,3,3,3,2,2,4,5,5,5,5};
		int[] tc1 = {2,2,1,1,1,3};
		System.out.println(majorityNumber(tc, 5));
		System.out.println(majorityNumber(tc1, 3));
	}
}
