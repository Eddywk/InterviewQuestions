package DynamicProgramming;

class Ksum {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public static int  kSum(int A[], int k, int target) {
        // write your code here
        int n = A.length;
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; ++i)
        for(int j = 0; j <= i && j <= k; ++j)
        for(int s = 0; s <= target; ++s){
            dp[i][j][s] = dp[i - 1][j][s];//not choose A[i]
            if(j > 0 && s >= A[i - 1])
                dp[i][j][s] += dp[i - 1][j - 1][s - A[i - 1]];
        }
        return dp[n][k][target];
    }
    
    public static void main(String args[]){
    	int[] A = {1,2,3,4};
    	System.out.println(kSum(A, 2, 5));
    }
}
