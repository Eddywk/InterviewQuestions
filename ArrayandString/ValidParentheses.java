package ArrayandString;

import java.util.Stack;
//() -> valid
//()[]{} -> valid
//{[()]} -> valid
//( -> invalid
//) -> invalid
//[]} -> invalid
//({)} -> invalid
//int main () {} -> valid
//int main -> valid
class ValidParentheses {
	public boolean isValid(String input){
	    if(input == null || input.length() <= 1){
	        return false;
	    }
	    Stack<Character> stack = new Stack<Character>();
	    for(int i = 0; i < input.length(); i++){
	        char c = input.charAt(i);
	        if(c == '(' || c == '[' || c == '{'){
	            stack.push(c);
	        }else if(c == ')' || c == ']' || c == '}'){
	           if(!stack.isEmpty()){
	                char left = stack.peek();
	                if(c == ')' && left != '('){
	                    return false;
	                }
	                if(c == ']' && left != ']'){
	                    return false;
	                }
	                if(c == '}' && left != '}'){
	                    return false;
	                }
	                stack.pop();
	            }else{
	                return false;
	            }
	        }
	        
	    }
	    return stack.isEmpty();
	}
}
