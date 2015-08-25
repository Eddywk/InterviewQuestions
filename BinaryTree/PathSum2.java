package BinaryTree;

import java.util.ArrayList;
/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
  For example:
  Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]*/
class PathSum2 {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(root, result, path, 0, sum);
		return result;
	}
	
	private void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, 
			ArrayList<Integer> path, int total, int sum){
		if(root == null){
			return;
		}
		total += root.val;
		path.add(root.val);
		if(total == sum && root.left == null && root.right == null){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		if(root.left != null){
			helper(root.left, result, path, total, sum);
			path.remove(path.size() - 1);
		}
		if(root.right != null){
			helper(root.right, result, path, total, sum);
			path.remove(path.size() - 1);
		}
	}
}
