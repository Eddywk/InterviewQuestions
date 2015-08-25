package DataStructure;

import java.util.Stack;
/*Given an absolute path for a file (Unix-style), simplify it.
	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	click to show corner cases.
  Corner Cases:
	Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".*/
class SimplifyPath {
	public static String simplifyPath(String path) {
		if(path == null || path.length() == 0){
			return "";
		}
		String result = "";
		String[] sec = path.split("/");
		Stack stack = new Stack<String>();
		for(String s : sec){
			if(s.equals("..")){
				if(stack.size() > 0){
					stack.pop();
				}else{
					continue;
				}
			}else if(s.equals(".") || s.length() == 0){
				continue;
			}else{
				stack.push(s);
			}
		}
		if(stack.size() == 0){
			return "/";
		}
		Stack stack2 = new Stack<String>();
		while(!stack.isEmpty()){
			stack2.push(stack.pop());
		}
		while(!stack2.isEmpty()){
			result += "/";
			result += stack2.pop();
		}
		return result;
	}
	
	public static void main(String args[]){
		String path = "/home//foo/";
		System.out.println(simplifyPath(path));
	}
}
