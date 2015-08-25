package GraphSearch;

import java.util.ArrayList;
/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  For example, given n = 3, a solution set is:
  "((()))", "(()())", "(())()", "()(())", "()()()"*/
class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if(n <= 0){
			return result;
		}
		char[] str = new char[n * 2];
		helper(result, str, 0, 0, 0);
		return result;
	}
	
	/*left is number of '(', right is number of ')', count is number of char*/
	private void helper(ArrayList<String> result, char[] str, int left, int right, int count){
		/*Invalid state*/
		if(left > str.length / 2 || right > left){
			return;
		}
		/*Add result*/
		if(left == str.length / 2 && right == str.length / 2){
			String s = String.copyValueOf(str);
			result.add(s);
			return;
		}
		/*Adding left parentheses*/
		if(left < str.length / 2){
			str[count] = '(';
			helper(result, str, left + 1, right, count + 1);
		}
		/*Adding right parentheses*/
		if(right < left){
			str[count] = ')';
			helper(result, str, left, right + 1, count + 1);
		}
	}
}
