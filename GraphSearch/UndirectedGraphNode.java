package GraphSearch;

import java.util.ArrayList;
import java.util.List;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	UndirectedGraphNode(int x) { 
		label = x; 
		this.neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
