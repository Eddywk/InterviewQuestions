package Others;

import java.util.ArrayList;
import java.util.Arrays;
/*
Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of elements of any subset of given set. 
Expected time complexity is O(n).
Input:  arr[] = {1, 3, 6, 10, 11, 15};
Output: 2

Input:  arr[] = {1, 1, 1, 1};
Output: 5

Input:  arr[] = {1, 1, 3, 4};
Output: 10

Input:  arr[] = {1, 2, 5, 10, 20, 40};
Output: 4

Input:  arr[] = {1, 2, 3, 4, 5, 6};
Output: 22*/
class MinimunPositiveNumber {
	/*Version 1: Brute Force*/
	 public static int getSmallestPositive(int[] A){
	        if(A == null || A.length == 0){
	            return -1;
	        }
	        int[] sumset = subset(A);
	        Arrays.sort(sumset);
	        for(int i = 0, j = 1; i < sumset.length; i++){
	            if(j < sumset[i]){
	                return j;
	            }
	            j++;
	        }
	        return sumset[sumset.length - 1] + 1;
	    }
	    
	    private static int[] subset(int[] A){
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        helper(A, 0, list, result);
	        int[] sumset = new int[result.size()];
	        for(int i = 0; i < result.size(); i++){
	            sumset[i] = getSum(result.get(i));
	        }
	        return sumset;
	    }
	    
	    private static void helper(int[] A, int pos, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
	        if(list.size() != 0){
	            result.add(new ArrayList<Integer>(list));
	        }
	        for(int i = pos; i < A.length; i++){
	            list.add(A[i]);
	            helper(A, i + 1, list, result);
	            list.remove(list.size() - 1);
	        }
	    }
	    
	    private static int getSum(ArrayList<Integer> list){
	        int sum = 0;
	        for(int i = 0; i < list.size(); i++){
	            sum += list.get(i);
	        }
	        return sum;
	    }
	    
	    /*Version 2: O(n)*/
	    public static int getSmallestPositive2(int[] A){
	    	if(A == null || A.length == 0){
	    		return -1;
	    	}
	    	int[] sum = new int[A.length];
	    	sum[0] = A[0];
	    	for(int i = 1; i < A.length; i++){
	    		sum[i] = sum[i - 1] + A[i];
	    	}
	    	for(int i = 0; i < A.length - 1; i++){
	    		if(A[i + 1] - sum[i] > 1){
	    			return sum[i] + 1;
	    		}
	    	}
	    	return sum[sum.length - 1] + 1;
	    }
	    
	    public static void main(String args[]){
	    	int[] tc1 = {1, 1, 1, 1};
	    	System.out.println(getSmallestPositive(tc1));
	    	int[] tc2 = {1, 3, 6, 10, 11, 15};
	    	System.out.println(getSmallestPositive(tc2));
	    	int[] tc3 = {1, 1, 3, 4};
	    	System.out.println(getSmallestPositive(tc3));
	    	int[] tc4 = {1, 2, 5, 10, 20, 40};
	    	System.out.println(getSmallestPositive(tc4));
	    	int[] tc5 = {1, 2, 3, 4, 5, 6};
	    	System.out.println(getSmallestPositive(tc5));
	    	System.out.println("-----------------------");
	    	System.out.println(getSmallestPositive2(tc1));
	    	System.out.println(getSmallestPositive2(tc2));
	    	System.out.println(getSmallestPositive2(tc3));
	    	System.out.println(getSmallestPositive2(tc4));
	    	System.out.println(getSmallestPositive2(tc5));
	    }
}
