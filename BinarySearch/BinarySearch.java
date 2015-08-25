package BinarySearch;

import java.util.Arrays;

class BinarySearch {
	public static int binarySearch(int[] num, int target){
		if(num == null || num.length == 0){
			return -1;
		}
		Arrays.sort(num);
		int start = 0, end = num.length - 1;
		int mid;
		/*Using start + 1 < end is better, it's a template!*/
		while(start + 1 < end){
			/*Avoid integer overflow, so we don't use mid = (start + end) / 2*/
		    mid = start + (end - start) / 2; 
			if(num[mid] == target){
				end = mid;
			}else if(num[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		/*To check which one first depends on which solution you want,
		 *For getting first position, check start first,
		 *For getting last position, check end first*/
		if(num[start] == target){
			return start;
		}
		if(num[end] == target){
			return end;
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] A = {2, 1, 3, 6, 7, 1, 8, 9, 4};
		System.out.println(binarySearch(A, 6));
	}
}
