package DynamicProgramming;
/*A message containing letters from A-Z is being encoded to numbers using the following mapping:
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
  Given an encoded message containing digits, determine the total number of ways to decode it.
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
  The number of ways decoding "12" is 2.*/
class DecodeWays {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if(one != 0){
                dp[i] = dp[i - 1];
            }
            if(s.charAt(i - 2) != '0'){
                if(two >= 1 && two <= 26){
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
    
    public static void main(String args[]){
    	String s = "110";
    	System.out.println(numDecodings(s));
    }
}
