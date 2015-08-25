package Others;
/*n transactions with commit fee*/
class BestTimetoBuyandSellStock5 {
	public static int maxProfit(int[] prices , int fee) {
		int top = prices[0];
		int bottom = prices[0];
		int profit = 0;
		for(int i = 1; i < prices.length - 1; i++){
			if(prices[i - 1] < prices[i] && prices[i] > prices[i + 1]){
				top = prices[i];
			}
			if(prices[i - 1] > prices[i] && prices[i] < prices[i + 1]){
				if(top - bottom > 2 * fee && top - prices[i] > 2 * fee){
					profit += top - bottom - 2 * fee;
					bottom = prices[i];
				}
			}
		}
		top = Math.max(prices[prices.length - 1], top);
		bottom = Math.min(prices[prices.length - 2], bottom);
		if(top - bottom > 2 * fee){
			profit += top - bottom - 2 * fee;
		}
		return profit;
	}
	
	public static void main(String[] args){
		int[] prices = {0, 100, 300, 100, 300, 400, 300, 400, 500, 600};
		int[] case1 = {0, 300};
		int[] case2 = {200, 100};
		int[] case3 = {0, 300, 0};
		int[] case4 = {200, 0, 300};
		System.out.println(maxProfit(prices, 100));
		System.out.println(maxProfit(case1, 100));
		System.out.println(maxProfit(case2, 100));
		System.out.println(maxProfit(case3, 100));
		System.out.println(maxProfit(case4, 100));
	}
}
