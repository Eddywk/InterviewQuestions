package DynamicProgramming;
/*Given a string S, find the longest palindromic substring in S. 
 *You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.*/
class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0){
			return "";
		}else if(s.length() == 1){
			return s;
		}
		/*dp[i][j] means s[i, j] is plalindrome.*/
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < dp.length; j++){
				/*i >= j s[i, j] likes null string, so we set them true*/
				dp[i][j] = i >= j ? true : false;
			}
		}
		int max = 1;
		int start = 0, end = 0;
		/*Notice for loop style!
		 *The traverse should be like [0, 1], [1, 2], [2, 3]...[0, 2], [1, 3]..
		 *[i, i + 1] -> [i, i + 2] ->....*/
		for(int k = 1; k < s.length(); k++){
			for(int i = 0; i + k < s.length(); i++){
				int j = i + k;
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i + 1][j - 1];
					if(dp[i][j] && k + 1 > max){
						max = k + 1;
						start = i;
						end = j + 1;
					}
				}else{
					dp[i][j] = false;
				}
			}
		}
		return s.substring(start, end);
	}
}
