package ArrayandString;

import java.util.ArrayList;
/*Given a rotated sorted array, recover it to sorted array in-place.
  Example
	[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
*/
class RecoverRotatedSortedArray {
	/*Idea: 1.Find break point pos
	 * 		2.reverse left of break point
	 * 		3.reverse right of break point
	 * 		4.reverse entire array*/
	public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if(nums == null || nums.size() <= 1){
			return;
		}
		/*Find break point*/
		int pos = 0;
		for(int i = 0; i < nums.size(); i++){
			if(i != 0 && nums.get(i) < nums.get(i - 1)){
				pos = i;
				break;
			}
		}
		/*Reverse left*/
		reverse(nums, 0, pos - 1);
		/*Reverse right*/
		reverse(nums, pos, nums.size() - 1);
		/*Reverse whole array*/
		reverse(nums, 0, nums.size() - 1);
	}
	
	private static void reverse(ArrayList<Integer> a, int start, int end){
		if(start >= end || start < 0 || end > a.size() - 1){
			return;
		}
		while(start < end){
			int tmp = a.get(start);
			a.set(start, a.get(end));
			a.set(end, tmp);
			start++; end--;
		}
	}
	
	public static void main(String args[]){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(5);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		recoverRotatedSortedArray(nums);
		for(int i = 0; i < nums.size(); i++){
			System.out.println(nums.get(i));
		}
	}
}
