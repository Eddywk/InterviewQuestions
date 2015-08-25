package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BFSTemplate {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList result = new ArrayList();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = q.size();
			for(int i = 0; i < size; i++){
				TreeNode cur = q.poll();
				level.add(cur.val);
				if(cur.left != null){
					q.add(cur.left);
				}
				if(cur.right != null){
					q.add(cur.right);
				}
			}
			result.add(level);
		}
		
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
		ArrayList result = new ArrayList();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
		
		while(!q.isEmpty()){
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = q.size();
			for(int i = 0; i < size; i++){
				TreeNode cur = q.poll();
				level.add(cur.val);
				if(cur.left != null){
					q.add(cur.left);
				}
				if(cur.right != null){
					q.add(cur.right);
				}
			}
			stack.add(level);
		}
		
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
		
		return result;
	}
}
