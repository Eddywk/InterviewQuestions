package BinaryTree;

import java.util.Stack;

public class BSTIterator {
	
    private Stack<TreeNode> stack;
    TreeNode cur = null;
    
    public BSTIterator(TreeNode root){
        stack = new Stack<TreeNode>();
        cur = root;
        add(root);
    }
	
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode res = stack.pop();
        add(res.right);
        return res;
    }
    
    private void add(TreeNode node){
        if(node == null){
            return;
        }
        stack.push(node);
        TreeNode left = node.left;
        while(left != null){
            stack.push(left);
            left = left.left;
        }
    }
}
