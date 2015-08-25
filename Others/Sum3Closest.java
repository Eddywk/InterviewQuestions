package Others;

import java.util.Arrays;
/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 *Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
class Sum3Closest {
	public int threeSumClosest(int[] num, int target) {
		if(num == null || num.length < 3){
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);
		/*Prevent integer overflow*/
		int closest_sum = Integer.MAX_VALUE / 2;
		for(int i = 0; i < num.length; i++){
			int start = i + 1, end = num.length - 1;
			while(start < end){
				int sum = num[i] + num[start] + num[end];
				if(sum == target){
					return sum;
				}else if(sum < target){
					start++;
				}else{
					end--;
				}
				/*Compare to get closest sum for target*/
				closest_sum = Math.abs(sum - target) < Math.abs(closest_sum - target) ? sum : closest_sum;
			}
		}
		return closest_sum;
	}
}
