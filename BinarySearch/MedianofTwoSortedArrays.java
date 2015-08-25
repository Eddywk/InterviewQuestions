package BinarySearch;
/*There are two sorted arrays A and B of size m and n respectively. 
 *Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).*/
class MedianofTwoSortedArrays {
	/*Idea: Transfer the question into more general one find Kth number in two arrays which k = total length / 2*/
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		/*Check total length is even or odd*/
		if(len % 2 == 0){
			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
		}else{
			return findKth(A, 0, B, 0, len / 2 + 1);
		}
	}
	
	/*Find Kth number in two arrays*/
	private int findKth(int[] A, int A_start, int[] B, int B_start, int k){
		/*Avoid A_start and B_start out of boundary
		 *For Example: A = {}  B = {1}
		 *			   A = {1} B = {1}*/
		if(A_start >= A.length){
			return B[B_start + k - 1];
		}
		if(B_start >= B.length){
			return A[A_start + k - 1];
		}
		/*Base Case: cannot do k / 2 remove because if k == 1, k / 2 == 0 meaningless*/
		if(k == 1){
			return Math.min(A[A_start], B[B_start]);
		}
		/*If middle position out of boundary give key value Integer.MAX_VALUE,
		 *this will make next step can be continued even if one of subscript out of boundary*/
		int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
		/*Each time remove k / 2 elements in one array, search rest k - k / 2
		 *Notice: k - k / 2 != k / 2*/
		if(A_key < B_key){
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		}else{
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
}
