package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
/*Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and 
 *reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
  There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and 
  deserialize this string to the original structure.
	Example
	An example of testdata: Binary tree {3,9,20,#,#,15,7},  denote the following structure:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
  Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
  You can use other method to do serializaiton and deserialization.*/
class SerializationandDeserializationOfBinaryTree {
    public static String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.val == Integer.MIN_VALUE){
                    sb.append('#').append(',');
                    continue;
                }else{
                    sb.append(cur.val).append(',');
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }else{
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }else{
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                }
            }
        }
        /*Trim unneeded tail of string*/
        for(int i = sb.length() - 1; i >= 0; i--){
            if(sb.charAt(i) == '#' || sb.charAt(i) == ','){
                continue;
            }else{
                sb.setLength(i + 1);
                break;
            }
        }
        return sb.toString();
    }
       
    public TreeNode deserialize(String data) {
        // write your code here
        TreeNode root;
        String[] nodes;
        if(data == null || data.length() == 0 || data.charAt(0) == '#'){
            return null;
        }else{
            nodes = data.split(",");
        }
        root = new TreeNode(Integer.parseInt(nodes[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty() && i < nodes.length){
            TreeNode node = queue.poll();
            if(i < nodes.length){
	            String left = nodes[i++];
	            if(left.equals("#")){
	                node.left = null;
	            }else{
	                node.left = new TreeNode(Integer.parseInt(left));
	                queue.add(node.left);
	            }
            }
            /*Avoid out of boundary*/
            if(i < nodes.length){
	            String right = nodes[i++];
	            if(right.equals("#")){
	                node.right = null;
	            }else{
	                node.right = new TreeNode(Integer.parseInt(right));
	                queue.add(node.right);
	            }   
            }
        }
        return root;
    }
    
    public static void main(String args[]){
    	String data = "1,#,2";
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(3);
    	root.left.left.left = new TreeNode(4);
    	System.out.println(serialize(root));
    }
}
