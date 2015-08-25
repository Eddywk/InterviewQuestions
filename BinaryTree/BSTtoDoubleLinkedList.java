package BinaryTree;

class BSTNode{
	BSTNode left;
	BSTNode right;
	BSTNode minNode;
	BSTNode maxNode;
	int val;
	
	public BSTNode(int v){
		this.val = v;
	}
}

class BSTtoDoubleLinkedList {
	public static BSTNode convertBSTtoDoubleLinkedList(BSTNode root){
		if(root == null){
			return root;
		}
		BSTNode head = root;
		while(head.left != null){
			head = head.left;
		}
		inOrder(root);
		return head;
	}
	
	private static BSTNode inOrder(BSTNode root){
		if(root == null){
			return root;
		}
		BSTNode left = inOrder(root.left);
		if(left != null){
			left.maxNode.right = root;
			root.left = left.maxNode;
			root.minNode = left.minNode;
		}else{
			root.minNode = root;
		}
		BSTNode right = inOrder(root.right);
		if(right != null){
			root.right = right.minNode;
			right.minNode.left = root;
			root.maxNode = right.maxNode;
		}else{
			root.maxNode = root;
		}
		return root;
	}
	
	public static void main(String[] args){
		BSTNode root = new BSTNode(10);
		BSTNode n7 = new BSTNode(7);
		BSTNode n14 = new BSTNode(14);
		BSTNode n3 = new BSTNode(3);
		BSTNode n8 = new BSTNode(8);
		BSTNode n9 = new BSTNode(9);
		BSTNode n11 = new BSTNode(11);
		BSTNode n15 = new BSTNode(15);
		BSTNode n16 = new BSTNode(16);
		root.left = n7; root.right = n14;
		n7.left = n3; n7.right = n8;
		n8.right = n9;
		n14.left = n11; n14.right = n15;
		n15.right = n16;
		
		BSTNode head = convertBSTtoDoubleLinkedList(root);
		while(head != null && head.right != null){
			System.out.print(head.val + " ");
			head = head.right;
		}
		System.out.print(head.val);
		System.out.println();
		while(head != null){
			System.out.print(head.val + " ");
			head = head.left;
		}
	}
}
