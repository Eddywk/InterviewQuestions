package BinarySearch;
/*Follow up for "Search in Rotated Sorted Array":
  What if duplicates are allowed?
  Would this affect the run-time complexity? How and why?
  Write a function to determine if a given target is in the array.*/
class SearchinRotatedSortedArray2 {
	/*Idea: Consider the worst case: all elements are same except for target.
	 *      So, the worst time complexity is O(n).
	 *      We need to skip duplicates.*/
	public boolean search(int[] A, int target) {
		if(A == null || A.length == 0){
			return false;
		}
		int start = 0, end = A.length - 1;
		int mid;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(A[mid] == target){
				return true;
			}
			if(A[start] < A[mid]){
				if(A[start] <= target && target < A[mid]){
					end = mid;
				}else{
					start = mid + 1;
				}
			}else if(A[start] > A[mid]){
				if(A[mid] < target && target <= A[end]){
					start = mid + 1;
				}else{
					end = mid;
				}
			}
			/*Skip duplicates*/
			else{
				start++;
			}
		}
		if(A[start] == target){
			return true;
		}
		if(A[end] == target){
			return true;
		}
		return false;
	}
}
