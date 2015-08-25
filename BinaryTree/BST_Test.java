package BinaryTree;

class BST_Test {
	
	public static BinaryTree treeInit1(){
		BinaryTree tree = new BinaryTree();
		tree.insert(6);
		tree.insert(9);
		tree.insert(7);
		tree.insert(4);
		tree.insert(5);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);		
		tree.print();
		return tree;
	}
	
	public static void deleteTest(BinaryTree tree){
		System.out.println("Delete: 4");
		tree.delete(4);
		tree.print();
		System.out.println("Delete: 7");
		tree.delete(7);
		tree.print();
		System.out.println("Delete: 6");
		tree.delete(6);
		tree.print();
		System.out.println("Delete: 2");
		tree.delete(2);
		tree.print();
		System.out.println("Delete: 5");
		tree.delete(5);
		tree.print();
		System.out.println("Delete: 3");
		tree.delete(3);
		tree.print();
		System.out.println("Delete: 9");
		tree.delete(9);
		tree.print();
		System.out.println("Delete: 1");
		tree.delete(1);
		tree.print();
	}
	
	public static void LCA_Test(BinaryTree tree){
		TreeNode LCA = null;
		LCA = tree.findLCA(3, 5);
		System.out.println("The LCA of 3 and 5 is: "+ LCA.val);
		LCA = tree.findLCA(3, 7);
		System.out.println("The LCA of 3 and 7 is: "+ LCA.val);
		LCA = tree.findLCA(1, 3);
		System.out.println("The LCA of 1 and 3 is: "+ LCA.val);
		LCA = tree.findLCA(2, 9);
		System.out.println("The LCA of 2 and 9 is: "+ LCA.val);
	}
	
	public static void main(String args[]){

		BinaryTree tree = treeInit1();
		LCA_Test(tree);
	}
}
