package DynamicProgramming;

import java.util.ArrayList;

class PalindromePartitioning {
	/*Given a string s, partition s such that every substring of the partition is a palindrome.
	  Return all possible palindrome partitioning of s.

	  For example, given s = "aab",
	  Return
	    [
		    ["aa","b"],
		    ["a","a","b"]
		]*/
	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(s == null || s.length() == 0){
			return result;
		}
		ArrayList<String> path = new ArrayList<String>();
		helper(s, path, 0, result);
		return result;
	}
	
	private static void helper(String s, ArrayList<String> path, int pos, ArrayList<ArrayList<String>> result){
		/*If we finished traverse all substring in given range pos to end of s,
		 *then we add path to result*/
		if(pos == s.length()){
			result.add(new ArrayList<String>(path));
			return;
		}
		/*Recursion: "aab" (pos, i)
		 *First level: (0, 1) = a, (0, 2) = aa, (0, 3) = aab ~ [0-3]
		 *Second level: (1, 2) = a, (1, 3) = ab ~ [1-3]
		 *Third level: (2, 3) = b ~ [2-3]
		 *Each recursion traverses substring [*[substring]]*/
		for(int i = pos + 1; i <= s.length(); i++){
			String prefix = s.substring(pos, i);
			/*If substring is palindrome, then add it to path*/
			if(isPalindrome(prefix)){
	            path.add(prefix);
	            /*Traverses substring [*[substring]]*/
	            helper(s, path, i, result);
	            /*Clear up level one by one after path was added into result*/
	            path.remove(path.size() - 1);
			}
		}
	}
	
	private static boolean isPalindrome(String s){
		for(int start = 0, end = s.length() - 1; start < end; start++, end--){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
		}
		return true;
	}
	
	private static void print(ArrayList<ArrayList<String>> result){
		for(int i = 0; i < result.size(); i++){
			ArrayList<String> level = result.get(i);
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < level.size(); j++){
				String palindrome = level.get(j);
				sb.append(palindrome + " ");
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void main(String args[]){
		String s1 = "aab";
		ArrayList<ArrayList<String>> res = partition(s1);
		print(res);
	}
}
