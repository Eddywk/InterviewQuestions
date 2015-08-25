package Others;

import java.util.ArrayList;

/*Given an array of integers, find two non-overlapping subarrays which have the largest sum.
  The number in each subarray should be contiguous.
  Return the largest sum.
	Note
	The subarray should contain at least one number
  Example
	For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, -2] or [1, 3, -1, 2] and [2], 
	they both have the largest sum 7.*/
class MaximumSubarray2 {
   public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        /*Forward traversal*/
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        /*Backward traversal*/
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        /*Enumerate partition line*/
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}

/*If the question become to find maximum product of sub-array,
 then we Math.log() all elements in array, so the problem become
 find maximum sum of sub-array again! But precondition is all elements
 in array are positive.*/