package Others;
/*Say you have an array for which the ith element is the price of a given stock on day i.
  Design an algorithm to find the maximum profit. You may complete at most two transactions.
  Note:
   You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/
class BestTimetoBuyandSellStock3 {
	/*Idea: we need to do at most two transactions, so we need to partition the array.
	 *One is max(0, i) represents maximum profit from day 0 to day i
	 *Another is max(i+1, n) represents maximum profit from day i+1 to day n.
	 *So, the maximum profit is we do one transaction at(0, i) and do another at (i+1, n)*/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
        	return 0;
        }
        /*left[i] means the maximum profit we can get at (0, i)*/
        int[] left = new int[prices.length];
        /*right[i] means the maximum profit we can get at (i+1, n)*/
        int[] right = new int[prices.length];
        
        /*Use BestTimetoBuyandSellStock1 method to get maximum profit*/
        int min = prices[0];
        left[0] = 0;
        for(int i = 1; i < prices.length; i++){
        	min = Math.min(min, prices[i]);
        	left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        int max = prices[prices.length - 1];
        right[right.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--){
        	max = Math.max(max, prices[i]);
        	right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        /*The result equals to merge maximum profit of the two transactions */
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
        	profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
}
