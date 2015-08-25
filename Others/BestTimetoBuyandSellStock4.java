package Others;
/*Say you have an array for which the ith element is the price of a given stock on day i.
 *Design an algorithm to find the maximum profit. You may complete at most k transactions(sell & buy).*/
class BestTimetoBuyandSellStock4 {
	public int maxProfit(int[] prices , int k) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		/*profit[i][j] means the maximum profit from day i to day j*/
		int[][] profit = new int[prices.length][prices.length];
		for(int i = 0; i < profit.length; i++){
			for(int j = i; j < profit.length; j++){
				profit[i][j] = getProfit(prices, i, j);
			}
		}
		/*dp[i][j] means the maximum profit from day 0 to day i with j transactions*/
		int[][] dp = new int[prices.length][k + 1];
		/*Initialization*/
		for(int i = 0; i < dp.length; i++){
			dp[i][0] = 0; 
		}
		for(int i = 0; i < dp[0].length; i++){
			dp[0][i] = Integer.MIN_VALUE;
		}
		/*DP*/
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j <= k; j++){
				for(int m = 1; m < i; m++){
					dp[i][j] = dp[m - 1][j - 1] + profit[m][i];
				}
			}
		}
		return dp[prices.length - 1][k];
	}
	
	/*Get maximum from start day to end day*/
	private int getProfit(int[] prices, int start, int end){
		if(start > end){
			return 0;
		}
		int min = prices[start];
		int profit = 0;
		for(int i = start; i <= end; i++){
			min = Math.min(min, prices[i]);
			profit = Math.max(profit, prices[i] - min);
		}
		return profit;
	}
	
	//Optimized answer, time complexity: O(n ^ 2) space complexity: O(KN)
	public int maxProfit2(int[] prices , int k) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		int len = prices.length;
		/*Quick solution for special case*/
		if(k > len / 2){
			int profit = 0;
			for(int i = 1; i < len; i++){
				int diff = prices[i] - prices[i - 1];
				if(diff > 0){
					profit += diff;
				}
			}
			return profit;
		}
		/*dp[i][j] means maximum profit from day 0 to day j with i transactions*/
		int[][] dp = new int[k + 1][len];
		/*case1: dp[i][j] = dp[i][j - 1] no sell action happen on day j
		 *case2: dp[i][j] = dp[i - 1][j] special situation: i transactions are too many
		 *case3: dp[i][j] = Max(dp[i - 1][m - 1] + prices[j] - prices[m]) (0 <= m < j) 
		 *       do one transaction between day m and day j(buy at day m and sell at day j)
		 *       And we can transfer the formula into:
		 *       dp[i][j] = prices[j] + Max(dp[i - 1][m - 1] - prices[m]) (0 <= m < j)
		 *       We can use a variables to express Max(dp[i - 1][m - 1] - prices[m]),
		 *       because we get dp value from bottom to top*/
		for(int i = 1; i <= k; i++){
			int max_part = dp[i - 1][0] - prices[0];
			for(int j = 1; j < len; j++){
				/*case 1 & 2*/
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				/*case 3*/
				dp[i][j] = Math.max(dp[i][j], max_part + prices[j]);
				max_part = Math.max(max_part, dp[i - 1][j - 1] - prices[j]);
			}
		}
		return dp[k][len - 1];
	}
	
}
