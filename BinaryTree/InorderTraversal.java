package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

class InorderTraversal {
	/*Version1: Recursion*/
	public ArrayList<Integer> inorderTraversal1(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		
		ArrayList<Integer> left = inorderTraversal1(root.left);
		ArrayList<Integer> right = inorderTraversal1(root.right);
		
		result.addAll(left);
		result.add(root.val);
		result.addAll(right);
		
		return result;
	}
	
	/*Version2: Traversal*/
	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null){
			/*Keep pushing left children*/
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}else{
				/*No left child was found, add current root value into result,
				 *then push right child*/
				curr = stack.pop();
				result.add(curr.val);
				curr = curr.right;
			}
		}
		return result;
	}
}
