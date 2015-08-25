package DynamicProgramming;
/*Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
  You have the following 3 operations permitted on a word:
  a) Insert a character
  b) Delete a character
  c) Replace a character*/
class EditDistance {
	public static int minDistance(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();
		if(length1 == 0 || length2 == 0){
			return length1 == 0 ? length2 : length1;
		}
		/*dp[i][j] means the minimum distance that converts word1[0, i] to word2[0][j]*/
		int[][] dp = new int[length1 + 1][length2 + 1];
		/*Special base case: Both word1 and word2 are empty*/
		dp[0][0] = 0;
		/*Base Case: If word2 is empty, then distance is the length of word1(only insertion)*/
		for(int i = 1; i <= length1; i++){
			dp[i][0] = i;
		}
		/*Base Case: If word1 is empty, then distance is the length of word2(only insertion)*/
		for(int j = 1; j <= length2; j++){
			dp[0][j] = j;
		}
		/*DP*/
		for(int i = 1; i <= length1; i++){
			for(int j = 1; j <= length2; j++){
				if(word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					/*dp[i][j] = dp[i - 1][j - 1] means we replace word1[i] to word2[j]
					 *dp[i][j] = dp[i - 1][j] means we delete word1[i]
					 *dp[i][j] = dp[i][j - 1] means we delete word2[j]
					 *We need minimum one from these three situations.*/
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
//                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, 
//                        dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
			}
		}
		System.out.println(dp[0][1]);
		return dp[length1][length2];
	}
	
	public static void main(String args[]){
		String s1 = "a";
		String s2 = "ab";
		System.out.println(minDistance(s1, s2));
	}
}
