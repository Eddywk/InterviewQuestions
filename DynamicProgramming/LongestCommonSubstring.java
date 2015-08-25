package DynamicProgramming;

class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
