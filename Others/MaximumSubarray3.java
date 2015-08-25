package Others;

import java.util.ArrayList;

class MaximumSubarray3 {
    public static int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        int size = nums.size();
        int[][] max = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                max[i][j] = getMaxSubarray(nums, i, j);
            }
        }
        int[] sum = new int[size + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums.get(i - 1);
        }
        int[][] dp = new int[size + 1][k + 1];
        dp[0][0] = 0;
        for(int m = 1; m <= k; m++){
            for(int i = 1; i <= m; i++){
                dp[i][m] = sum[i];
            }
        }
        for(int m = 1; m <= k; m++){
            for(int i = m; i <= size; i++){
                for(int j = 1; j < i && j < m; j++){
                    dp[i][m] = Math.max(dp[j][m - 1] + max[m][i], dp[i - 1][k] + nums.get(i -1));
                }
            }
        }
        return dp[size][k];
    }
    
    private static int getMaxSubarray(ArrayList<Integer> nums, int start, int end){
		int max = Integer.MIN_VALUE;
		int sum = 0, minSum = 0;
		for(int i = start; i <= end; i++){
			sum += nums.get(i);
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		return max;        
    }
    
    public static void main(String args[]){
    	int[] tc = {1, 2, 3};
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	for(int num : tc){
    		nums.add(num);
    	}
    	System.out.println(maxSubArray(nums, 1));
    }
}
