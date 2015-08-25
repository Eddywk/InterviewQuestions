package DynamicProgramming;

class PalindromePartitioning2 {
	
	/*Given a string s, partition s such that every substring of the partition is a palindrome.

	  Return the minimum cuts needed for a palindrome partitioning of s.

	  For example, given s = "aab",
	  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.*/
    public static int minCut(String s) {
    	if(s.length() == 0 || s == null) return 0;
    	
    	/*cut[i] means the minimum cut number of first i chars in s*/
    	int[] cut = new int[s.length()+1];
    	/*Initialization for base case*/
    	boolean[][] isPalindrome = getIsPalindrome(s);
    	cut[0] = 0;
    	
    	for(int i = 1; i <= s.length(); i++){
    		cut[i] = Integer.MAX_VALUE;
    		for(int j = 1; j <= i; j++){
    			/*Key Function: cut[i] = cut[j] +1 && j+1 ~ i is palindrome
    			 *isPalindrome[i - j][i - 1] means j+1 ~ i is palindrome
    			 *cut[i - j] != Integer.MAX_VALUE means first j chars is palindrome
    			 *So, this ensure divide first i chars by position j, both of the left and right 
    			 *are palindrome*/
    			if(isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE){
    				cut[i] = Math.min(cut[i], cut[i - j] + 1);
    			}
    		}
    	}
        return cut[s.length()] - 1;
    }
    
    /*Base Case Initialization*/
    private static boolean[][] getIsPalindrome(String s){
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	/*Every single char is palindrome*/
    	for(int i = 0; i < s.length(); i++){
    		isPalindrome[i][i] = true;
    	}
    	/*Initialize sub-string that length = 2*/
    	for(int i = 0; i < s.length() -1; i++){
    		isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
    	}
    	/*General base case:
    	 *If a string s = [c1[********]cn] is palindrome, then 
    	 * [********] must be palindrome && c1 == cn*/
    	for(int length = 2; length < s.length(); length++){
    		for(int start = 0; start + length < s.length(); start++){
    			isPalindrome[start][start + length] = 
    					isPalindrome[start + 1][start + length -1] && s.charAt(start) == s.charAt(start + length);
    		}
    	}
    	return isPalindrome;
    }
    
	public static void main(String args[]){
		String s1 = "aab";
		System.out.println(s1+" min-cut is: "+minCut(s1));
	}
}
