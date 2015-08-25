package Others;

import java.util.HashMap;
/*Given an array of integers, find two numbers such that they add up to a specific target number.
  The function twoSum should return indices of the two numbers such that they add up to the target, 
  where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
  You may assume that each input would have exactly one solution.
  Input: numbers={2, 7, 11, 15}, target=9
  Output: index1=1, index2=2*/
class TwoSum {
	/*Idea: Using HashTable, we can put key as target - numbers[i] ,and value as i.
	 *So, we just need to check if any numbers[j] = target - numbers[i]*/
	public int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length == 0){
			return null;
		}	
		/*Put target - numbers[i] into HashTable*/
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i = 0; i < numbers.length; i++){
			int number = target - numbers[i];
			if(!hs.containsKey(number)){
				hs.put(number, i);
			}
		}
		for(int i = 0; i < numbers.length; i++){
			if(hs.containsKey(numbers[i])){
				int index1 = i + 1;
				int index2 = hs.get(numbers[i]) + 1;
				/*Special case, the number is a half of target*/
				if(index1 == index2){
					continue;
				}
				result[0] = index1 < index2 ? index1 : index2;
				result[1] = index1 > index2 ? index1 : index2;
				break;
			}
		}
		return result;
	}
}
