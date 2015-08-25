package BinarySearch;
/*Given a sorted array of integers, find the starting and ending position of a given target value.
  Your algorithm's runtime complexity must be in the order of O(log n).
  If the target is not found in the array, return [-1, -1].
  For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].*/
class SearchforaRange {
	/*Idea: Using binary search to find left and right boundary*/
	public static int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		if(A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]){
			result[0] = result[1] = -1;
			return result;
		}
		int start = 0, end = A.length - 1;
		int mid;
		/*Find left boundary*/
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			/*For finding left position we need to discard right,
			 *so end = mid*/
			if(A[mid] == target){
				end = mid;
			}else if(A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		/*The situation can be divided into three cases"
		 *1.We can find left boundary
		 *2.Only one target number in array so left == right
		 *3.We cannot find left boundary*/
		if(A[start] == target){
			result[0] = start;
		}else if(A[end] == target){
			result[0] = end;
		}else{
			result[0] = result[1] = -1;
			return result;
		}
		/*Find right boundary*/
		start = 0; 
		end = A.length - 1;
		while(start + 1 < end){
			/*For finding right position we need to discard left,
			 *so start = mid*/
			mid = start + (end - start) / 2;
			if(A[mid] == target){
				start = mid;
			}else if(A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(A[end] == target){
			result[1] = end;
		}else if(A[start] == target){
			result[1] = start;
		}else{
			result[0] = result[1] = -1;
			return result;
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] tc = {5, 7, 7, 8, 8, 10};
		int[] res = searchRange(tc, 8);
		System.out.println("["+res[0]+", "+res[1]+"]");
	}
}
