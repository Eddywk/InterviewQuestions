package DataStructure;

public class SegmentTreeNode {
	int start;
	int end;
	int val;
	public SegmentTreeNode left;
	public SegmentTreeNode right;
	
	public SegmentTreeNode(int l, int r, int v){
		this.start = l;
		this.end = r;
		this.val = v;
	}
	
	public void set(int l, int r){
		this.start = l;
		this.end = r;
	}
	
	public void set(int l, int r, int v){
		this.start = l;
		this.end = r;
		this.val = v;
	}
	
	public void set(int v){
		this.val = v;
	}
	
	public void insert(int s, int e, int v){
		//Full overlap
		if(s == start && e == end){
			this.val += v;
			return;
		}
		//this node contains inserted segment
		if(start < s && e < end){
			if(this.left == null){
				this.left = new SegmentTreeNode(this.start, s - 1, this.val);
			}else{
				SegmentTreeNode prev = this.left;
				this.left = new SegmentTreeNode(this.start, s - 1, this.val);
				this.left.left = prev;
			}
			if(this.right == null){
				this.right = new SegmentTreeNode(e + 1, this.end, this.val);
			}else{
				SegmentTreeNode prev = this.right;
				this.right = new SegmentTreeNode(e + 1, this.end, this.val);
				this.right.right = prev;
			}
			this.set(s, e, this.val + v);
		}
		//this node was contained by inserted segment
		else if(s < start && end < e){
			this.left.insert(s, this.start - 1, v);
			this.right.insert(this.end + 1, e, v);
			this.set(this.val + v);
		}
		//left-overlap
		else if(s < start && start < e){
			if(this.left == null){
				this.left = new SegmentTreeNode(s, this.start - 1, v);
			}else{
				this.left.insert(s, this.start - 1, v);
			}
			if(this.right == null){
				this.right = new SegmentTreeNode(e + 1, this.end, v);
			}else{
				this.right.insert(e + 1, this.end, v);
			}
			this.set(this.start, e, this.val + v);
		}
		//right-overlap		
		else if(s < end && end < e){
			if(this.right == null){
				this.right = new SegmentTreeNode(this.end + 1, e, v);
			}else{
				this.right.insert(this.end + 1, e, v);
			}
			if(this.left == null){
				this.left = new SegmentTreeNode(this.start, s - 1, this.val);
			}else{
				this.left.insert(this.start, s - 1, this.val);
			}
			this.set(s, this.end, this.val + v);
		}
		//Edge case: left-edge overlap
		else if(start == s && e < end){
			if(this.right == null){
				this.right = new SegmentTreeNode(e + 1, this.end, this.val);
			}else{
				this.right.insert(e + 1, this.end, this.val);
			}
			this.set(s, e, this.val + v);
		}
		//Edge case: right-edge overlap
		else if(start < s && e == end){
			if(this.left == null){
				this.left = new SegmentTreeNode(this.start, s - 1, this.val);
			}else{
				this.left.insert(this.start, s - 1, this.val);
			}
			this.set(s, e, this.val + v);
		}
	}
}
