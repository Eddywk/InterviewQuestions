package DynamicProgramming;
/*Implement wildcard pattern matching with support for '?' and '*'.
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
  The matching should cover the entire input string (not partial).
  The function prototype should be:
	bool isMatch(const char *s, const char *p)
  Some examples:
	isMatch("aa","a") -> false
	isMatch("aa","aa") -> true
	isMatch("aaa","aa") -> false
	isMatch("aa", "*") -> true
	isMatch("aa", "a*") -> true
	isMatch("ab", "?*") -> true
	isMatch("aab", "c*a*b") -> false*/
class WildcardMatching {
	public static boolean isMatch(String s, String p) {
		if(s == null){
			return p == null;
		}
		if(p == null){
			return s == null;
		}
		/*Special Case: s = "" p = "*" */
		if(s.length() == 0 && p.length() == 1 && p.charAt(0) == '*'){
			return true;
		}
		int count = 0;
		int s_len = s.length();
		int p_len = p.length();
		/*Skip impossible matching*/
		for(int i = 0; i < p_len; i++){
			if(p.charAt(i) != '*'){
				count++;
			}
		}
		if(count > s_len){
			return false;
		}
		/*dp[i][j] means s[1 ~ i] matched p[1 ~ j]*/
		boolean[][] dp = new boolean[s_len + 1][p_len + 1];
		/*Base case: both s and p are null or ""*/
		dp[0][0] = true;
		for(int i = 1; i <= s_len; i++){
			for(int j = 1; j <= p_len; j++){
				/*If s = "" and p = "*****....." then dp[0][j] is true*/
				dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
				if(p.charAt(j - 1) == '*'){
					/*i = 2, j = 1 s = "dd" p = "*" 
					 *so, dp[2][1] = dp[1][1] || dp[2][0]
					 *s[dd] match p[*] = (s[d] match p[*]) || (s[dd] match p[""])*/
					/*Match one char: dp[i][j] = dp[i - 1][j]
					 *Match zero char: dp[i][j] = dp[i][j - 1]*/
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}else if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					/*For example s = "aab" p = "c*a*b" p[j] != s[i] p[0] != '*' and p[0] != '?'*/
					dp[i][j] = false;
				}
			}
		}
		return dp[s_len][p_len];
	}
	
	public static void main(String args[]){
		System.out.print(isMatch("dddddab", "*a*b"));
	}
}
