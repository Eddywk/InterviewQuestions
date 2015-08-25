package ArrayandString;
/*Follow up for "Remove Duplicates":
  What if duplicates are allowed at most twice?
  For example,
	Given sorted array A = [1,1,1,2,2,3],
  Your function should return length = 5, and A is now [1,1,2,2,3].*/
class RemoveDuplicatesfromSortedArray2 {
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		int size = 1;
		int count = 1;
		for(int i = 1; i < A.length; i++){
			if(A[i] == A[i - 1]){
				count++;
				if(count > 2){
					continue;
				}
				A[size++] = A[i];
			}else{
				/*Reset count*/
				count = 1;
				A[size++] = A[i];
			}
		}
		return size;
	}
}
