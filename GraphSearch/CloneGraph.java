package GraphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class CloneGraph {
	/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
		OJ's undirected graph serialization:
		Nodes are labeled uniquely.
		
		We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
		As an example, consider the serialized graph {0,1,2#1,2#2,2}.
		
		The graph has a total of three nodes, and therefore contains three parts as separated by #.
		
		First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
		Second node is labeled as 1. Connect node 1 to node 2.
		Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
		Visually, the graph looks like the following:
		
		       1
		      / \
		     /   \
		    0 --- 2
		         / \
		         \_/*/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        /*Using HashMap to store the relationship between old nodes and new nodes*/
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        /*nodes store the list of old nodes*/
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        /*Using queue to finish BFS*/
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        /*Add head into queue*/
        queue.offer(node);
        
        /*Traverse whole graph, by the way clone nodes*/
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            /*Avoid adding duplicated nodes*/
            if(!nodes.contains(cur)){
                nodes.add(cur);
                UndirectedGraphNode newNode = new UndirectedGraphNode(cur.label);
                map.put(cur, newNode);
            }
            for(int i = 0; i < cur.neighbors.size(); i++){
            	/*Avoid adding duplicated nodes*/
                if(!nodes.contains(cur.neighbors.get(i))){
                     queue.offer(cur.neighbors.get(i));
                }
            }
        }
        
        /*clone neighbors*/
        for(int i = 0; i < nodes.size(); i++){
            UndirectedGraphNode old = nodes.get(i);
            UndirectedGraphNode newNode = map.get(old);
            for(int j = 0; j < old.neighbors.size(); j++){
                UndirectedGraphNode oldCur = old.neighbors.get(j);
                UndirectedGraphNode newCur = map.get(oldCur);
                newNode.neighbors.add(newCur);
            }
        }
        
        /*Return new head*/
        return map.get(node);
    }
}
