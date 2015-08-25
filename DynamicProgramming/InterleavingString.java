package DynamicProgramming;
/*Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
  For example,
  Given:
	s1 = "aabcc",
	s2 = "dbbca",
  When s3 = "aadbbcbcac", return true.
  When s3 = "aadbbbaccc", return false.*/
class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != s1.length() + s2.length()){
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		/*match[i][j] means the first i + j chars of s3 match with first i chars of s1 and first j chars of s2*/
		boolean[][] match = new boolean[c1.length + 1][c2.length + 1];
		match[0][0] = true;
		/*Initialization*/
		for(int i = 1; i <= c1.length; i++){
			if(c1[i - 1] == c3[i - 1]){
				match[i][0] = match[i - 1][0]; 
			}else{
				match[i][0] = false;
			}
		}
		for(int j = 1; j <= c2.length; j++){
			if(c2[j - 1] == c3[j - 1]){
				match[0][j] = match[0][j - 1];
			}else{
				match[0][j] = false;
			}
		}
		
		for(int i = 1; i <= c1.length; i++){
			for(int j = 1; j <= c2.length; j++){
				match[i][j] = ((c1[i - 1] == c3[i + j - 1]) && match[i - 1][j]) || 
							  ((c2[j - 1] == c3[i + j - 1]) && match[i][j - 1]); 
//				if(match[i][j]){
//					System.out.println("match["+i+"]" + "[" + j + "] = true");
//				}else{
//					System.out.println("match["+i+"]" + "[" + j + "] = false");
//				}
			}
		}
		
		return match[c1.length][c2.length];
	}
	
	public static void main(String args[]){
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		isInterleave(s1, s2, s3);
	}
}
