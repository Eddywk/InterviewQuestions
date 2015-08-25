package BinaryTree;

import java.util.ArrayList;

/*You are given a binary tree in which each node contains a value.
 *Design an algorithm to print all paths which sum to a given value.
 *The path does not need to start or end at root or leaf.*/
class PathSum3 {
	public ArrayList<ArrayList<Integer>> findAllPathSum(TreeNode root, int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(root, result, path, sum);
		return result;
	}
	
	private void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int sum){
		if(root == null){
			return;
		}
		path.add(root.val);
		int total = 0;
		/*Find the path ended at current node which total equals to sum*/
		for(int i = path.size(); i >= 0; i--){
			total += path.get(i);
			if(total == sum){
				result.add(cutPath(path, i));
			}
		}
		if(root.left != null){
			helper(root.left, result, path, sum);
			path.remove(path.size() - 1);
		}
		if(root.right != null){
			helper(root.right, result, path, sum);
			path.remove(path.size() - 1);
		}
	}
	
	private ArrayList<Integer> cutPath(ArrayList<Integer> path, int start){
		ArrayList<Integer> subpath = new ArrayList<Integer>();
		for(int i = path.size() - 1; i >= start; i--){
			subpath.add(path.get(i));
		}
		return subpath;
	}
}
