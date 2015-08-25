package Others;

import java.util.ArrayList;
import java.util.Arrays;
/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 *Find all unique quadruplets in the array which gives the sum of target.
	Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
	The solution set must not contain duplicate quadruplets.*/
class Sum4 {
	/*Idea: we enumerate a(num[i]) and b(num[j]),
	 *then do same as we do in 2sum and 3sum*/
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 4){
			return result;
		}
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++){
			if(i != 0 && num[i] == num[i - 1]){
				continue;
			}
			for(int j = i + 1; j < num.length; j++){
				if(j != i + 1 && num[j] == num[j - 1]){
					continue;
				}
				int start = j + 1, end = num.length - 1;
				while(start < end){
					int sum = num[i] + num[j] + num[start] + num[end];
					if(sum == target){
						ArrayList<Integer> res = new ArrayList<Integer>();
						res.add(num[i]);
						res.add(num[j]);
						res.add(num[start]);
						res.add(num[end]);
						result.add(res);
						start++;end--;
						while(start < end && num[start] == num[start - 1]){
							start++;
						}
						while(start < end && num[end] == num[end + 1]){
							end--;
						}
					}else if(sum < target){
						start++;
					}else{
						end--;
					}
				}
			}
		}
		return result;
	}
}
