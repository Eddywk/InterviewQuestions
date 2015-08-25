package BinaryTree;

import java.util.ArrayList;

class LongestPath {
	public static ArrayList<TreeNode> findLongestPath(TreeNode root){
		if(root == null){
			return null;
		}
		return getLongestPath(root);
	}
	
	private static ArrayList<TreeNode> getLongestPath(TreeNode root){
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if(root == null){
			return result;
		}
		ArrayList<TreeNode> left = getLongestPath(root.left);
		ArrayList<TreeNode> right = getLongestPath(root.right);
		
		result.add(root);
		if(left.size() >= right.size()){
			result.addAll(left);
		}else{
			result.addAll(right);
		}
		return result;
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
		ArrayList<TreeNode> path = findLongestPath(root1);
		for(TreeNode node : path){
			System.out.print(node.val + " ");
		}
	}
}
