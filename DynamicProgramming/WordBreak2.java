package DynamicProgramming;

import java.util.ArrayList;
import java.util.Set;
/*Given a string s and a dictionary of words dict, 
 *add spaces in s to construct a sentence where each word is a valid dictionary word.
  Return all such possible sentences.
	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].
  A solution is ["cats and dog", "cat sand dog"].*/
class WordBreak2 {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if(s == null || s.length() == 0){
			return result;
		}
		/*If the string cannot be broken, then return empty result,
		 *here is where dp works*/
		if(!canBreak(s, dict)){
			return result;
		}
		StringBuilder sb = new StringBuilder();
		/*Using DFS find all results*/
		helper(result, sb, s, dict, 0);
		return result;
	}
	
	/*Check string can be broken or not*/
	private boolean canBreak(String s, Set<String> dict){
		/*can[i] means first i characters can be broken.*/
		boolean[] can = new boolean[s.length() + 1];
		can[0] = true;
		int maxLen = 0;
		for(String word : dict){
			maxLen = Math.max(maxLen, word.length());
		}
		for(int i = 1; i <= s.length(); i++){
			can[i] = false;
			/*If first i characters is a word in dict, return true.*/
			if(i <= maxLen && dict.contains(s.substring(0, i))){
				can[i] = true;
				continue;
			}
			/*Check if [j, i) can be broken or not*/
			for(int j = 0; j < i; j++){
				if(can[j] && dict.contains(s.substring(j, i))){
					can[i] = true;
					break;
				}
			}
		}
		return can[s.length()];
	}
	
	/*DFS*/
	private void helper(ArrayList<String> result, StringBuilder sb, String s, Set<String> dict, int pos){
		if(pos == s.length()){
			result.add(new String(sb));
			return;
		}
		for(int i = pos + 1; i <= s.length(); i++){
			String word = s.substring(pos, i);
			int lastLen = sb.length();
			if(dict.contains(word)){
				if(lastLen != 0){
					sb.append(" ");
				}
				sb.append(word);
				helper(result, sb, s, dict, i);
				sb.delete(lastLen, sb.length());
			}
		}
	}
}
