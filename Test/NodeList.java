package Test;

import java.util.ArrayList;

class NodeList extends ArrayList implements Comparable<NodeList>{

	int val;
	public NodeList(int v){
		this.val = v;
	}
	@Override
	public int compareTo(NodeList o) {
		// TODO Auto-generated method stub
		return o.val - this.val;
	}

}
