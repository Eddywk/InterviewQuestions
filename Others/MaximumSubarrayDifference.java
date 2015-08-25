package Others;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an array with integers.
  Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
  Return the largest difference.*/
class MaximumSubarrayDifference {
	/*Idea: Partition and enumerate partition line, so the result will be
	 *abs(max sub-array in left - min sub-array in right) or 
	 *abs(min sub-array in left - max sub-array in right)*/
	public static int maxDiffSubArrays(int[] nums) {
		int[][] maxSubArray = new int[nums.length][nums.length];
		int[][] minSubArray = new int[nums.length][nums.length];
		for(int i = 0; i < nums.length; i++){
			for(int j = i; j < nums.length; j++){
				maxSubArray[i][j] = getMaxSubArray(nums, i, j);
				minSubArray[i][j] = getMinSubArray(nums, i, j);

			}
		}
		
		int max_diff = 0;
		for(int i = 1; i < nums.length; i++){			
			max_diff = Math.max(max_diff, Math.abs(maxSubArray[0][i - 1] - minSubArray[i][nums.length - 1]));
			//max_diff = Math.max(max_diff, Math.abs(maxSubArray[i][nums.length - 1] - minSubArray[0][i - 1]));
			max_diff = Math.max(max_diff, Math.abs(minSubArray[0][i - 1] - maxSubArray[i][nums.length - 1]));
		}
		return max_diff;
	}
	
	private static int getMaxSubArray(int[] nums, int start, int end){
		int max = Integer.MIN_VALUE;
		int sum = 0, minSum = 0;
		for(int i = start; i <= end; i++){
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
	
	private static int getMinSubArray(int[] nums, int start, int end){
		int[] newArray = Arrays.copyOfRange(nums, start, end + 1);
		for(int i = 0; i < newArray.length; i++){
			newArray[i] *= -1;
		}
		int max = getMaxSubArray(newArray, 0, newArray.length - 1);
		int min = -1 * max;
		return min;
	}
	
	/*Better Version: Time O(n) Space O(n)*/
    public static int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] left_max = new int[size];
        int[] left_min = new int[size];
        int[] right_max = new int[size];
        int[] right_min = new int[size];
        int[] copy = new int[size];
        /*Get negative copy*/
        for(int i = 0; i < size; i++){
            copy[i] = -1 * nums.get(i);
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        /*Forward: get max subarray*/
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_max[i] = max;
        }
        /*Backward: get max subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_max[i] = max;
        }
        /*Forward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = 0; i < size; i++){
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_min[i] = -1 * max;
        }
        /*Backward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size - 1; i >= 0; i--){
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_min[i] = -1 * max;
        }       
        int diff = 0;
        /*Enumerate partition line*/
        for(int i = 0; i < size - 1; i++){
            diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
            diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
        }
        return diff;
    }
	
	public static void main(String args[]){
		int[] test = {-1, 1, -1, 2, 3, 4, 5, 6, 7};
		int[] test1 = {1,2,-3,1};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int num : test1){
			nums.add(num);
		}
		System.out.println(maxDiffSubArrays(nums));
	}
	
}
