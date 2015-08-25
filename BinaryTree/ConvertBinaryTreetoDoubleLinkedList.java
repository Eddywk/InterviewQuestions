package BinaryTree;

class ConvertBinaryTreetoDoubleLinkedList {
	
	private static TreeNode prev = null;
	
	public static TreeNode convertBinaryTreeToDLL(TreeNode root){
		setPrevPointer(root);
		return setNextPointer(root);
	}
	
	//In-order traversal
	private static void setPrevPointer(TreeNode root){
		if(root == null){
			return;
		}
		setPrevPointer(root.left);
		root.left = prev;
		prev = root;
		setPrevPointer(root.right);
	}
	
	private static TreeNode setNextPointer(TreeNode root){
		//Find rightmost node in the tree
		while(root != null && root.right != null){
			root = root.right;
		}
		//Append right pointers by traversing left pointers
		TreeNode pre = null;
		while(root != null && root.left != null){
			pre = root;
			root = root.left;
			root.right = pre;
		}
		return root;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode r1 = new TreeNode(5);
		TreeNode l2 = new TreeNode(3);
		TreeNode r2 = new TreeNode(4);
		TreeNode r22 = new TreeNode(6);
		root.left = l1;
		root.right = r1;
		l1.left = l2;
		l1.right = r2;
		r1.left = r22;
		TreeNode head = convertBinaryTreeToDLL(root);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.right;
		}
	}
}
