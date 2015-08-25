package Others;
/*Say you have an array for which the ith element is the price of a given stock on day i.
  If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
  design an algorithm to find the maximum profit.*/
class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		int profit = 0;
		/*minPrice means the minimum price from day 0 to day i*/
		int minPrice = Integer.MAX_VALUE;
		for(int price : prices){
			minPrice = Math.min(minPrice, price);
			/*Maintain maximum profit*/
			profit = Math.max(profit, price - minPrice);
		}
		return profit;
	}
}
