package BinaryTree;

class CountLeaves {
	public static int countLeaves(TreeNode root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		int left = 0, right = 0;
//		if(root.left != null){
			left = countLeaves(root.left);
//		}
//		if(root.right != null){
			right = countLeaves(root.right); 
//		}
		return left + right;
	}
	
	public static void main(String args[]){
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(1);
		TreeNode n1 = root1.right = new TreeNode(5);
		TreeNode n3 = root1.right.right = new TreeNode(8);
		TreeNode n2 = new TreeNode(7);
		n1.left = n2;
		TreeNode n4 = new TreeNode(9);
		root1.left.left = n4;
		TreeNode n5 = new TreeNode(11);
		n2.left = n5;
		TreeNode n6 = new TreeNode(4);
		n4.right = n6;
		TreeNode n7 = new TreeNode(2);
		n2.right = n7;
		System.out.print(countLeaves(root1));
	}
}
