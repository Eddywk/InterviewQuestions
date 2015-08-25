package Design;

import java.util.Stack;

class BSTIterator {
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) throws Exception{
		this.stack = new Stack<TreeNode>();
		pushNext(root);
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public TreeNode next() throws Exception {
		TreeNode node = stack.pop();
		if(node.right != null){
			pushNext(node.right);
		}
		return node;
	}
	
	private void pushNext(TreeNode node) throws Exception{
		if(node == null){
			throw new Exception("Null Pointer Exception!");
		}
		stack.push(node);
		TreeNode left = node.left;
		while(left != null){
			stack.push(left);
			left = left.left;
		}
	}
}
