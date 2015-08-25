package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

class BinaryTree {
	TreeNode root = null;
	
	/*Print all value of nodes by level*/
	public void print(){
		if(this.root == null) return;
		BFSTemplate template = new BFSTemplate();
		ArrayList<ArrayList<Integer>> result = template.levelOrder(this.root);
		for(int i = 0; i < result.size(); i++){
			ArrayList<Integer> level = result.get(i);
			StringBuffer buff = new StringBuffer();
			buff.append("[");
			for(int j = 0; j < level.size(); j++){
				int NodeValue = level.get(j);
				buff.append(NodeValue);
				if(j != level.size() - 1){
					buff.append(", ");
				}
			}
			buff.append("]");
			System.out.println(buff.toString());
		}
		System.out.println("------------------------------------------");
	}
	
	/*Judge if n is a leaf of BST*/
	private boolean isLeaf(TreeNode n){
		if(n.left == null && n.right == null)
			return true;
		else 
			return false;
	}
	
	public TreeNode find(int x){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
			return null;
		else
			stack.push(this.root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			/*Find the node*/
			if(node.val == x){
				return node;
			}
			/*Traverse right sub-tree*/
			else if(node.val < x){
				if(node.right != null){
					stack.push(node.right);
				}else{
					return null;
				}
			}
			/*Traverse left sub-tree*/
			else{
				if(node.left != null){
					stack.push(node.left);
				}else{
					return null;
				}
			}
		}
		return null;
	}
	
	/*Insert a node into this binary search tree*/
	public void insert(int x){
		/*If the tree is empty, insert as root*/
		if(this.root == null){
			this.root = new TreeNode(x);
		}
		/*Error Checking:If a node with same value has already existed.
		 *Binary Search Tree cannot allow two nodes have same key value.*/
		if(find(x) != null){
			return;
		}
		
		TreeNode q = new TreeNode(x);
		TreeNode parent = null;
		TreeNode iterator = this.root;
		/*Find the parent of the node that need to be inserted.*/
		while(iterator != null){
			if(q.val < iterator.val){
				if(iterator.left == null){
					parent = iterator;
					parent.left = q;
					break;
				}else{
					iterator = iterator.left;
				}
			}else{
				if(iterator.right == null){
					parent = iterator;
					parent.right = q;
					break;
				}else{
					iterator = iterator.right;
				}
			}
		}		
		
	}
	
	/*Get the parent of node n*/
	private TreeNode parent(TreeNode n){
		if(n == this.root) return null;
		
		TreeNode iterator = this.root;
		while(iterator != null){
			if(iterator.left == n || iterator.right == n){
				return iterator;
			}
			
			if(iterator.val < n.val){
				iterator = iterator.right;
			}else{
				iterator = iterator.left;
			}
		}
		return null;
	}
	
	private TreeNode findMinInRightSubTree(TreeNode n){
		if(n.left != null && n.right != null){
			TreeNode node = n.right;
			while(node != null){
				if(node.left == null){
					return node;
				}else{
					node = node.left;
				}					
			}
		}
		return null;
	}
	/*Delete the node that its value is x*/
	public void delete(int x){
		TreeNode node = find(x);
		/*The node does not exit*/
		if(node == null) return;
		
		/*Case 1: The node is a leaf*/
		if(isLeaf(node)){
			/*Special case: The node is a leaf and root*/
			if(node == this.root){
				this.root = null;
				return;
			}

			if(parent(node).left == node){
				parent(node).left = null;
			}else{
				parent(node).right = null;
			}
			return;
		}
		
		/*Case 2: The node have both left and right sub-tree*/
		if(node.left != null && node.right != null){
			/*Successor node = the node in the right subtree that has the minimum value*/
			TreeNode successor = findMinInRightSubTree(node);
			/*Store the value that the smallest one that greater the deleted node's value*/
			int val = successor.val;
			/*It's actually like swap the deleted node and successor, then delete it*/
			delete(successor.val);
			node.val = val;
		}
		/*Case 3: The node has only one sub-tree, left-sub-tree or right-sub-tree*/
		else{
			/*Special case: The node is root*/
			if(node == this.root){
				if(node.left != null){
					this.root = node.left;
				}else{
					this.root = node.right;
				}
				return;
			}
			/*The node only has left sub-tree*/
			if(node.left != null){
				if(parent(node).left == node){
					parent(node).left = node.left;
				}else{
					parent(node).right = node.left;
				}
			}
			/*The node only has right sub-tree*/
			else{
				if(parent(node).left == node){
					parent(node).left = node.right;
				}else{
					parent(node).right = node.right;
				}
			}
			return;
		}
		
	}
	
	/*Find Least Common Ancestor(LCA)*/
	public TreeNode findLCA(int x, int y){
		TreeNode n1 = find(x);
		TreeNode n2 = find(y);
		if(n1 == null || n2 == null){
			return null;
		}
		return getAncestor(this.root, n1, n2);
	}
	
	private TreeNode getAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null || n1 == root || n2 == root) return root;
		
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
}
