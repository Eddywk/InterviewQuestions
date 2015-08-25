package DynamicProgramming;
/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
  For example,
  Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/
class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		/*dp[i] means the number of unique BST that its length is i*/
		int[] dp = new int[n + 1];
		/*Base cases*/
		dp[0] = dp[1] = 1;
		/*Start from i = 2*/
		for(int i = 2; i <= n; i++){
			/*Emulate root elements*/
			for(int k = 1; k <= i; k++){
				/*dp[i] += For each root[k] : [k - 1] * [k + 1 ~ i]*/
				dp[i] += dp[k - 1] * dp[i - k];
			}
		}
		return dp[n];
	}
}
