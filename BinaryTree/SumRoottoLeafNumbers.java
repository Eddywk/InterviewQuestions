package BinaryTree;

import java.util.ArrayList;
/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
  An example is the root-to-leaf path 1->2->3 which represents the number 123.
  Find the total sum of all root-to-leaf numbers.
	For example,
	
	    1
	   / \
	  2   3
  The root-to-leaf path 1->2 represents the number 12.
  The root-to-leaf path 1->3 represents the number 13.
  Return the sum = 12 + 13 = 25.*/
class SumRoottoLeafNumbers {
	public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, list, sets);
        int result = 0;
        for(int i = 0; i < sets.size(); i++){
            result += parseSum(sets.get(i));
        }
        return result;
	}
	
    private static void helper(TreeNode root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> sets){
        list.add(root.val);
        if(root.left == null && root.right == null){
            sets.add(new ArrayList<Integer>(list));
            return;
        }
        if(root.left != null){
            helper(root.left, list, sets);
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            helper(root.right, list, sets);
            list.remove(list.size() - 1);
        }
    }
    
    private static int parseSum(ArrayList<Integer> numbers){
        int sum = 0;
        for(int i = 0; i  < numbers.size(); i++){
            sum += numbers.get(i) * Math.pow(10, numbers.size() - i - 1);
        }
        return sum;
    }
    
    public static void main(String args[]){
    	TreeNode root = new TreeNode(0);
    	TreeNode left = new TreeNode(1);
    	root.left = left;
    	System.out.println(sumNumbers(root));
    }
}
