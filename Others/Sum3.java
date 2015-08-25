package Others;

import java.util.ArrayList;
import java.util.Arrays;
/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 *Find all unique triplets in the array which gives the sum of zero.
  Note:
   Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
   The solution set must not contain duplicate triplets.
   For example, given array S = {-1 0 1 2 -1 -4},
      A solution set is:
      (-1, 0, 1)
      (-1, -1, 2)*/
class Sum3 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		/*Idea: We enumerate a and use two pointers to traverse rest of array,
		 *so, we can get b and c by using Two Sum method, the time complexity is O(n^2)*/
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		/*Sort array to satisfy non-descending order*/
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++){
			int a = num[i];
			/*Traverse after i, so a, b, c will be non-descending order*/
			int start = i + 1, end = num.length - 1;
			/*Skip duplicated a*/
			if(i != 0 && num[i] == num[i - 1]){
				continue;
			}
			while(start < end){
				int b = num[start];
				int c = num[end];
				if(b + c == -a){
					ArrayList<Integer> res = new ArrayList<Integer>();
					res.add(a);
					res.add(b);
					res.add(c);
					result.add(res);
					/*Don't forget to change start and end!*/
					start++;end--;
					/*Skip duplicated b*/
					while(start < end && num[start] == num[start - 1]){
						start++;
					}
					/*Skip duplicated c*/
					while(start < end && num[end] == num[end + 1]){
						end--;
					}
				}else if(b + c < -a){
					start++;
				}else{
					end--;
				}
			}
		}
		return result;
	}
}
