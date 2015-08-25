package Others;
/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
  For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
  the contiguous subarray [4,-1,2,1] has the largest sum = 6.*/
class MaximumSubarray {
	/*Idea: Use sum array.
	 *sum[i] means the sum of [0, i]
	 *So, sum[i ,j] = sum[j] - sum[i] + A[i]*/
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0, minSum = 0;
		/*Using BestTimetoBuyandSellStock method to get maximum subarray*/
		for(int i = 0; i < A.length; i++){
			sum += A[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;
	}
	
	/*Version 2: Get smallest sum*/
	public int minSubArray(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		/*All elements in original array multiple -1,
		 *so, we can use same method in Maximum Subarray*/
		changeArray(A);
		int sum = 0, minSum = 0;
		int max = 0;
		for(int i = 0; i < A.length; i++){
			sum += A[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.max(sum, minSum);
		}
		max *= -1;
		return max;
	}
	
	private void changeArray(int[] A){
		for(int i = 0; i < A.length; i++){
			A[i] *= -1;
		}
	}	
}
