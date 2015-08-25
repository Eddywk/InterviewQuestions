package BinaryTree;

class BSTSuccessor {
	public TreeNode getSuccessor(TreeNode root, TreeNode node){
		if(node.right != null){
			TreeNode cur = node.right;
			while(cur.left != null){
				cur = cur.left;
			}
			return cur;
		}
		TreeNode successor = null;
		while(root != null){
			if(root.val > node.val){
				successor = root;
				root = root.left;
			}else if(root.val < node.val){
				root = root.right;
			}else{
				break;
			}
		}
		return successor;
	}
}
