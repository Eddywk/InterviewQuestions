package BinaryTree;

class ListNode{
	int val;
	ListNode next;
	public ListNode(int v){val = v; next = null;}
}

class ConvertToLinkedListByInOrder {
	
	static ListNode head = null;
	
	public static ListNode convertToLinkedList(TreeNode root){
		if(root == null){
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = null;
		dummy.next = tail;
		tail = dummy;
		head = tail;
		helper(root);
		return dummy.next;
	}
	
	private static void helper(TreeNode root){
		if(root == null){
			return;
		}
		helper(root.left);
		head.next = new ListNode(root.val);
		head = head.next;
		helper(root.right);
	}
	
	public static void print(TreeNode root){
		if(root == null){
			return;
		}
		print(root.left);
		System.out.print(root.val + " ");
		print(root.right);
	}
	
	public static void main(String args[]){
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
		ListNode head = convertToLinkedList(root);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
//		print(root);
	}
}
