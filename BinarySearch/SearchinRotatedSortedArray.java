package BinarySearch;
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.
  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
  You are given a target value to search. If found in the array return its index, otherwise return -1.
  You may assume no duplicate exists in the array.*/
class SearchinRotatedSortedArray {
	/*Idea: Draw picture about this problem.
	 * 		Rotated Array: [+ + + + ~ ~ ~ ~ ~ ~ ~ ~]
	 * 					   S      m n    mid       E
	 * 		So, we can get A[n] < A[E] < A[S] < A[m], S ~ m is incremental and n ~ E is also incremental!
	 * 		Case 1: like figure above, A[mid] < A[S]
	 * 				then mid must in[n, E]
	 * 				Case 1.1: A[S] <= target <= A[mid], end = mid;
	 * 				Case 1.2: A[mid] < target <= A[end], start = mid;
	 * 		Case 2: A[mid] >= A[S]
	 * 				then mid must in [S, m]
	 * 				Case 2.1: A[S] <= target <= A[mid], start = mid;
	 * 				Case 2.2: A[mid] < target <= A[end], end = mid;*/
	public int search(int[] A, int target) {
		if(A == null || A.length == 0){
			return -1;
		}
		int start = 0, end = A.length - 1;
		int mid;
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			/*Check mid in which incremental part*/
			if(A[start] < A[mid]){
				/*Check target in which incremental part*/
				if(A[start] <= target && target <= A[mid]){
					end = mid;
				}else{
					start = mid;
				}
			}else{
				if(A[mid] <= target && target <= A[end]){
					start = mid;
				}else{
					end = mid;
				}
			}
		}
		if(A[start] == target){
			return start;
		}
		if(A[end] == target){
			return end;
		}
		return -1;
	}
}
