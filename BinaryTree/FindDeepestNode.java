package BinaryTree;

class Result{
	TreeNode res = null;
	int level = 0;
}

class FindDeepestNode {
	public TreeNode findDeepestNode(TreeNode root){
		if(root == null){
			return null;
		}
		Result result = maxDepth(root);
		return result.res;
	}
	
	private Result maxDepth(TreeNode root){
		if(root == null){
			return new Result();
		}
		Result left = maxDepth(root.left);
		Result right = maxDepth(root.right);
		Result result = left.level < right.level ? right : left;
		result.level++;
		if(result.res == null){
			result.res = root;
		}
		return result;
	}
}
