package BinaryTree;

import java.util.ArrayList;

class FirstCommonAncestor {
	
	/*Version 1: Using DFS traversal*/
	public static TreeNode findFirstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null || n1 == null || n2 == null){
			return null;
		}
		return getAncestor(root, n1, n2);
	}
	
	/*DFS*/
	private static TreeNode getAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null || n1 == root || n2 == root) 
			return root;
		
		/*Divide*/
		TreeNode left = getAncestor(root.left, n1, n2);
		TreeNode right = getAncestor(root.right, n1, n2);
		
		/*Conquer*/
		if(left != null && right != null){
			return root;
		}
		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}
		return null;
	}
	
	/*Version 2: Print each path and compare to find first common element*/
	public static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2){
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		if(!getPath(root, node1, path1) || !getPath(root, node2, path2)){
			return null;
		}
		int i;
        for(i = 0; i < Math.min(path1.size(), path2.size()); i++){
            if(path1.get(i).val != path2.get(i).val){
                break;
            }
        }
        return path1.get(i - 1);
	}
	
	private static boolean getPath(TreeNode root, TreeNode target, ArrayList<TreeNode> path){
		if(root == null){
			return false;
		}
		if(root == target){
			path.add(root);
			return true;
		}
		path.add(root);
		if(getPath(root.left, target, path)){
			//path.add(root.left);
			return true;
		}
		if(getPath(root.right, target, path)){
			//path.add(root.right);
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}
	
	/*Version 3: For BST*/
	public TreeNode findLCAinBST(TreeNode root, TreeNode n1, TreeNode n2){
		TreeNode left = n1.val < n2.val ? n1 : n2;
		TreeNode right = n1.val < n2.val ? n2 : n1;
		while(true){
			if(root.val > left.val && root.val < right.val){
				return root;
			}else if(root.val < left.val){
				root = root.right;
			}else if(root.val > right.val){
				root = root.left;
			}else{
				return root;
			}
		}
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
//		System.out.println(findFirstCommonAncestor(root1, n1, n3).val);
//		System.out.println(findLCA(root1, n4, n3).val);
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		getPath(root1, n1, path);
		for(TreeNode node : path){
			System.out.print(node.val + " ");
		}
	}
}
