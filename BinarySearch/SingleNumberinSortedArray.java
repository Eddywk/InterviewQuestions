package BinarySearch;
/*Given a sorted array each number appear twice except one, find the single number*/
class SingleNumberinSortedArray {
	public static int findSingleNumber(int[] A){
		if(A == null || A.length % 2 == 0){
			return -1;
		}
		if(A.length == 1){
			return A[0];
		}
		if(A[0] != A[1]){
			return A[0];
		}
		if(A[A.length - 1] != A[A.length - 2]){
			return A[A.length - 1];
		}
		int start = 0;
		int end = A.length - 1;
		int mid;
		while(start <= end){
			mid = start + (end - start) / 2;
			if(A[mid] != A[mid - 1] && A[mid] != A[mid + 1]){
				return A[mid];
			}else if(A[mid] == A[mid - 1]){
				if(mid % 2 == 0){
					end = mid - 2;
				}else{
					start = mid + 1;
				}
			}else if(A[mid] == A[mid + 1]){
				if(mid % 2 == 0){
					start = mid + 2;
				}else{
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int[] A = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7};
		int[] B = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7};
		int[] C = {1, 1, 2, 3, 3, 5, 5};
		System.out.println(findSingleNumber(B));
	}
}
