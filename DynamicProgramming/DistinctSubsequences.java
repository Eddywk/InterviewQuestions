package DynamicProgramming;

class DistinctSubsequences {
	/*Given a string S and a string T, count the number of distinct subsequences of T in S.
	  A subsequence of a string is a new string which is formed from the original string by 
	  deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
	  (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

	  Here is an example:
	  S = "rabbbit", T = "rabbit"
	
	  Return 3.*/	
	public static int numDistinct(String S, String T) {
		if(S == null || T == null){
			return 0;
		}
		/*nums[i][j] means the number of distinct subsequences of 
		 *the first i chars in T match first j chars in S*/
		int[][] nums = new int[T.length() + 1][S.length() + 1];
		/*If both T and S are null set, then return 1*/
		nums[0][0] = 1;
		/*Initialization*/
		/*If S is null set, T not: cannot get subsequences, return 0*/
		for(int i = 0; i <= T.length(); i++){
			nums[i][0] = 0; 
		}
		/*If T is null set, S not, only one way: delete all elements in S
		 *to get subsequences, return 1*/
		for(int j = 0; j <= S.length(); j++){
			nums[0][j] = 1;
		}
		/*nums[i][j] at least equals to nums[i][j-1],
		 *if char i == j then nums[i][j] = nums[i][j] + nums[i-1][j-1]
		 *For Example: 
		 *i=2, j=3
		 *T: ra
		 *S: rab
		 *nums[2][3] at least equals to nums[2][2](T:ra, S:ra) by delete j in S
		 *nums[2][2] = 1 because only one way that S can become T : Do Nothing
		 *i=3, j=4
		 *T: rab
		 *S: rabb
		 *nums[3][4] = nums[3][3] by delete S(4)
		 *nums[3][4] += nums[2][3] because T(3) == S(4)
		 *So, nums[3][4] = 1 + 1 = 2*/
		for(int i = 1; i <= T.length(); i++){
			for(int j = 1; j <= S.length(); j++){
				/*nums[i][j] at least equals to nums[i][j-1] 
				 *by delete char j in source string S*/
				nums[i][j] = nums[i][j - 1];
				/*char i -1 is actually position i in string T,
				 *because we initialize size of nums[][] as length + 1*/
				if(T.charAt(i - 1) == S.charAt(j - 1)){
					nums[i][j] += nums[i - 1][j - 1];
				}
			}
		}
		return nums[T.length()][S.length()];
	}
	
	public static void main(String args[]){
		String T = "rabbit";
		String S = "rabbbit";
		System.out.println(numDistinct(S, T));
	}
}
