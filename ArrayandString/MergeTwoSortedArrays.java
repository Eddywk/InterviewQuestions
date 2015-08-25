package ArrayandString;
/*Given two sorted integer arrays A and B, merge B into A as one sorted array.
  Note:
  You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
  The number of elements initialized in A and B are m and n respectively.*/
class MergeTwoSortedArrays {
	public void merge(int A[], int m, int B[], int n) {
		int a = m - 1;
		int b = n - 1;
		int cur = m + n - 1;
		while(a >= 0 && b >= 0){
			if(A[a] > B[b]){
				A[cur] = A[a];
				a--;
			}else{
				A[cur] = B[b];
				b--;
			}
			cur--;
		}
		while(a >= 0 && cur >= 0){
			A[cur] = A[a];
			a--; cur--;
		}
		while(b >= 0 && cur >= 0){
			A[cur] = B[b];
			b--; cur--;
		}
	}
}
