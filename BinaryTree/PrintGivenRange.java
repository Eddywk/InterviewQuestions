package BinaryTree;

/*Given two value k1 and k2(where k1 < k2) and a root pointer to
 *a Binary Search Tree. Print all the keys of tree in range k1 to
 *k2.
 *Example: k1 = 10 and k2 = 25
 *				20
 *			   /  \
 *			  8    22
 *			 / \
 *			4  12
 *Result: 12 20 22*/
class PrintGivenRange {
	public static TreeNode testcase1(){
		TreeNode root = new TreeNode(20);
		TreeNode left1 = new TreeNode(8);
		TreeNode right1 = new TreeNode(22);
		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(12);
		root.left = left1;
		root.right = right1;
		left1.left = left2;
		left1.right = right2;
		return root;
	}
	
	public static void printRange(TreeNode root, int k1, int k2){
		if(root == null) return;
		if(root.val < k1){
			printRange(root.right, k1, k2);
		}
		if(k1 <= root.val && root.val <= k2){
			System.out.println(root.val);
			printRange(root.left, k1, root.val);
			printRange(root.right, root.val, k2);
		}
		if(root.val > k2){
			printRange(root.left, k1, k2);
		}
	}
	
	public static void main(String args[]){
		TreeNode root = testcase1();
		printRange(root, 10, 25);
	}
}
