package Sort;

class CountingSort {
	public static int[] sort(int[] A){
		if(A == null || A.length == 0){
			throw new NullPointerException();
		}
		int[] B = new int[A.length];
		int max = A[0], min = A[0];
		for(int num : A){
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		int k = max - min + 1;
		int[] C = new int[k];
		for(int num : A){
			C[num - min] += 1;
		}
		for(int i = 1; i < C.length; i++){
			C[i] += C[i - 1];
		}
		for(int num : A){
			B[--C[num - min]] = num;
		}
		return B;
	}
	
	public static void main(String args[]){
		int[] A = {100,93,97,92,96,99,92,89,93,97,90,94,92,95};
		int[] B = sort(A);
		for(int num : B){
			System.out.print(num + " ");
		}
	}
}
