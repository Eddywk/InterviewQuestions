package DataStructure;

import java.util.HashMap;


/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
  For example,
  Given [100, 4, 200, 1, 3, 2],
  The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
  Your algorithm should run in O(n) complexity.*/
class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num) {
		if(num == null || num.length == 0){
			return 0;
		}
		/*This HashMap's key means number in array,
		 *value means if the number has been scan*/
		HashMap<Integer, Boolean> hs = new HashMap<Integer, Boolean>();
		int maxLength = 1;
		for(int number : num){
			hs.put(number, false);
		}
		
		for(int number : num){
			/*If the number has been scan in other number's traverse, skip*/
			if(hs.get(number)) continue;
			int cur_max = 1;
			int tmp = number;
			/*Count numbers that greater than current number*/
			while(hs.containsKey(tmp + 1)){
				cur_max++;
				tmp++;
				hs.put(tmp, true);
			}
			tmp = number;
			/*Count numbers that smaller than current number*/
			while(hs.containsKey(tmp - 1)){
				cur_max++;
				tmp--;
				hs.put(tmp, true);
			}
			maxLength = Math.max(cur_max, maxLength);
		}
		return maxLength;
	}
	
	public static void main(String args[]){
		int[] num = {100, 1, 200, 2, 3, 4};
		System.out.println(longestConsecutive(num));
	}
	
}
