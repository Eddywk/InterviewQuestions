package BinaryTree;

import java.util.Stack;

/*input:  a ? b ? c : d : e ? f : g
 *output: 
 *				a
 *			   / \
 *			  b   e
 *			 / \ / \
 *			c  d f  g*/
class TernarytoBinaryTree {
	public static TreeNode buildBinaryTree(String s){
		return build(s, 0, s.length() - 1);
	}
	
	private static TreeNode build(String s, int start, int end){
		if(start > end){
			return null;
		}
		TreeNode root = new TreeNode(s.charAt(start));
		if(start == end){
			return root;
		}	
		Stack<Integer> stack = new Stack<Integer>();
		int pos = 0;
		for(int i = start + 1; i <= end; i++){
			char c = s.charAt(i);
			if(c == '?'){
				stack.push(i);
			}else if(c == ':'){
				stack.pop();
				if(stack.isEmpty()){
					pos = i;
					break;
				}
			}
		}
		root.left = build(s, start + 2, pos - 1);
		root.right = build(s, pos + 1, end);
		return root;
	}
	
	public static void main(String args[]){
		String s = "a?b?c:d:e?f:g";
		String s1 = "a?b?c?d:e:f?g:h:m";
		TreeNode root = buildBinaryTree(s1);
		root.printByLevel();
	}
}
