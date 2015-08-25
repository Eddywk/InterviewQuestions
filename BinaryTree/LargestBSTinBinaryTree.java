package BinaryTree;

class Node{
	Node left;
	Node right;
	int val;
	int min; //minimum value of this subtree
	int max; //maximum value of this subtree
	int num; //number of nodes in this subtree
	int maxBST; //maximum number of BST in this subtree
	
	public Node(int min, int max, int num, int maxBST){
		this.min = min;
		this.max = max;
		this.num = num;
		this.maxBST = maxBST;
	}
	
	public Node(int v){
		this.val = v;
	}
}

class LargestBSTinBinaryTree {
	public static int findLargestBSTinBinaryTree(Node root){
		return findLargestBST(root).maxBST;
	}
	
	private static Node findLargestBST(Node root){
		if(root == null){
			return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
		}
		boolean isBST = true;
		Node leftRoot = findLargestBST(root.left);
		if(leftRoot.maxBST != leftRoot.num || leftRoot.max >= root.val){
			isBST = false;
		}
		Node rightRoot = findLargestBST(root.right);
		if(rightRoot.maxBST == rightRoot.num){
			
		}
		if(rightRoot.maxBST != rightRoot.num || rightRoot.min <= root.val){
			isBST = false;
		}
		root.num = leftRoot.num + rightRoot.num + 1;
		if(isBST){
			root.maxBST = root.num;
		}else{
			root.maxBST = Math.max(leftRoot.maxBST, rightRoot.maxBST);
		}
		root.min = leftRoot.max == Integer.MIN_VALUE ? root.val : Math.min(root.val, leftRoot.max);
		root.max = rightRoot.min == Integer.MAX_VALUE ? root.val : Math.max(root.val, rightRoot.min);
		return root;
	}
	
	public static void main(String[] args){
		Node root = new Node(10);
		Node n11 = new Node(5);
		Node n12 = new Node(15);
		root.left = n11;
		root.right = n12;
		Node n21 = new Node(1);
		Node n22 = new Node(8); n22.left = new Node(4);
		n11.left = n21;
		n11.right = n22;
		Node n23 = new Node(6);
		n12.left = n23;
		Node n31 = new Node(5);
		Node n41 = new Node(4);
		n23.left = n31;
		n31.left = n41;
		
		System.out.println(findLargestBSTinBinaryTree(root));
	}
}
