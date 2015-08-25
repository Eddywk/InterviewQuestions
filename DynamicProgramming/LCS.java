package DynamicProgramming;

class LCS {
	/*Given two strings, find the longest comment subsequence (LCS).
	  Your code should return the length of LCS.
	
	  Example
		For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1
		For "ABCD" and "EACB", the LCS is "AC", return 2*/
    public static int longestCommonSubsequence(String A, String B) {
    	/*f[i][j] means the LCS of first i chars in A and first j chars in B*/
        int[][] f = new int[A.length()+1][B.length()+1];
        /*Initialize row 0 and column 0*/
        for(int i = 0; i < A.length(); i++){
            f[i][0] = 0;
        }
        for(int j = 0; j < B.length(); j++){
            f[0][j] = 0;
        }
        /*DP*/
        for(int i = 0; i < A.length(); i++){
            for(int j = 0; j < B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    f[i+1][j+1] = f[i][j] + 1;
                }else{
                    f[i+1][j+1] = Math.max(f[i][j+1], f[i+1][j]);
                }
            }
        }
        
        return f[A.length()][B.length()];
    }
	
	public static void main(String args[]){
		String s1 = "ABCD", s2 = "EDCA", s3 = "EACB";
		String string1 = "www.lintcode.com code";
		String string2 = "www.ninechapter.com code";
		System.out.println(s1 + " & " + s2 + "'s LCS is: " + longestCommonSubsequence(s1, s2));
		System.out.println(s1 + " & " + s3 + "'s LCS is: " + longestCommonSubsequence(s1, s3));
		System.out.println(string1 + " & " + string2 + "'s LCS is: " + longestCommonSubsequence(string1, string2));
	}
}
