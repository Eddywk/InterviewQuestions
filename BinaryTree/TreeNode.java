package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*Definition for binary tree*/
public class TreeNode {
	public char ch;
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x){
		this.val = x;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(char c){
		this.ch = c;
		this.left = null;
		this.right = null;		
	}
	
	public void printByLevel(){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				System.out.print(node.ch + " ");
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			System.out.println();
		}
	}
}
