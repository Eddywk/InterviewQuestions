package DataStructure;

import java.util.Stack;
/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
class ValidParentheses {
	public boolean isValid(String s) {
		/*Basic error checking*/
		if(s == null || s.length() == 0 || s.length() % 2 != 0){
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for(int i = 1; i < s.length(); i++){
			char cur = s.charAt(i);
			/*Push '(', '[' and '{' into stack*/
			if(cur == '(' || cur == '[' || cur == '{'){
				stack.push(cur);
				continue;
			}
			char out = stack.pop();
			/*Compare left parentheses with right one, check if they are a pair*/
			if(out != '(' && cur == ')'){
				return false;
			}
			if(out != '[' && cur == ']'){
				return false;
			}
			if(out != '{' && cur == '}'){
				return false;
			}
		}
		/*Some inputs may like ((((*/
		if(stack.size() != 0){
			return false;
		}
		return true;
	}
}
