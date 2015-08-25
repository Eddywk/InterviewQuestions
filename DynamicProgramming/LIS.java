package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

class LIS {
	/*Given a sequence of integers, find the longest increasing subsequence (LIS).
	  You code should return the length of the LIS.
	
	  Example
	  	For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
		For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
*/
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
    	if(nums.length == 0) return 0;
    	/*longest[i] means LIS ended as i*/
        int[] longest = new int[nums.length];
        longest[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            longest[i] = 1;
            for(int j = 0; j < i; j++){
            	/*Traverse from left to right*/
                if(nums[i] >= nums[j])
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                max = Math.max(max, longest[i]);
            }
        }
        return max;
    }
    
    public static ArrayList<Integer> printLISPath(int[] nums){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int[] longest = new int[nums.length];
    	longest[0] = 1;
    	int[] prev = new int[nums.length];
    	Arrays.fill(prev, -1);
    	for(int i = 1; i < nums.length; i++){
    		for(int j = 0; j < i; j++){
    			if(nums[j] < nums[i]){
    				if(longest[j] + 1 > longest[i]){
    					longest[i] = longest[j] + 1;
    					prev[i] = j;
    				}
    			}
    		}
    	}
    	int end = nums.length - 1;
    	int max = 1;
    	for(int i = 0; i < longest.length; i++){
    		if(longest[i] > max){
    			max = longest[i];
    			end = i;
    		}
    	}
    	int start = prev[end];
    	result.add(nums[end]);
    	while(start != -1){
    		result.add(0, nums[start]);
    		start = prev[start];
    	}
    	return result;
    }
    
    public static void main(String args[]){
    	int[] case1 = {5, 4, 1, 2, 3, 1};
    	int[] case2 = {4, 2, 4, 5, 3, 7, 1};
    	System.out.println("Case 1's LIS is "+ longestIncreasingSubsequence(case1));
    	System.out.println("Case 2's LIS is "+ longestIncreasingSubsequence(case2));
    	ArrayList<Integer> list = printLISPath(case2);
    	for(int i : list){
    		System.out.print(i + " ");
    	}
    }
}
