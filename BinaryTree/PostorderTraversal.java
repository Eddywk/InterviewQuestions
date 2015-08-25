package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;
/*Given a binary tree, return the postorder traversal of its nodes' values.
  For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].
  Note: Recursive solution is trivial, could you do it iteratively?*/
class PostorderTraversal {
	/*Version1: Recursion*/
	public ArrayList<Integer> postorderTraversal1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		ArrayList<Integer> left = postorderTraversal1(root.left);
	    ArrayList<Integer> right = postorderTraversal1(root.right);
	    result.addAll(left);
	    result.addAll(right);
	    result.add(root.val);
		return result;
	}
	
	/*Version2: Traversal*/
	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		TreeNode curr = root;
		TreeNode prev = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			curr = stack.peek();
			/*Going deep of the binary tree*/
			if(prev == null || prev.left == curr || prev.right == curr){
				if(curr.left != null){
					stack.push(curr.left);
				}else if(curr.right != null){
					stack.push(curr.right);
				}
			}
			/*Traverse right sub-tree of parent*/
			else if(curr.left == prev){
				if(curr.right != null){
					stack.push(curr.right);
				}
			}
			/*No leaf was found*/
			else{
				result.add(curr.val);
				stack.pop();
			}
			prev = curr;
		}
		
		return result;
	}
}
