package ArrayandString;

class SortNoGapArray {
	public static void sortNoGapArray(int[] A){
		if(A == null || A.length <= 1){
			return;
		}
		int i = 0;
		while(i < A.length){
			if(A[i] == i + 1){
				i++;
				continue;
			}
			swap(A, i, A[i] - 1);
		}
	}
	
	private static void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static boolean hasDuplicate(int[] A){
		if(A == null || A.length <= 1){
			return false;
		}
		int i = 0;
		while(i < A.length){
			/*Right position then skip*/
			if(A[i] == i + 1){
				i++;
				continue;
			}
			/*Found duplicates*/
			if(A[i] == A[A[i] - 1]){
				return true;
			}
			swap(A, i, A[i] - 1);
		}
		return false;
	}
	
	public static void main(String args[]){
//		int[] A = {4, 5, 4, 3, 2, 1, 3};
		int[] A = {4, 5, 2, 1, 3};
		sortNoGapArray(A);
		for(int i : A){
			System.out.print(i + " ");
		}
//		int[] A = {3, 1, 2, 4, 5};
//		int[] B = {1, 2, 3, 4, 4};
//		int[] C = {2, 1, 3, 3};
//		System.out.println(hasDuplicate(A));
//		System.out.println(hasDuplicate(B));
//		System.out.println(hasDuplicate(C));
	}
}
