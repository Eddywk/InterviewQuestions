package DynamicProgramming;

import java.util.ArrayList;
import java.util.Set;

class WordBreak {
	/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	  For example, given
	  s = "leetcode",
	  dict = ["leet", "code"].

	  Return true because "leetcode" can be segmented as "leet code".*/
	public static boolean wordBreak(String s, ArrayList<String> dict) {
		/*canBreak[i] means the first i chars can be broken*/
		boolean[] canBreak = new boolean[s.length() + 1];
		/*can[0] is true because for "leetcode", when we reach can[4] "leet",
		 *we can treat it as "" with "leet"*/
		canBreak[0] = true;
		int maxLength = getMaxLength(dict);
		/*DP*/
		for(int i = 1; i <= s.length(); i++){
			canBreak[i] = false;
			/*canBreak[i] = first j chars can be broken &&
			 * 				j+1 ~ i in the dict*/
			/*If the length of right sub-string of first i chars 
			 *greater than max length in dict, then it cannot be broken*/
			for(int j = 1; j <= maxLength && j <= i; j++){
				/*If first j chars cannot be broken, pass*/
				if(!canBreak[i - j])
					continue;
				/*first j chars can be broken*/
				String word = s.substring(i - j, i);
				/*dict contains the word j+1 ~ i*/
				if(dict.contains(word)){
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[s.length()];
	}
	
	/*Obtain the max length of word in dict*/
	private static int getMaxLength(ArrayList<String> dict){
		int maxLength = 0;
		for(String word : dict){
			if(word.length() > maxLength){
				maxLength = word.length();
			}
		}
		return maxLength;
	}
	
	public static void main(String args[]){
		ArrayList dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		String s = "leetcode";
		if(wordBreak(s, dict)){
			System.out.println(s + " can be broken!");
		}else{
			System.out.println(s + "cannot be broken!");
		}
	}
}
