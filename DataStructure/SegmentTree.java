package DataStructure;

public class SegmentTree {
	SegmentTreeNode root;
	int left_boundry;
	int right_boundry;
	
	public SegmentTree(int left, int right, int val){
		root = new SegmentTreeNode(left, right, val);
		this.left_boundry = left;
		this.right_boundry = right;
	}
	
	public void insert(int left, int right, int val){
		if(left > right || left < this.left_boundry || right > this.right_boundry){
			return;
		}
		root.insert(left, right, val);
	}
	
	public int search(int id){
		if(id < this.left_boundry || id > this.right_boundry){
			return Integer.MIN_VALUE;
		}
		SegmentTreeNode node = root;
		while(node != null){
			if(node.start <= id && id <= node.end){
				return node.val;
			}else if(id < node.start){
				node = node.left;
			}else{
				node = node.right;
			}
		}
		return Integer.MIN_VALUE;
	}
}
