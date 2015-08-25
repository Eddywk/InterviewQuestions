package BinaryTree;
/*Given a binary tree, determine if it is height-balanced.
  For this problem, a height-balanced binary tree is defined as a binary tree in which 
  the depth of the two subtrees of every node never differ by more than 1.*/
class BalancedBinaryTree {
	/*Idea: If a binary tree is balanced, then all its sub-trees are balanced.
	 *Check two tree are balanced or not, we just need to check their difference of max depth is 
	 *greater than 1 or not.*/
	public boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		return maxDepth(root) != -1;
	}
	
	private int maxDepth(TreeNode root){
		/*Base Case*/
		if(root == null){
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		/*Avoid duplicated computation*/
		if(left == -1 || right == -1 || Math.abs(left - right) > 1){
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}
}
