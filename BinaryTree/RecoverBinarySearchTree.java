package BinaryTree;
/*Two elements of a binary search tree (BST) are swapped by mistake.
  Recover the tree without changing its structure.
	Note:
	A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?*/
class RecoverBinarySearchTree {
	/*Idea: Using in-order traverse, then current element must smaller than 
	 *previous one, if not, we find mistake node.*/
    TreeNode first = null;
    TreeNode second = null;
    TreeNode last = new TreeNode(Integer.MIN_VALUE);
	
	public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
	}
	
    private void inorderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraverse(root.left);
        /*root.val < last.val found mistake node*/
        if(first == null && root.val < last.val){
            first = last;
        }
        if(first != null && root.val < last.val){
            second = root;
        }
        last = root;       
        inorderTraverse(root.right);
    }
}
