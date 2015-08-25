package GraphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class DirectedGraphNode{
	int val;
	List<DirectedGraphNode> neighbors;
	int indegree;
	public DirectedGraphNode(int x){
		this.indegree = 0;
		this.val = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}

class TopologicalSorting {
	/**
	 * Return a path that passes all nodes in the graph
	 * 
	 * @param graph The input graph contains all directed graph nodes
	 * @return The path contains all nodes
	 */
	public static List<Integer> findPath(HashMap<Integer, DirectedGraphNode> graph){
		List<Integer> result = new ArrayList<Integer>();
		//Keep finding next node until we have all nodes
		while(result.size() < graph.size()){
			//Find next 0 in-degree node
			DirectedGraphNode next = findNext(graph);
			//Mark the node's in-degree as -1 means we have already added it into result
			next.indegree = -1;
			//Output current node's value to stdout
			System.out.print(next.val + " ");
			result.add(next.val);
			//Break all edges between current node and its neighbors by
			//decreasing in-degree of all its neighbors by 1
			for(DirectedGraphNode neighbor : next.neighbors){
				if(neighbor.indegree == -1){
					continue;
				}
				neighbor.indegree--;
			}
		}
		System.out.println();
		return result;
	}

	/**
	 * This function will find a node that has not been added to result
	 * and its in-degree is 0.
	 * 
	 * @param graph The input graph contains all directed graph nodes
	 * @return The next 0 in-degree node in the graph
	 */
	private static DirectedGraphNode findNext(HashMap<Integer, DirectedGraphNode> graph){
		for(int key : graph.keySet()){
			DirectedGraphNode cur = graph.get(key);
			//Check if the node we have already added to result
			if(cur.indegree == -1){
				continue;
			}
			//Found target node and return
			if(cur.indegree == 0){
				return cur;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, DirectedGraphNode> graph = new HashMap<Integer, DirectedGraphNode>();
		//Handling input from stdin
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			if(line.equals("")){
				//Call function to get solution
				findPath(graph);
				graph = new HashMap<Integer, DirectedGraphNode>();
			}else{
				String[] data = line.split(",");
				int start = Integer.parseInt(data[0]);
				int end = Integer.parseInt(data[1]);
				//Building directed graph
				if(!graph.containsKey(start)){
					graph.put(start, new DirectedGraphNode(start));
				}
				if(!graph.containsKey(end)){
					graph.put(end, new DirectedGraphNode(end));
				}
				//System.out.println("start: " + start + " end: " + end + " size: " + graph.size());
				//Add destination node to start node's neighbors
				graph.get(start).neighbors.add(graph.get(end));
				//Update in-degree of destination node
				graph.get(end).indegree++;
			}
		}
	}
}
