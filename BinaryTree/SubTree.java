package BinaryTree;
/*You have two very large binary trees: T1, with million of nodes, and T2,
 *with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.*/
class SubTree {
	public boolean containsTree(TreeNode r1, TreeNode r2){
		if(r2 == null){
			return true;
		}
		return isSubTree(r1, r2);
	}
	
	private boolean isSubTree(TreeNode r1, TreeNode r2){
		if(r1 == null){
			return false;
		}
		/*Find a node in T1 that has same value as T2.value*/
		if(r1.val == r2.val){
			/*Check the subtree of T1 whose root is this node is same
			 *with T2*/
			if(match(r1, r2)){
				return true;
			}
		}
		/*Keep traversing*/
		return isSubTree(r1.left, r2) || isSubTree(r1.right, r2);
	}
	
	/*Return true if two trees are same.*/
	private boolean match(TreeNode r1, TreeNode r2){
		/*Base Case: Reach all nodes in these two trees*/
		if(r1 == null && r2 == null){
			return true;
		}
		/*Only one reach all nodes, another not*/
		if(r1 == null || r2 == null){
			return false;
		}
		/*Found different node*/
		if(r1.val != r2.val){
			return false;
		}
		/*Keep testing left subtrees and right one of these two trees*/
		return match(r1.left, r2.left) && match(r1.right, r2.right);
	}
}
