package DynamicProgramming;

/*Divide an array into two sets that their difference of sum is minimum.
 *Ex: [1, 2, 2, 1] --> (1 + 2) - (2 + 1) = 0
 *	  [1, 2, 1, 2, 1] --> (1+ 2 + 1) - (1 + 2) = 1*/
class MinimumCutDifference {
	public static int getMinimumCutDifference(int[] A){
		int sum = 0;
		for(int num : A){
			sum += num;
		}
		int m = sum / 2;
		int[] dp = new int[m + 1];
		for(int i = 0; i < A.length; i++){
			for(int j = m; j >= 1; j--){
				if(j - A[i] >= 0){
					dp[j] = Math.max(dp[j - A[i]] + A[i], dp[j]);
				}
			}
		}
		return sum - 2 * dp[m];
	}
	
	public static void main(String args[]){
		int[] A1 = {1, 3, 2, 1};
		int[] A3 = {1, 3, 4, 5, 1};
		System.out.println(getMinimumCutDifference(A1));
		System.out.println(getMinimumCutDifference(A3));
	}
}
