package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/*	Preorder Traverse for binary tree
 * 	Preorder: Root->Left->Right
 * 	*/

class PreorderTraverse {
	/*Version 0: Using stack, Non-Recursion*/
	ArrayList<Integer> preorderTraverse0(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		
		/*Initialization*/
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(node.val);
			/*Note: This pre-order traverse, so push right child first*/
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
			
		}
		return result;
	}
	
	/*Version 1: Recursion*/
	void traverse(TreeNode root, ArrayList<Integer> result){
		if(root == null) return;
		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}	
	
	ArrayList<Integer> preorderTraverse1(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root , result);
		return result;
	}
	
	/*Version 2:  Divide & Conquer*/
	ArrayList<Integer> preorderTraverse2(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Base case: null or leaf
		if(root == null) return result;
		
		// Divide
		ArrayList<Integer> left = preorderTraverse2(root.left);
		ArrayList<Integer> right = preorderTraverse2(root.right);
		
		// Conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		
		return result;
	}
}
